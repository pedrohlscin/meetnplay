package com.meetnplay.loginservice.communication;

import com.meetnplay.loginservice.model.login.LoginController;
import com.meetnplay.loginservice.model.login.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/login")
public class LoginMVCController {

    @Autowired
    private LoginController controller;

    @GetMapping("")
    public String getLogin(Model model){
        model.addAttribute("logins", controller.getAll());
        return "login.html";
    }

    @PostMapping("/createLogin")
    @ResponseBody
    public boolean createLogin(
//            @ModelAttribute LoginDTO loginDTO
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "password") String password
    ){
        LoginDTO l = new LoginDTO(Long.parseLong(accountId), password);
        controller.create(l);
        return true;
    }
}
