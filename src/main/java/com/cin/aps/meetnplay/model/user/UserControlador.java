package com.cin.aps.meetnplay.model.user;

import java.util.List;

public class UserControlador {
    private UserCadastro userCadastro;

    public UserControlador(UserCadastro userCadastro) {
        this.userCadastro = userCadastro;
    }

    public UserCadastro getUserCadastro() {
        return userCadastro;
    }

    public void setUserCadastro(UserCadastro userCadastro) {
        this.userCadastro = userCadastro;
    }

    public List<User> getUsers() {
        return userCadastro.getAll();
    }

    public void addUser(User user) {
        userCadastro.add(user);
    }
}
