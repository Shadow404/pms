package com.peiyuzhen.pms.controller.page;

import com.peiyuzhen.pms.domain.User;
import com.peiyuzhen.pms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("user")
    public String user(ModelMap modelMap, HttpSession httpSession){
        List<User> userList=userService.allUser();
        modelMap.addAttribute("userList",userList);
        modelMap.addAttribute("size",userList.size());
        User user= (User) httpSession.getAttribute("user");
        log.info("{}loginuser",user);
        modelMap.addAttribute("loginUser",user);
        return "user.html";
    }
    @RequestMapping("addUser")
    public String addUser(){
        return "addUser.html";
    }
    @RequestMapping("editUser")
    public String editUser(@RequestParam("userId")String userId,ModelMap modelMap){
        User user=userService.findUserById(userId);
        modelMap.addAttribute("user",user);
        return "editUser.html";
    }
}
