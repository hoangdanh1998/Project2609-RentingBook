package com.danhnh.project2609.model.account;

import com.danhnh.project2609.model.book.BookRenting;
import com.danhnh.project2609.model.order.BookOrder;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
    private int id;
    private Account account;
    private List<BookOrder> orders;
    private List<BookRenting> savedBooks;
}
