package com.example.apsProject.controlador;

import com.example.apsProject.model.User;
import com.example.apsProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserControlador {

    @Autowired
    private UserRepository userRepository;

    RoomControlador roomControlador = new RoomControlador();

    public List<User> getUsers() throws IOException {

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;


//            for (String code : userRepository.getRoom()) {
//                int codeNumber = Integer.parseInt(code);
//                if (code.equals("1")) {
//                    model.addAttribute("roomOne" + code, userRepository.findByRoom(codeNumber));
//                    model.addAttribute("countOne", userRepository.findByRoom(codeNumber).size());
//                    if (userRepository.findByRoom(codeNumber).size() == 10) {
//                        model.addAttribute("gameKeyOne", roomControlador.gameAutentication());
//                    }
//                } else if (code.equals("2")) {
//                    model.addAttribute("roomTwo", userRepository.findByRoom(codeNumber));
//                    model.addAttribute("countTwo", userRepository.findByRoom(codeNumber).size());
//                    if (userRepository.findByRoom(codeNumber).size() == 8) {
//                        model.addAttribute("gameKeyTwo", roomControlador.gameAutentication());
//                    }
//                } else {
//                    model.addAttribute("roomThree", userRepository.findByRoom(codeNumber));
//                    model.addAttribute("countThree", userRepository.findByRoom(codeNumber).size());
//                    if (userRepository.findByRoom(codeNumber).size() == 6) {
//                        model.addAttribute("gameKeyThree", roomControlador.gameAutentication());
//                    }
//                }
//            }
    }

    public String getKey() throws IOException {
        if (userRepository.findByRoom(1).size() == 10) {
            return roomControlador.gameAutentication();
        } else if (userRepository.findByRoom(2).size() == 8) {
            return roomControlador.gameAutentication();
        } else if (userRepository.findByRoom(2).size() == 6) {
            return roomControlador.gameAutentication();
        }
    }
}
