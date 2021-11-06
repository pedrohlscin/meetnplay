package com.cin.aps.meetnplay.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(path = "/user")
     public String getUsers(){
         return "user";
     }
}
