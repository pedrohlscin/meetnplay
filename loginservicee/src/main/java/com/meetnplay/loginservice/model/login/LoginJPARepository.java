package com.meetnplay.loginservice.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginJPARepository implements ILoginRepository{

    @Autowired
    private LoginDao loginDao;

    @Override
    public void insert(Login l) {
        loginDao.save(l);
    }

    @Override
    public void remove(Long id) {
        loginDao.deleteById(id);
    }

    @Override
    public Iterable<Login> getAll() {
        return loginDao.findAll();
    }

    @Override
    public Login get(Long id) {
        return loginDao.findById(id).get();
    }

    @Override
    public void update(Login l) {
        loginDao.save(l);
    }
}
