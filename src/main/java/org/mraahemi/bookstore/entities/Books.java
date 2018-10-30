package org.mraahemi.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

public class Books
{

    @JsonProperty("books")
    public List<Book> books;

    public Books()
    {
        new LinkedList<>();
    }

    public Books(List<Book> books)
    {
        this.books = books;
    }

}