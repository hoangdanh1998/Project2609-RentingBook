package com.danhnh.project2609.model.order;

import com.danhnh.project2609.model.account.Account;
import com.danhnh.project2609.model.book.BookRenting;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class BookOrder implements Serializable {
    private int id;
    private LocalDateTime createdDateTime;
    private Account account;
    private String status;
    private List<BookRenting> books;
    private float shippingFee;

    public BookOrder() {
    }

    public BookOrder(int id, LocalDateTime createdDateTime, Account account, String status, List<BookRenting> books, float shippingFee) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.account = account;
        this.status = status;
        this.books = books;
        this.shippingFee = shippingFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BookRenting> getBooks() {
        return books;
    }

    public void setBooks(List<BookRenting> books) {
        this.books = books;
    }

    public float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(float shippingFee) {
        this.shippingFee = shippingFee;
    }
}
