package com.peiyuzhen.pms.service;

import com.peiyuzhen.pms.domain.Room;

import java.util.List;

public interface RoomService {
    void delRoom(String roomId);

    List<Room> findRoomsByOwnerId(String ownerId);

    int findRoomCountByOwnerId(String ownerId);

    void addRoom(Room room);
}
