package com.example.apsProject.controller;

import com.example.apsProject.Fachada;
import com.example.apsProject.controlador.RoomControlador;
import com.example.apsProject.controlador.UserControlador;
import com.example.apsProject.model.User;
import com.example.apsProject.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class UserController {

    @Autowired
    private Fachada fachada;

    @GetMapping("/user")
    public String getUsers(Model model) throws IOException {
        model.addAttribute("rooms", fachada.getRooms());
        return "user";
    }

    @PostMapping("/user/addUser")
    public String addUser(@RequestParam(name = "name") String name, @RequestParam(name = "room") String room) throws IOException {
        int i = Integer.parseInt(room);
        User user = new User(name, i);
        fachada.addUser(user, i);
        return "redirect:/user";
    }
}