package com.peiyuzhen.pms.repository;

import com.peiyuzhen.pms.domain.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ParkingRepository extends JpaRepository<Parking,Integer> {
    @Query(nativeQuery = true,value = "SELECT a.*,b.owner_name,b.owner_phone,b.owner_sex FROM parking  a LEFT JOIN owner b ON a.owner_id=b.owner_id where a.is_del=0")
    List<Map<String, Object>> findAllParking();
    @Query(nativeQuery = true,value = "select * from parking where owner_id=0 and is_del=0")
    List<Parking> findAllParkingNoOwner();
    @Query(nativeQuery = true,value = "select * from parking where parking_id=?1 and is_del=0")
    Parking findParkingByParkingId(String parkingId);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update parking set pay_id=?1 where parking_id=?2")
    void addParkingPay(Long payId, String parkingId);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update parking set pay_id=?1,parking_buy_day=?2,parking_end_day=?3 where parking_id=?4")
    void addOverDateParkingPay(Long payId, Date parkingBuyDay, Date parkingEndDay, Integer parkingId);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update parking set is_del=1 where parking_id=?1")
    void delParking(String parkingId);
}
