package com.example.apsProject.controlador;

import com.example.apsProject.model.GameKey;
import com.example.apsProject.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class RoomControlador {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UserRepository userRepository;

    public static String gameAutentication() throws IOException {
        try {
            GameKey gameKey = mapper.readValue(new URL("http://localhost:5000"), GameKey.class);
            System.out.println("" + gameKey.getKey());
            return gameKey.getKey();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }
}
