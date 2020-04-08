package com.peiyuzhen.pms.repository;

import com.peiyuzhen.pms.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query(nativeQuery = true,value = "update room set is_del=1 where room_id=?1")
    @Modifying
    @Transactional
    void delRoomById(String roomId);
    @Query(nativeQuery = true,value = "select * from room where owner_id=?1 and is_del=0")
    List<Room> findRoomsByOwnerId(String ownerId);
    @Query(nativeQuery = true,value = "select sum(area) from room where owner_id=?1 and is_del=0")
    int findRoomCountByOwnerId(String ownerId);
}
