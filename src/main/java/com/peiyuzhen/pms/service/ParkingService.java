package com.peiyuzhen.pms.service;

import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.vo.ParkingVo;

import java.util.List;

public interface ParkingService {
    List<ParkingVo> findAllParking();

    void addParking(Parking parking);

    List<Parking> findAllParkingNoOwner();

    Parking findParkingByParkingId(String parkingId);

    String removeUse(String parkingId);

    String delParking(String parkingId);
}
