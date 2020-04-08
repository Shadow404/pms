package com.peiyuzhen.pms.controller.page;

import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller

public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @RequestMapping("owner")
    public String owner(ModelMap modelMap){
        List<Owner> owners=ownerService.findAllOwnerNotDel();
        modelMap.addAttribute("owners",owners);
        modelMap.addAttribute("size",owners.size());
        return "owner.html";
    }
    @RequestMapping("addOwner")
    public String addOwner(){
        return "addOwner.html";
    }
}
