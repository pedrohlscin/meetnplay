package com.example.apsProject.model;

import javax.persistence.*;
import java.util.Random;

@Entity(name = "NORMAL_USER")
@IdClass(UserPk.class)
public class User {

    @Id
    private String name;
    @Id
    private int code;
    private int room;

    @Transient
    Random random = new Random();

    public User() {
    }

    public User(String name, int room) {
        this.name = name;
        this.code = random.nextInt(1000);
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
