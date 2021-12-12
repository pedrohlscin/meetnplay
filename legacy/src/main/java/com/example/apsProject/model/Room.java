package com.example.apsProject.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int maxroom;
    private String gamekey;

    @Transient
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxroom() {
        return maxroom;
    }

    public void setMaxroom(int maxroom) {
        this.maxroom = maxroom;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getGamekey() {
        return gamekey;
    }

    public void setGamekey(String gamekey) {
        this.gamekey = gamekey;
    }
}
