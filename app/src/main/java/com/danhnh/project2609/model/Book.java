package com.danhnh.project2609.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private String description;
    private List<String> authors;
    private String language;
    private Date publishedDate;
    private String genres;
    private List<String> translator;
    private float  price;
    private int image;
    private List<Integer> detailImage;

    public Book() {
    }

    public Book(String isbn, String title, String description, ArrayList<String> authors, String language, Date publishedDate, String genres, ArrayList<String> translator, float price, int image) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.language = language;
        this.publishedDate = publishedDate;
        this.genres = genres;
        this.translator = translator;
        this.price = price;
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<Integer> getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(List<Integer> detailImage) {
        this.detailImage = detailImage;
    }
}
