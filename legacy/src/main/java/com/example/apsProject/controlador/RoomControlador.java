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
    UserRepository userRepository;

    @Autowired
    UserControlador userControlador;

    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Room> getAllRooms(){
        return (List<Room>) roomRepository.findAll();
    }

    public List<Room> getRooms() throws IOException {
        List<Room> rooms = new ArrayList<>();
        rooms = (List<Room>) roomRepository.findAll();
        for (Room room : rooms) {
            room.setUsers(userControlador.getUserByRoom(room.getId()));
            room.setKey(getKey(room.getId()));
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
        Room room = roomRepository.findById(i);
        if (room != null) {
            return room.getMaxroom() == userRepository.findByRoom(i).size();
        }
        return false;
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

    public void addRoom(Room r){
        roomRepository.save(r);
    }

    public void deleteRoom(int i) throws Exception {
        Room r = roomRepository.findById(i);
        if(r != null){
            roomRepository.delete(r);
        }else{
            throw new Exception("Room not found!");
        }
    }
}
