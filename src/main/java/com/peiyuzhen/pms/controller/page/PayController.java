package com.peiyuzhen.pms.controller.page;

import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.domain.User;
import com.peiyuzhen.pms.service.OwnerService;
import com.peiyuzhen.pms.service.ParkingService;
import com.peiyuzhen.pms.service.PayService;
import com.peiyuzhen.pms.util.PayType;
import com.peiyuzhen.pms.vo.PayVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class PayController {
    @Autowired
    private PayService payService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private ParkingService parkingService;
    public ModelMap getPayType(ModelMap modelMap){
        List<PayType> types=new ArrayList<>();
        types.add(PayType.DIANFEI);
        types.add(PayType.SHUIFEI);
        types.add(PayType.WUYEFEI);
        types.add(PayType.TINGCHEFEI);
        modelMap.addAttribute("types",types);
        return modelMap;
    }

    @RequestMapping("pay")
    public String pay(ModelMap modelMap, HttpSession httpSession){
        List<PayVo> payList=payService.allPay();
        modelMap.addAttribute("payList",payList);
        modelMap.addAttribute("size",payList.size());
        getPayType(modelMap);
        return "pay.html";
    }
    @RequestMapping("addPay")
    public String addPay(ModelMap modelMap, HttpSession httpSession, @RequestParam("ownerId")String ownerId){
        User loginUser =(User)httpSession.getAttribute("user");
        modelMap.addAttribute("loginUser",loginUser);
        Owner owner=ownerService.findOwnerById(ownerId);
        modelMap.addAttribute("owner",owner);
        getPayType(modelMap);
        return "addPay.html";
    }


    @RequestMapping("editPay")
    public String editPay(@RequestParam("payId")String payId,ModelMap modelMap,HttpSession httpSession){
        PayVo payVo=payService.findPayByPayId(payId);
        modelMap.addAttribute("pay",payVo);
        log.info("payvo {}",payVo);
        Owner owner=ownerService.findOwnerById(payVo.getOwnerId().toString());
        modelMap.addAttribute("owner",owner);
        User loginUser =(User)httpSession.getAttribute("user");
        modelMap.addAttribute("loginUser",loginUser);
        getPayType(modelMap);
        return "editPay.html";
    }
    @RequestMapping("payNote")
    public String payNote(ModelMap modelMap,String ownerId){
        List<PayVo> payVos=payService.findAllByOwnerId(ownerId);
        modelMap.addAttribute("payList",payVos);
        modelMap.addAttribute("size",payVos.size());
        return "payNote.html";
    }
    @RequestMapping("addParkingPay")
    public String addParkingPay(@RequestParam("parkingId")String parkingId,ModelMap modelMap,HttpSession httpSession){
        User loginUser =(User)httpSession.getAttribute("user");
        modelMap.addAttribute("loginUser",loginUser);
        Parking parking=parkingService.findParkingByParkingId(parkingId);
        Owner owner=ownerService.findOwnerById(parking.getOwnerId().toString());
        modelMap.addAttribute("owner",owner);
        modelMap.addAttribute("parking",parking);
        return "addParkingPay.html";
    }
    @RequestMapping("addOverDateParkingPay")
    public String addOverDateParkingPay(@RequestParam("parkingId")String parkingId,ModelMap modelMap,HttpSession httpSession){
        User loginUser =(User)httpSession.getAttribute("user");
        modelMap.addAttribute("loginUser",loginUser);
        Parking parking=parkingService.findParkingByParkingId(parkingId);
        Owner owner=ownerService.findOwnerById(parking.getOwnerId().toString());
        modelMap.addAttribute("owner",owner);
        modelMap.addAttribute("parking",parking);
        return "addOverDateParkingPay.html";
    }
    @RequestMapping("setPay")
    public String setPay(ModelMap modelMap){
        getPayType(modelMap);
        return "setPay.html";
    }
}
