package com.example.apsProject;

import com.example.apsProject.controlador.RoomControlador;
import com.example.apsProject.controlador.UserControlador;
import com.example.apsProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Fachada {

    @Autowired
    RoomControlador roomControlador;

    @Autowired
    UserControlador userControlador;

    public List<User> getUsers() {
        return userControlador.getUsers();
    }
}
