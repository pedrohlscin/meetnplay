package com.meetnplay.roomservice.model.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomJPARepository implements IRoomRepository {

    @Autowired
    private RoomDAO roomDAO;

    @Override
    public void insert(Room r) {
        roomDAO.save(r);
    }

    @Override
    public void remove(Long id) {
        roomDAO.deleteById(id);
    }

    @Override
    public Iterable<Room> getAll() {
        return roomDAO.findAll();
    }

    @Override
    public Room get(Long id) {
        return roomDAO.findById(id).get();
    }

    @Override
    public void update(Room r) {
        roomDAO.save(r);
    }
}
