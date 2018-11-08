package org.mraahemi.bookstore.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.mraahemi.bookstore.entities.Book;
import org.mraahemi.bookstore.entities.Books;
import org.mraahemi.bookstore.entities.Categories;
import org.mraahemi.bookstore.entities.Category;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.codehaus.jackson.map.ObjectMapper;

public class CategoryDao {
	
	public Categories getCategories()
    {
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
            rs = stmt.executeQuery("SELECT * FROM category;");
            List<Category> titles = new LinkedList<>();
            while (rs.next())
            {
               titles.add(new Category(rs.getString("category_type"), rs.getString("category_id")));
            }

            
            rs.close();
            stmt.close();
            c.close();

            Categories cats = new Categories(titles);
            System.out.println("Operation done successfully");
            return cats;
    }catch (Exception e)
        {
        throw e;
    
        }
    }
}
