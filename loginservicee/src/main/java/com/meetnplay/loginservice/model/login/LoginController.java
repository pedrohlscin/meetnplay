package com.meetnplay.loginservice.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @Autowired
    private LoginCollection loginCollection;

    public void create(LoginDTO loginDTO){
        loginCollection.insert(loginDTO.toEntity());
    }

    public Iterable<Login> getAll(){
        return loginCollection.getAll();
    }

    public void delete(Long id){
        loginCollection.remove(id);
    }
}
