package com.example.apsProject.roomState;


import org.springframework.stereotype.Component;


public class StartState implements State{
    public void doAction(Context context){
        context.setState(this);
    }

    public String getKey(){
        return null;
    }
}
