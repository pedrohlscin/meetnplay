package com.example.apsProject.repository;

import com.example.apsProject.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
    @Query("select u.room from NORMAL_USER u")
    List<String> getRoom();

    List<User> findByRoom(int room);
}
