package com.example.apsProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity(name = "ROOM")
public class Room {
    @Id
    private int id;
    private int maxroom;

    @Transient
    private List<User> users;

    @Transient
    private String key;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
