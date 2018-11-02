package org.mraahemi.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category
{

    @JsonProperty("name")
    public String name;

   @JsonProperty("id")
   public String id;

    public Category()
    {
        this.name = "test";
        this.id = "1";
    }

    public Category(String name, String id)
    {
        this.name = name;
        this.id = id;
    }
    
}