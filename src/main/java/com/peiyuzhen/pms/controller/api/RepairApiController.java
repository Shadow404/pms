package com.peiyuzhen.pms.controller.api;

import com.peiyuzhen.pms.domain.Repair;
import com.peiyuzhen.pms.service.RepairService;
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
public class RepairApiController {
    @Autowired
    private RepairService repairService;
    @RequestMapping("repairComp")
    public String repairComp(Repair repair){
        String message="处理失败！";
        try {
            repairService.updateRepairByRepairId(repair);
            message="处理成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }
    @RequestMapping("delRepair")
    public Map<String,Object> delRepair(@RequestParam("repairId")String repairId){
        Map<String,Object> map=new HashMap<>();
        String message="删除失败！";
        try {
            repairService.delRepair(repairId);
            message="删除成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        map.put("message",message);
        return map;

    }
}
