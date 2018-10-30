package org.mraahemi.bookstore.services;

import org.codehaus.jackson.map.ObjectMapper;
import org.mraahemi.bookstore.entities.Book;
import org.mraahemi.bookstore.entities.Books;
import org.mraahemi.bookstore.entities.Category;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/category")
@Component
@Scope("request")
public class CategoryService
{

    @GET
    @Produces("application/json")
    public Response getCategories()
    {
    	ObjectMapper objectMapper = new ObjectMapper();
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;
        /*try
        {
            Class.forName("org.postgresql.Driver");
            
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/bookstore_db",
                                   "postgres", "root");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT category_type FROM category;");
            List<Category> titles = new LinkedList<>();
            while (rs.next())
            {
            	titles.add(new Category(rs.getString("category_type")));
            }
            
            
            rs.close();
            stmt.close();
            c.close();

            System.out.println("Operation done successfully");
            String booksj = objectMapper.writeValueAsString(titles);
            return Response.status(Status.OK).entity(new Category(booksj)).build();
        }
        catch (Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        //return Response.status(Status.OK).entity(new Category()).build();*/
        
        try {
			// Register JDBC driver
			
			Class.forName("com.mysql.jdbc.Driver");
		

			// Open a connection
			c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/bookstore_db",
                                   "postgres", "root");

			// Execute SQL query
			stmt = c.createStatement();
			String sql;
			sql = "SELECT * from category";
			rs = stmt.executeQuery(sql);

			// Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int category_id  = rs.getInt("category_id");
				String category_type  = rs.getString("category_type");
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			c.close();
			String category_out = objectMapper.writeValueAsString(new Category(category_type));
            return Response.status(Status.OK).entity(new Category(category_out)).build();
		} catch (Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}