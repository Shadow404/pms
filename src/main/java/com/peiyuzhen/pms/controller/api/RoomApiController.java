package com.peiyuzhen.pms.controller.api;

import com.peiyuzhen.pms.domain.Room;
import com.peiyuzhen.pms.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@ResponseBody
@RequestMapping("api")
public class RoomApiController {
    @Autowired
    private RoomService roomService;
    @RequestMapping("delRoom")
    public Map<String,Object> delRoom(@RequestParam("roomId")String roomId){
        Map<String,Object> map=new HashMap<>();
        String message="删除失败！";
        try {
            roomService.delRoom(roomId);
            message="删除成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        map.put("message",message);
        return map;

    }
    @RequestMapping("findRoomCountByOwnerId")
    public Map<String,Object>findRoomCountByOwnerId(@RequestParam("ownerId")String ownerId){
        Map<String,Object> map=new HashMap<>();
        int roomCount=0;
        try {
           roomCount= roomService.findRoomCountByOwnerId(ownerId);

        }catch (Exception e){
        }
        map.put("val",roomCount);
        return map;
    }
    @RequestMapping("addRoom")
    public String addRoom(Room room){
        room.setIsDel(0);
        String message="添加失败！";
        try {
            roomService.addRoom(room);
            message="添加成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }
}
