package com.example.apsProject.repository;

import com.example.apsProject.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends CrudRepository<Room, Long> {
    Room findById(int i);
}
