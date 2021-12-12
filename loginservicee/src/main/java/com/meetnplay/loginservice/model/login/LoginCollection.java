package com.meetnplay.loginservice.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginCollection {

    @Autowired
    private ILoginRepository repository;

    public void insert(Login l){
        repository.insert(l);
    }

    public void remove(Long id) {
        repository.remove(id);
    }

    public Iterable<Login> getAll() {
        return repository.getAll();
    }

    public Login get(Long id) {
        return repository.get(id);
    }
}
