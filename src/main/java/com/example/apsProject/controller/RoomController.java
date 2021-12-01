package com.example.apsProject.controller;

import com.example.apsProject.Fachada;
import com.example.apsProject.controlador.RoomControlador;
import com.example.apsProject.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("room")
public class RoomController {

    @Autowired
    private Fachada fachada;

    @GetMapping("")
    public String getRoom(Model model) throws IOException {
        model.addAttribute("rooms", fachada.getRooms());
        return "room";
    }

    @PostMapping("inserir")
    public String inserir(@RequestParam(name = "tamanhoRoom") String tamanhoRoom){
        int i = Integer.parseInt(tamanhoRoom);
        Room r = new Room();
        r.setMaxroom(i);
        fachada.addRoom(r);
        return "redirect:/room";
    }
}
