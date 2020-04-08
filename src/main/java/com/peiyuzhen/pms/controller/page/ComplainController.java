package com.peiyuzhen.pms.controller.page;

import com.alibaba.excel.EasyExcel;
import com.peiyuzhen.pms.domain.Complain;
import com.peiyuzhen.pms.service.ComplainService;
import com.peiyuzhen.pms.vo.ComplainVo;
import com.peiyuzhen.pms.vo.ExportComplainVo;
import com.peiyuzhen.pms.vo.ExportRepairVo;
import com.peiyuzhen.pms.vo.RepairVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/exportComplain")
    public void exportComplain(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(String.format("投诉单"));
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<ComplainVo> complainVos = complainService.allComplain( );
        List<ExportComplainVo> result = complainVos.stream( ).map(ComplainVo::convertToExportVO).collect(Collectors.toList( ));
        EasyExcel.write(response.getOutputStream(), ExportComplainVo.class).sheet("投诉单").doWrite(result);

    }
}
