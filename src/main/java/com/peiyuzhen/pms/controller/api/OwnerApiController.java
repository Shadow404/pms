package com.peiyuzhen.pms.controller.api;

import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.service.OwnerService;
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
@RequestMapping("api")
@ResponseBody
public class OwnerApiController {
    @Autowired
    private OwnerService ownerService;
    @RequestMapping("delOwner")
    public Map<String,Object>delOwner(@RequestParam("ownerId")String ownerId){
        Map<String,Object> map=new HashMap<>();
        String message="删除失败！";
        try{
            ownerService.delOwnerByOwnerId(ownerId);
            message="删除成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        map.put("message",message);
        return map;
    }
    @RequestMapping("addOwner")
    public String addOwner(Owner owner){

        String message="添加业主失败！";
        try{
            ownerService.addOwner(owner);
            message="添加业主成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }

        return message;
    }
    @RequestMapping("findOwnerByPhone")
    public Map<String,Object>findOwnerByPhone(@RequestParam("phone")String phone){
        Map<String,Object> map=new HashMap<>();
        int val=0;
        try{
           val= ownerService.findOwnerByPhone(phone);

        }catch (Exception e){

        }
        map.put("val",val);
        return map;
    }


}
