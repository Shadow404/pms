package com.peiyuzhen.pms.controller.api;

import com.peiyuzhen.pms.domain.User;
import com.peiyuzhen.pms.service.UserService;
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
public class UserApiController {
    @Autowired
    private UserService userService;
    @RequestMapping("/addUser")
    public String addUser(@RequestParam("userName")String userName, @RequestParam("password")String password){
        String message="添加帐号失败！";
        try {
            userService.addUser(userName,password);
            message="添加帐号成功！";
        }catch (Exception e){
        }
        return message;
    }
    @RequestMapping("delUser")
    public Map<String,Object> delUser(@RequestParam("userId")String userId){
        String message="删除帐号失败！";
        Map<String,Object> map=new HashMap<>();
        try {
            userService.delUserById(userId);
            message="删除帐号成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        map.put("message",message);
        return map;
    }
    @RequestMapping("editUser")
    public String editUser(User user){
        String message="修改帐号失败！";
        try {
            userService.editUserByUserId(user);
            message="修改帐号成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }

        return message;
    }
}
