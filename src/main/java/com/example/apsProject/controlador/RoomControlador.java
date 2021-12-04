package com.example.apsProject.controlador;

import com.example.apsProject.cadastro.RoomCadastro;
import com.example.apsProject.cadastro.UserCadastro;
import com.example.apsProject.model.GameKey;
import com.example.apsProject.model.Room;
import com.example.apsProject.roomState.Context;
import com.example.apsProject.roomState.FullState;
import com.example.apsProject.roomState.StartState;
import com.example.apsProject.roomState.State;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomControlador {

    @Autowired
    RoomCadastro roomCadastro;

    @Autowired
    UserCadastro userCadastro;

    @Autowired
    Context context;

    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Room> getRooms() throws IOException {
        List<Room> rooms = new ArrayList<>();
        rooms = (List<Room>) roomCadastro.findAll();
        for (Room room : rooms) {
            room.setUsers(userCadastro.findByRoom(room.getId()));
            if(room.getGamekey() == null || room.getGamekey().contains("Comunicacao")){
                context.setState(new StartState());
                room.setGamekey(getKey(room.getId()));
                roomCadastro.save(room);
            }
        }
        return rooms;
    }

    public String getKey(int i) throws IOException {
        if (isRoomFull(i)) {
            context.setState(new FullState());
            String key = context.getState().getKey();
            return key;
        }
        return context.getState().getKey();
    }

    private boolean isRoomFull(int i) {
        Room room = roomCadastro.findById(i);
        if (room != null) {
            return room.getMaxroom() == userCadastro.findByRoom(i).size();
        }
        return false;
    }

    public void addRoom(Room r){
        roomCadastro.save(r);
    }
}
