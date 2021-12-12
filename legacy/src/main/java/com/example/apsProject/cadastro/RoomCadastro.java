package com.example.apsProject.cadastro;

import com.example.apsProject.model.Room;
import com.example.apsProject.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomCadastro {

    @Autowired
    private IRoomRepository roomRepository;


    public List<Room> findAll() {
        return (List<Room>) roomRepository.findAll();
    }

    public Room findById(int i) {
        return roomRepository.findById(i);
    }

    public void save(Room r) {
        roomRepository.save(r);
    }
}
