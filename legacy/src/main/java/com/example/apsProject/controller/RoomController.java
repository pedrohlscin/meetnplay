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
<<<<<<< HEAD:legacy/src/main/java/com/example/apsProject/controller/RoomController.java
    public String getRoom(Model model) {
        model.addAttribute("rooms", roomControlador.getAllRooms());
=======
    public String getRoom(Model model) throws IOException {
        model.addAttribute("rooms", fachada.getRooms());
>>>>>>> 9160c4ec3a78b2c35abc805c12603a2130e17e4c:src/main/java/com/example/apsProject/controller/RoomController.java
        return "room";
    }

    @PostMapping("inserir")
    public String inserir(@RequestParam(name = "tamanhoRoom") String tamanhoRoom){
        int i = Integer.parseInt(tamanhoRoom);
        Room r = new Room();
        r.setMaxroom(i);
<<<<<<< HEAD:legacy/src/main/java/com/example/apsProject/controller/RoomController.java
        roomControlador.addRoom(r);
        return "redirect:/room";
    }

    @PostMapping("remover")
    public String remover(@RequestParam(name = "roomId") String roomId){
        int i = Integer.parseInt(roomId);
        try{
            roomControlador.deleteRoom(i);
        } catch (Exception e){
            e.printStackTrace();
        }
=======
        fachada.addRoom(r);
>>>>>>> 9160c4ec3a78b2c35abc805c12603a2130e17e4c:src/main/java/com/example/apsProject/controller/RoomController.java
        return "redirect:/room";
    }
}
