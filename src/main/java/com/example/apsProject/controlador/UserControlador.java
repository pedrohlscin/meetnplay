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

    public List<User> getUserByRoom(int i) {
        return userRepository.findByRoom(i);
    }

    public void addUser(User user, int i) throws IOException {
        if (!(getUserByRoom(i).size() == roomRepository.findById(i).getMaxroom())) {
            userRepository.save(user);
        } else {
            System.out.println("sala ja se encontra cheia");
        }
    }
}
