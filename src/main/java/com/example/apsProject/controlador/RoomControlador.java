package com.example.apsProject.controlador;

import com.example.apsProject.cadastro.RoomCadastro;
import com.example.apsProject.cadastro.UserCadastro;
import com.example.apsProject.model.GameKey;
import com.example.apsProject.model.Room;
import com.example.apsProject.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomControlador {

    @Autowired
    RoomCadastro roomCadastro;

    @Autowired
    UserCadastro userCadastro;

    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Room> getRooms() throws IOException {
        List<Room> rooms = new ArrayList<>();
        rooms = (List<Room>) roomCadastro.findAll();
        for (Room room : rooms) {
            room.setUsers(userCadastro.findByRoom(room.getId()));
            if(room.getGamekey() == null || room.getGamekey().contains("Comunicacao")){
                room.setGamekey(getKey(room.getId()));
                roomCadastro.save(room);
            }
        }
        return rooms;
    }

    public String getKey(int i) throws IOException {
        if (isRoomFull(i)) {
            return gameAutentication();
        }
        return null;
    }

    private boolean isRoomFull(int i) {
        Room room = roomCadastro.findById(i);
        if (room != null) {
            return room.getMaxroom() == userCadastro.findByRoom(i).size();
        }
        return false;
    }

    public static String gameAutentication() throws IOException {
        try {
            GameKey gameKey = mapper.readValue(new URL("http://localhost:5000"), GameKey.class);
            System.out.println("" + gameKey.getKey());
            return gameKey.getKey();
        } catch (ConnectException e) {
            String error = "Comunicacao com a API de jogo falhou";
            return error;
        }
    }

    public void addRoom(Room r){
        roomCadastro.save(r);
    }
}
