package com.example.apsProject.observer;

import com.example.apsProject.model.User;

import java.util.Observable;
import java.util.Observer;

public class UserObserver implements Observer {
    private User userName;

    @Override
    public void update(Observable observable, Object arg){
        userName = (User) observable;
        System.out.println("Nome atual do user é: " +userName.getName());
    }
}
