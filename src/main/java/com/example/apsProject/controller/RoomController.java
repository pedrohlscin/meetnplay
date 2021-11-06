package com.example.apsProject.controller;

import com.example.apsProject.model.User;
import com.example.apsProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RoomController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/user")
    public String getUsers(Model model){
        model.addAttribute("user", userRepository.findAll());
        return "user";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/user";
    }

    // additional CRUD methods
}