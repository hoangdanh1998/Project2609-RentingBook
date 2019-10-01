package com.danhnh.project2609.model;

import com.danhnh.project2609.model.book.Book;
import com.danhnh.project2609.model.book.BookRenting;

import java.util.ArrayList;

public class SectionBook {
    private String title;
    private ArrayList<BookRenting> BooksOfTitle;

    public SectionBook(String title, ArrayList<BookRenting> booksOfTitle) {
        this.title = title;
        BooksOfTitle = booksOfTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<BookRenting> getBooksOfTitle() {
        return BooksOfTitle;
    }

    public void setBooksOfTitle(ArrayList<BookRenting> booksOfTitle) {
        BooksOfTitle = booksOfTitle;
    }
}
