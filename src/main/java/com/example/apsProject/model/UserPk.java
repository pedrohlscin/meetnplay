package com.example.apsProject.model;

import java.io.Serializable;

public class UserPk implements Serializable {

    private String name;
    private int code;

    public UserPk() {
    }

    public UserPk(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
