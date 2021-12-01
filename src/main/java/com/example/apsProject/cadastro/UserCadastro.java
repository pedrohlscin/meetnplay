package com.example.apsProject.cadastro;

import com.example.apsProject.model.Room;
import com.example.apsProject.model.User;
import com.example.apsProject.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCadastro {

    @Autowired
    private IUserRepository iUserRepository;

    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    public void save(User user) {
        iUserRepository.save(user);
    }

    public List<User> findByRoom(int i) {
        return iUserRepository.findByRoom(i);
    }
}
