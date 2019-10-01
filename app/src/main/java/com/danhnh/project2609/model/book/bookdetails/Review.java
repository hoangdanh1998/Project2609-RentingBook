package com.danhnh.project2609.model.book.bookdetails;

import com.danhnh.project2609.model.account.Customer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Review implements Serializable {
    private int id;
    private Customer customer;
    private int rate;
    private String comment;
    private LocalDateTime dateTime;

    public Review() {
    }

    public Review(int id, Customer customer, int rate, String comment, LocalDateTime dateTime) {
        this.id = id;
        this.customer = customer;
        this.rate = rate;
        this.comment = comment;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
