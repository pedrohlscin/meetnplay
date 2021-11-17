package com.example.apsProject.controlador;

import com.example.apsProject.model.GameKey;
import com.example.apsProject.model.Room;
import com.example.apsProject.repository.RoomRepository;
import com.example.apsProject.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomControlador {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserControlador userControlador;

    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms = (List<Room>) roomRepository.findAll();
        for (Room room : rooms) {
            room.setUsers(userControlador.getUserByRoom(room.getId()));
        }
        return rooms;
    }

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
