package com.example.nhom2projectmd3.model;

import java.util.List;

public class Author {

    private int id;
    private String name;
    private List<Category> categoryList;

    public Author() {
    }

    public Author(int id, String name, List<Category> categoryList) {
        this.id = id;
        this.name = name;
        this.categoryList = categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
