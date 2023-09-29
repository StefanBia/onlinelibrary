package com.example.OnlineLibrary.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private String author;
    private int nrPages;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String bookCode;

    public Book() {}
    public Book(String name, String author, int nrPages, String imageUrl, String bookCode){
        this.name = name;
        this.author = author;
        this.nrPages = nrPages;
        this.imageUrl = imageUrl;
        this.bookCode = bookCode;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getNrPages(){
        return nrPages;
    }
    public String getImageUrl(){
        return imageUrl;
    }
    public String getBookCode(){
        return bookCode;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setNrPages(int nrPages){
        this.nrPages = nrPages;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public void setBookCode(String bookCode){

        this.bookCode = bookCode;
    }

    @Override
    public String toString(){
        return "Title: " + name +
                ", Author: " + author +
                " Number of pages: " + nrPages +
                "Image URL: " + imageUrl +
                " Book Code: " + bookCode;
    }

}
