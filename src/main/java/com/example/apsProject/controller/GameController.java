package com.example.apsProject.controller;

import com.example.apsProject.controlador.RoomControlador;
import com.example.apsProject.controlador.UserControlador;
import com.example.apsProject.model.User;
import com.example.apsProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class GameController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoomControlador roomControlador;

    @Autowired
    UserControlador userControlador;

    @GetMapping("/user")
    public String getUsers(Model model) throws IOException {
        model.addAttribute("rooms", roomControlador.getRooms());
        return "user";
    }

    @PostMapping("/user/addUser")
    public String addRoom(@RequestParam(name = "name") String name, @RequestParam(name = "room") String room) {
        User user = new User(name, Integer.parseInt(room));
        userRepository.save(user);
        return "redirect:/user";
    }
}