package com.peiyuzhen.pms.controller.wx;

import com.peiyuzhen.pms.service.RepairService;
import com.peiyuzhen.pms.vo.RcVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api")
@ResponseBody
@Slf4j
public class WxRcController {
    @Autowired
    private RepairService repairService;
    @RequestMapping("rcs")
    public Map<String,Object> rcs(@RequestParam("ownerId") String ownerId){
        List<RcVo> rcVos=repairService.findAllRcByOwnerId(ownerId);
        Map map=new HashMap();
        map.put("rcVos",rcVos);
        return map;
    }
}
