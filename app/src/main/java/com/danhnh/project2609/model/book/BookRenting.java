package com.danhnh.project2609.model.book;

import com.danhnh.project2609.model.book.Book;
import com.danhnh.project2609.model.book.bookdetails.Cover;

import java.io.Serializable;
import java.util.List;

public class BookRenting implements Serializable {
    private String barcode;
    private Book book;
    private float price;
    private int quantity;
    private List<String> imageURLs;
    private float width;
    private float height;
    private float weight;
    private int pages;
    private Cover cover;

    public BookRenting(String barcode, Book book, float price, int quantity, List<String> imageURLs, float width, float height, float weight, int pages, Cover cover) {
        this.barcode = barcode;
        this.book = book;
        this.price = price;
        this.quantity = quantity;
        this.imageURLs = imageURLs;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.pages = pages;
        this.cover = cover;
    }

    public BookRenting() {
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(List<String> imageURLs) {
        this.imageURLs = imageURLs;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }
}
