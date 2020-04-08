package com.peiyuzhen.pms.controller.api;

import com.peiyuzhen.pms.domain.Complain;
import com.peiyuzhen.pms.service.ComplainService;
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
public class ComplainApiController {
    @Autowired
    private ComplainService complainService;
    @RequestMapping("complainComp")
    public String complainComp(Complain complain){
        String message="处理失败！";
        try {
            complainService.updateComplainByRepairId(complain);
            message="处理成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }
    @RequestMapping("delComplain")
    public Map<String,Object> delComplain(@RequestParam("complainId")String complainId){
        Map<String,Object> map=new HashMap<>();
        String message="删除失败！";
        try {
            complainService.delComplain(complainId);
            message="删除成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        map.put("message",message);
        return map;

    }



}
