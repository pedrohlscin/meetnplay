package com.meetnplay.loginservice.model.login;

public interface ILoginRepository {

    void insert(Login l);

    void remove(Long id);

    Iterable<Login> getAll();

    Login get(Long id);

    void update(Login l);
}
