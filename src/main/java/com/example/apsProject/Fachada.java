package com.example.apsProject;

import com.example.apsProject.controlador.RoomControlador;
import com.example.apsProject.controlador.UserControlador;
import com.example.apsProject.model.Room;
import com.example.apsProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Fachada {

    @Autowired
    RoomControlador roomControlador;

    @Autowired
    UserControlador userControlador;

    public List<Room> getRooms() throws IOException {
        return roomControlador.getRooms();
    }

    public void addUser(User user, int i) {
        userControlador.addUser(user, i);
    }

    public void addRoom(Room r) {
        roomControlador.addRoom(r);
    }
}
