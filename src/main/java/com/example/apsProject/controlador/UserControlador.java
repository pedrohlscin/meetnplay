package com.example.apsProject.controlador;

import com.example.apsProject.cadastro.RoomCadastro;
import com.example.apsProject.cadastro.UserCadastro;
import com.example.apsProject.model.User;
import com.example.apsProject.repository.IRoomRepository;
import com.example.apsProject.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserControlador {

    @Autowired
    private UserCadastro userCadastro;

    @Autowired
    private RoomCadastro roomCadastro;

    RoomControlador roomControlador = new RoomControlador();

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userCadastro.findAll().forEach(users::add);
        return users;
    }

    public List<User> findByRoom(int i) {
        return userCadastro.findByRoom(i);
    }

    public void addUser(User user, int i) {
        if (!(findByRoom(i).size() == roomCadastro.findById(i).getMaxroom())) {
            userCadastro.save(user);
        } else {
            System.out.println("sala ja se encontra cheia");
        }
    }
}
