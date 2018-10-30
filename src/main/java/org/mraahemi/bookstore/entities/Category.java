package org.mraahemi.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category
{

    @JsonProperty("name")
    public String name;

    @JsonProperty("id")
    public int id;

    public Category()
    {
        this.name = "test";
        this.id = 1;
    }

    public Category(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
    
    public Category(String name)
    {
        this.name = name;

    }

}