package com.peiyuzhen.pms.service.impl;

import com.peiyuzhen.pms.domain.Room;
import com.peiyuzhen.pms.repository.RoomRepository;
import com.peiyuzhen.pms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public void delRoom(String roomId) {
        roomRepository.delRoomById(roomId);
    }

    @Override
    public List<Room> findRoomsByOwnerId(String ownerId) {
        return roomRepository.findRoomsByOwnerId(ownerId);
    }

    @Override
    public int findRoomCountByOwnerId(String ownerId) {
        return roomRepository.findRoomCountByOwnerId(ownerId);
    }

    @Override
    public void addRoom(Room room) {
        roomRepository.saveAndFlush(room);
    }
}
