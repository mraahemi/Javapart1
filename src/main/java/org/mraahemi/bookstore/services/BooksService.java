package org.mraahemi.bookstore.services;

import org.codehaus.jackson.map.ObjectMapper;
import org.mraahemi.bookstore.entities.Book;
import org.mraahemi.bookstore.entities.Books;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Path("/book")
@Component
@Scope("request")
public class BooksService
{

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getBooks(@PathParam("id") String id)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/bookstore_db",
                                   "postgres", "root");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT title FROM book where bookid='" + id + "';");
            List<Book> titles = new LinkedList<>();
            while (rs.next())
            {
                titles.add(new Book(rs.getString("title")));
            }
            rs.close();
            stmt.close();
            c.close();

            System.out.println("Operation done successfully");
            String booksj = objectMapper.writeValueAsString(new Books(titles));
            return Response.status(Response.Status.OK).entity(booksj).build();
        }
        catch (Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }
}