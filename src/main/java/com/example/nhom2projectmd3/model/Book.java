package com.example.nhom2projectmd3.model;

import java.util.Date;
import java.util.List;

public class Book {

    private int id;
    private String name;
    private List<Category> categoryList;
    private Author author;
    private int price;
    private String image;
    private Date releaseDate;
    private String note;

    public Book() {
    }

    public Book(int id, String name, List<Category> categoryList, Author author, int price, String image, Date releaseDate, String note) {
        this.id = id;
        this.name = name;
        this.categoryList = categoryList;
        this.author = author;
        this.price = price;
        this.image = image;
        this.releaseDate = releaseDate;
        this.note = note;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
