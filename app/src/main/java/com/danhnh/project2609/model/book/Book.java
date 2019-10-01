package com.danhnh.project2609.model.book;

import com.danhnh.project2609.model.book.bookdetails.Genre;
import com.danhnh.project2609.model.book.bookdetails.Language;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book implements Serializable {
    private String isbn;
    private String title;
    private String description;
    private List<String> authors;
    private Language language;
    private List<String> translators;
    private List<Genre> genres;
    private LocalDate publishedDate;

    public Book() {
    }

    public Book(String isbn, String title, String description, List<String> authors, Language language, List<String> translators, List<Genre> genres, LocalDate publishedDate) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.language = language;
        this.translators = translators;
        this.genres = genres;
        this.publishedDate = publishedDate;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<String> getTranslators() {
        return translators;
    }

    public void setTranslators(List<String> translators) {
        this.translators = translators;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
