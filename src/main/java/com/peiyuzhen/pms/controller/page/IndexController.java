package com.peiyuzhen.pms.controller.page;


import com.peiyuzhen.pms.domain.User;
import com.peiyuzhen.pms.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/")
    public String login(HttpServletRequest request){

        request.getSession().removeAttribute("user");
        return "login.html";
    }
    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password, RedirectAttributes redirectAttributes){
        User user=userRepository.findByUserName(userName);
        log.info("{}userNmae {} {}",userName,password,user);
        String msg="登录失败！";
        if(user!=null&&user.getUserPassWord().equals(password)){
            user.setIp(request.getLocalAddr());
            userRepository.save(user);
            request.getSession().setAttribute("user",user);
            msg="登录成功！";
            redirectAttributes.addFlashAttribute("msg",msg);
            return "redirect:/index";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/";
    }
    @RequestMapping("/index")
    public String index(HttpSession httpSession, RedirectAttributes redirectAttributes, ModelMap modelMap){
        User user= (User) httpSession.getAttribute("user");
        if(user==null){
            redirectAttributes.addFlashAttribute("msg","请登录！");
            return "redirect:/";
        }
        else {
            modelMap.addAttribute("loginUser",user);
            return "index.html";
        }
    }
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome.html";
    }
}
