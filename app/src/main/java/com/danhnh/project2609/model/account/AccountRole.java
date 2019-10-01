package com.danhnh.project2609.model.account;

import java.io.Serializable;

public class AccountRole implements Serializable {
    private int id;
    private String name;

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

    public AccountRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public AccountRole() {
    }
}
