package com.meetnplay.roomservice.model.room;

import lombok.Value;

@Value
public class RoomDTO {
    private int capacity;

    public Room toEntity(){
        return Room.builder().capacity(capacity).build();
    }
}
