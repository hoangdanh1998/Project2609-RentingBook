package com.danhnh.project2609.model;

import java.util.ArrayList;

public class SectionBook {
    private String title;
    private ArrayList<Book> BooksOfTitle;

    public SectionBook(String title, ArrayList<Book> booksOfTitle) {
        this.title = title;
        BooksOfTitle = booksOfTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Book> getBooksOfTitle() {
        return BooksOfTitle;
    }

    public void setBooksOfTitle(ArrayList<Book> booksOfTitle) {
        BooksOfTitle = booksOfTitle;
    }
}
