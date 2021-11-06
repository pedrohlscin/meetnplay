package com.cin.aps.meetnplay.model.user;

import java.util.ArrayList;
import java.util.List;

public class UserCadastro {
    private List<User> users;

    public UserCadastro() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public  List<User> getAll() {
        return this.users;
    }

    public void add(User user) {
        this.users.add(user);
    }
}
