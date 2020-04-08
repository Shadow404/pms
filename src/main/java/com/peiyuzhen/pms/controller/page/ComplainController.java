package com.peiyuzhen.pms.controller.page;

import com.peiyuzhen.pms.domain.Complain;
import com.peiyuzhen.pms.service.ComplainService;
import com.peiyuzhen.pms.vo.ComplainVo;
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
public class ComplainController {
    @Autowired
    private ComplainService complainService;


    @RequestMapping("complain")
    public String user(ModelMap modelMap, HttpSession httpSession){
        List<ComplainVo> complainList=complainService.allComplain();
        modelMap.addAttribute("complainList",complainList);
        modelMap.addAttribute("size",complainList.size());
        return "complain.html";
    }
    @RequestMapping("complainComp")
    public String complainComp(@RequestParam("complainId")String complainId,ModelMap modelMap){
        Complain complain=complainService.findComplainById(complainId);
        modelMap.addAttribute("complain",complain);
        return "complainComp.html";
    }
    @RequestMapping("editComplain")
    public String editComplain(@RequestParam("complainId")String complainId,ModelMap modelMap){
        Complain complain=complainService.findComplainById(complainId);
        modelMap.addAttribute("complain",complain);
        return "editComplain.html";
    }
}
