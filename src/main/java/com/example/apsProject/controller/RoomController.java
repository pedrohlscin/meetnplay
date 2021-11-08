package com.example.apsProject.controller;

import com.example.apsProject.model.Room;
import com.example.apsProject.model.User;
import com.example.apsProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class RoomController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    int count=0;

    @GetMapping("/user")
    public String getUsers(Model model){
        model.addAttribute("user", userRepository.findAll());
        model.addAttribute("count", userRepository.count());
        return "user";
    }

    @PostMapping("/user/addUser")
    public String addUser(@RequestParam(name = "name") String name, Model model) {
        User user = new User(name);
        userRepository.save(user);
        count++;
        if (count == 6){
            model.addAttribute("roomCode", roomCode());
        }
        return "redirect:/user";
    }

    public List roomCode(){
        List<Room> code = restTemplateBuilder.build().getForObject("http://localhost:5000", List.class);
        return code;
    }


}