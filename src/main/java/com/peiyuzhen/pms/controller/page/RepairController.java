package com.peiyuzhen.pms.controller.page;

import com.peiyuzhen.pms.domain.Repair;
import com.peiyuzhen.pms.service.RepairService;
import com.peiyuzhen.pms.vo.RepairVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class RepairController {
    @Autowired
    private RepairService repairService;
    @RequestMapping("repair")
    public String repair(ModelMap modelMap){
        List<RepairVo> repairVoList=repairService.getAllRepairList();
        modelMap.addAttribute("repairList",repairVoList);
        modelMap.addAttribute("size",repairVoList.size());
        return "repair.html";
    }
    @RequestMapping("repairComp")
    public String repairComp(@RequestParam("repairId")String repairId,ModelMap modelMap){
        Repair repair=repairService.getRepairByRepairId(repairId);
        modelMap.addAttribute("repair",repair);
        return "repairComp.html";
    }
    @RequestMapping("editRepair")
    public String editRepair(@RequestParam("repairId")String repairId,ModelMap modelMap){
        Repair repair=repairService.getRepairByRepairId(repairId);
        modelMap.addAttribute("repair",repair);
        return "editRepair.html";
    }
}
