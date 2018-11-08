package org.mraahemi.bookstore.services;

import org.codehaus.jackson.map.ObjectMapper;
import org.mraahemi.bookstore.entities.Book;
import org.mraahemi.bookstore.entities.Books;
import org.mraahemi.bookstore.entities.Categories;
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

import javax.swing.JTextPane;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


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
    	CategoryDao dao = new CategoryDao();
        try
        {
            String categorysj = objectMapper.writeValueAsString(dao.getCategories());
            
            File file = new File ("E:\\University\\uOttawa\\System and Architecture\\FinalProject\\bookstore\\src\\main\\webapp\\data.json");
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bytesArray = categorysj.getBytes();
            fos.write(bytesArray);
            fos.flush();
            return Response.status(Status.OK).entity(categorysj).build();
            
            
        }
        catch (Exception e)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        
    }
}