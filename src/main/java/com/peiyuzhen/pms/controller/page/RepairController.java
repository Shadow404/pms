package com.peiyuzhen.pms.controller.page;

import com.alibaba.excel.EasyExcel;
import com.peiyuzhen.pms.domain.Repair;
import com.peiyuzhen.pms.service.RepairService;
import com.peiyuzhen.pms.vo.ExportRepairVo;
import com.peiyuzhen.pms.vo.RepairVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.DateUtils;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/exportRepair")
    public void exportRepair(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(String.format("报修单"));
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<RepairVo> repairVoList=repairService.getAllRepairList();
        List<ExportRepairVo> result = repairVoList.stream( ).map(RepairVo::convertToExportVO).collect(Collectors.toList( ));
        EasyExcel.write(response.getOutputStream(), ExportRepairVo.class).sheet("报修单").doWrite(result);

    }

}
