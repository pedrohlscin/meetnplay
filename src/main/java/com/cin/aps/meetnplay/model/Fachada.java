package com.cin.aps.meetnplay.model;

import com.cin.aps.meetnplay.model.user.User;
import com.cin.aps.meetnplay.model.user.UserControlador;

import java.util.List;

public class Fachada {

    private UserControlador userControlador;

    public List<User> getUser(){
        return userControlador.getUsers();
    }

    public void addUser(User user){
        userControlador.addUser(user);
    }
}
