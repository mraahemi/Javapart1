package org.mraahemi.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book
{

    @JsonProperty("name")
    public String name;

    public Book()
    {
        this.name = "test";
    }

    public Book(String name)
    {
        this.name = name;
    }

}