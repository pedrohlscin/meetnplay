package com.example.apsProject.model;

import javax.persistence.*;
import java.util.Observable;
import java.util.Random;

@Entity(name="NORMAL_USER")
@IdClass(UserPk.class)
public class User extends Observable {

    @Id
    private String name;
    @Id
    private int code;

    @Transient
    Random random = new Random();

    public User() {}

    public User(String name) {
        this.name = name;
        this.code = random.nextInt(100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
