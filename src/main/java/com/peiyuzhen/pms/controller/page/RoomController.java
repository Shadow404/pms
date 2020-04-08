package com.peiyuzhen.pms.controller.page;

import com.peiyuzhen.pms.domain.Room;
import com.peiyuzhen.pms.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j

public class RoomController {
    @Autowired
    private RoomService roomService;
    @RequestMapping("roomHas")
    public String roomHas(@RequestParam("ownerId")String ownerId, ModelMap modelMap){
        List<Room>rooms=roomService.findRoomsByOwnerId(ownerId);
        modelMap.addAttribute("rooms",rooms);
        modelMap.addAttribute("roomSize",rooms.size());
        modelMap.addAttribute("ownerId",ownerId);
        return "roomHas.html";
    }
    @RequestMapping("addRoom")
    public String roomAdd(ModelMap modelMap,@RequestParam("ownerId")String ownerId){
        modelMap.addAttribute("ownerId",ownerId);
        return "addRoom.html";
    }
}
