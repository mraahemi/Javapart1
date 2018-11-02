package org.mraahemi.bookstore.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

public class Categories
{

    @JsonProperty("Categories")
    public List<Category> Categories;

    public Categories()
    {
        new LinkedList<>();
    }

    public Categories(List<Category> Categories)
    {
        this.Categories = Categories;
    }

}
