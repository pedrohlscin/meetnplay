package com.example.apsProject.controlador;

import com.example.apsProject.model.Room;
import com.example.apsProject.model.User;
import com.example.apsProject.repository.RoomRepository;
import com.example.apsProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserControlador {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    RoomControlador roomControlador = new RoomControlador();

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public String getKey(int i) throws IOException {
        if (isRoomFull(i)) {
            return roomControlador.gameAutentication();
        }
        return null;
    }

    private boolean isRoomFull(int i) {
        Room room = roomRepository.findById(i);
        if (room != null) {
            return room.getMaxroom() == userRepository.findByRoom(i).size();
        }
        return false;
    }

    public List<User> getUserByRoom(int i) {
        return userRepository.findByRoom(i);
    }
}
