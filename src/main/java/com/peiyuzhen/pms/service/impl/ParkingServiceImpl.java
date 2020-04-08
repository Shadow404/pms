package com.peiyuzhen.pms.service.impl;

import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.repository.ParkingRepository;
import com.peiyuzhen.pms.service.ParkingService;
import com.peiyuzhen.pms.util.CommUtils;
import com.peiyuzhen.pms.vo.ParkingVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;
    @Override
    public List<ParkingVo> findAllParking() {
        List<Map<String,Object>> maps=parkingRepository.findAllParking();
        List<ParkingVo> parkingVos=new ArrayList<>();
        for (Map<String,Object> map:maps
             ) {
            parkingVos.add(CommUtils.toCamelCase(map, ParkingVo.class));
        }
        return parkingVos;
    }

    @Override
    public void addParking(Parking parking) {
        parkingRepository.save(parking);
    }

    @Override
    public List<Parking> findAllParkingNoOwner() {
        return parkingRepository.findAllParkingNoOwner();
    }

    @Override
    public Parking findParkingByParkingId(String parkingId) {
        return parkingRepository.findParkingByParkingId(parkingId);
    }

    @Override
    public String removeUse(String parkingId) {
        Parking parking=parkingRepository.findParkingByParkingId(parkingId);
        parking.setOwnerId(0l);
        parking.setPayId(0l);
        parking.setParkingBuyDay(null);
        parking.setParkingEndDay(null);
        String message="清空失败！";
        try {
            parkingRepository.save(parking);
            message="清空成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }

    @Override
    public String delParking(String parkingId) {
        String message="删除失败！";
        try {
            parkingRepository.delParking(parkingId);
            message="删除成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }
}
