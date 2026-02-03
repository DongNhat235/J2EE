package com.example.bookapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private Long id;
    
    @JsonProperty("title")
    private String name;
    
    private String author;

    public Book() {
    }

    public Book(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getName() {
        return name;
    }

    @JsonProperty("title")
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
