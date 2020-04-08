package com.peiyuzhen.pms.controller.page;

import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.service.ParkingService;
import com.peiyuzhen.pms.vo.ParkingVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class ParkingController {
    @Autowired
    private ParkingService parkingService;
    @RequestMapping("parking")
    public String parking(ModelMap modelMap){
        List<ParkingVo> parkingVos=parkingService.findAllParking();
        modelMap.addAttribute("parkingVos",parkingVos);
        modelMap.addAttribute("size",parkingVos.size());
        return "parking.html";
    }
    @RequestMapping("addParking")
    public String addParking(ModelMap modelMap){
        return "addParking.html";
    }
    @RequestMapping("addOwnerParking")
    public String addOwnerParking(@RequestParam("ownerId")String ownerId,ModelMap modelMap){
        List<Parking> parkings=parkingService.findAllParkingNoOwner();
        modelMap.addAttribute("parkings",parkings);
        modelMap.addAttribute("ownerId",ownerId);
        return "addOwnerParking.html";
    }
}
