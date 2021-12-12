package com.meetnplay.roomservice.model.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCollection {

    @Autowired
    private IRoomRepository repository;

    public void insert(Room room) {
        repository.insert(room);
    }

    public void remove(Long id) {
        repository.remove(id);
    }

    public Iterable<Room> getAll() {
        return repository.getAll();
    }

    public Room get(Long id) {
        return repository.get(id);
    }

}
