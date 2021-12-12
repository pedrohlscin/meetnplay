package com.meetnplay.roomservice.communication;

import com.meetnplay.roomservice.model.room.RoomController;
import com.meetnplay.roomservice.model.room.RoomDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
@Slf4j
public class RoomMVCController {

    @Autowired
    private RoomController controller;

    @Value("${base_url}")
    private String baseUrl;

    @ModelAttribute("baseUrl")
    public String getUrl(){
        return this.baseUrl;
    }

    @GetMapping("")
    public String getRoom(Model model) {
        model.addAttribute("rooms", controller.getAll());
        return "room";
    }

    @GetMapping("/form")
    public String getAccountForm() {
        return "room_form";
    }

    @PostMapping("/form")
    public String inserir(@ModelAttribute RoomDTO roomDto){
        controller.create(roomDto);
        return "redirect:/room";
    }

    @PostMapping("/delete")
    public String deletar(@RequestParam(name = "roomId") String roomId){
        controller.delete(Long.parseLong(roomId));
        return "redirect:/room";
    }
}