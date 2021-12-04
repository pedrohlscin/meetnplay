package com.example.apsProject.roomState;

import com.example.apsProject.model.GameKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;

public class FullState implements State{

    public void doAction(Context context){
        context.setState(this);
    }

    public String getKey() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        try {
            GameKey gameKey = mapper.readValue(new URL("http://localhost:5000"), GameKey.class);
            System.out.println("" + gameKey.getKey());
            return gameKey.getKey();
        } catch (ConnectException | MalformedURLException e) {
            String error = "Comunicacao com a API de jogo falhou";
            return error;
        }
    }
}
