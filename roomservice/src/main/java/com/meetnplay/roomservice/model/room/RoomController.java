package com.meetnplay.roomservice.model.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomController {

    @Autowired private RoomCollection RoomCollection;

    public void create(RoomDTO roomDTO) {
        RoomCollection.insert(roomDTO.toEntity());
    }

    public Iterable<Room> getAll() {
        return RoomCollection.getAll();
    }

    public void delete(Long id) { RoomCollection.remove(id); }
}
