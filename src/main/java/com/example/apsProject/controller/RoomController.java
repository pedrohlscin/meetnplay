package com.example.apsProject.controller;

import com.example.apsProject.controlador.RoomControlador;
import com.example.apsProject.controlador.UserControlador;
import com.example.apsProject.model.User;
import com.example.apsProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;


@Controller
public class RoomController {

    @Autowired
    private UserRepository userRepository;

    RoomControlador roomControlador = new RoomControlador();

    UserControlador userControlador = new UserControlador();

    @GetMapping("/user")
    public String getUsers(Model model) throws IOException {
        //model.addAttribute("user", userControlador.getUsers());
        model.addAttribute("user", userRepository.findAll());

        model.addAttribute("gameKeyOne", userControlador.getKeyOne());
        model.addAttribute("gameKeyTwo", userControlador.getKeyTwo());
        model.addAttribute("gameKeyThree", userControlador.getKeyThree());
        return "user";
    }

    @PostMapping("/user/addRoomOne")
    public String addRoomOne(@RequestParam(name = "name") String name) {
        User user = new User(name, 1);
        userRepository.save(user);
        return "redirect:/user";
    }

    @PostMapping("/user/addRoomTwo")
    public String addRoomTwo(@RequestParam(name = "name") String name) {
        User user = new User(name, 2);
        userRepository.save(user);
        return "redirect:/user";
    }

    @PostMapping("/user/addRoomThree")
    public String addRoomThree(@RequestParam(name = "name") String name) {
        User user = new User(name, 3);
        userRepository.save(user);
        return "redirect:/user";
    }

    //    @GetMapping("/user")
    //    public String getUsers(Model model) {
    //
    //
    //        model.addAttribute("room", userRepository.getRoom());
    //
    //        for (String code : userRepository.getRoom()) {
    //            int codeNumber = Integer.parseInt(code);
    //            model.addAttribute("user" + code, userRepository.findByRoom(codeNumber));
    //            model.addAttribute("count", userRepository.count());
    //        }
    //        return "user";
    //    }
}