package com.danhnh.project2609.model.book.bookdetails;

import java.io.Serializable;

public class Author implements Serializable {
    private int id;
    private String name;
    private String biography;
    private String avatarURL;

    public Author() {
    }

    public Author(int id, String name, String biography, String avatarURL) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.avatarURL = avatarURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }
}
