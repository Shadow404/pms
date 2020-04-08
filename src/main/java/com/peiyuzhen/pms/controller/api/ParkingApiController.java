package com.peiyuzhen.pms.controller.api;

import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ResponseBody
@RequestMapping("api")
@Controller
@Slf4j
public class ParkingApiController {
    @Autowired
    private ParkingService parkingService;
    @RequestMapping("addParking")
    public String addParking(Parking parking){
        parking.setIsDel(0);
        parking.setOwnerId(0l);
        String message="添加车位失败！";
        try {
            parkingService.addParking(parking);
            message="添加车位成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }
    @RequestMapping("addOwnerParking")
    public String addOwnerParking(Parking parking){
        Parking parking1=parkingService.findParkingByParkingId(parking.getParkingId().toString());
        parking1.setOwnerId(parking.getOwnerId());
        parking1.setParkingBuyDay(parking.getParkingBuyDay());
        parking1.setParkingEndDay(parking.getParkingEndDay());
        String message="选择失败！";
        try {
            parkingService.addParking(parking1);
            message="选择成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }
    @RequestMapping("removeUse")
    public Map<String,Object> removeUse(@RequestParam("parkingId")String parkingId){
        Map<String,Object> map=new HashMap<>();
        String message= parkingService.removeUse(parkingId);
        map.put("message",message);
        return map;
    }
    @RequestMapping("delParking")
    public Map<String,Object> delParking(@RequestParam("parkingId")String parkingId){
        Map<String,Object> map=new HashMap<>();
        String message= parkingService.delParking(parkingId);
        map.put("message",message);
        return map;
    }
}
