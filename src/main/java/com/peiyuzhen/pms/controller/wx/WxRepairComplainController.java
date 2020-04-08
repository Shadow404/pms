package com.peiyuzhen.pms.controller.wx;

import com.peiyuzhen.pms.domain.Complain;
import com.peiyuzhen.pms.domain.Rc;
import com.peiyuzhen.pms.domain.Repair;
import com.peiyuzhen.pms.repository.ComplainRepository;
import com.peiyuzhen.pms.repository.RepairRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
@ResponseBody
@Slf4j
public class WxRepairComplainController {
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private ComplainRepository complainRepository;
    @RequestMapping("repairOrComplain")
    public String repairOrComplain(@RequestBody Rc rc){
        String message="提交失败！";
        if(rc.getType().equals("0")){
            Repair repair=new Repair();
            repair.setIsDeal(0);
            repair.setRepairContent(rc.getContent());
            repair.setOwnerId(Long.parseLong(rc.getOwnerId()));
            try {
                repairRepository.save(repair);
                message="提交成功！";
            }catch (Exception e){
                message+=e.getMessage();
            }
        }
        else {
            Complain complain=new Complain();
            complain.setIsDeal(0);
            complain.setComplainContent(rc.getContent());
            complain.setOwnerId(Long.parseLong(rc.getOwnerId()));
            try {
                complainRepository.save(complain);
                message="提交成功！";
            }catch (Exception e){
                message+=e.getMessage();
            }
        }

        return message;
    }
}
