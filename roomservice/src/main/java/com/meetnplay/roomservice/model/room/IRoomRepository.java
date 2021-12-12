package com.meetnplay.roomservice.model.room;

public interface IRoomRepository {
    void insert(Room r);

    void remove(Long id);

    Iterable<Room> getAll();

    Room get(Long id);

    void update(Room r);
}
