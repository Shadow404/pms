package com.peiyuzhen.pms.controller.api;

import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.domain.Pay;
import com.peiyuzhen.pms.domain.PayType;
import com.peiyuzhen.pms.repository.PayTypeRepository;
import com.peiyuzhen.pms.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("api")
@ResponseBody
public class PayApiController {
    @Autowired
    private PayService payService;
    @Autowired
    private PayTypeRepository payTypeRepository;
    @RequestMapping("/addPay")
    public String addPay(Pay pay){
        pay.setIsPay(0);
        String message = "添加缴费失败！";
        try {
            payService.addPay(pay);
            message="添加缴费成功！";
        }catch (Exception e){
             message+=e.getMessage();
        }

        return message;
    }
    @RequestMapping("addParkingPay")
    public String addParkingPay(Pay pay, @RequestParam("parkingId")String parkingId){
        pay.setIsPay(0);
        String message=payService.addParkingPay(pay,parkingId);
        return message;
    }
    @RequestMapping("addOverDateParkingPay")
    public String addOverDateParkingPay(Pay pay, Parking parking){
        pay.setIsPay(0);
        String message=payService.addOverDateParkingPay(pay,parking);
        return message;
    }
    @PostMapping("/editPay")
    public String saveEditPay(Pay pay){
        pay.setIsPay(0);
        String message = "修改缴费失败！";
        try {
            payService.addPay(pay);
            message="修改缴费成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }

        return message;
    }
    @RequestMapping("findUnitPrice")
    public Map<String,Object> findUnitPrice(@RequestParam("payTypeId")String payTypeId){
        Map<String, Object> map=new HashMap<>();
        String price=payTypeRepository.findUnitPriceById(payTypeId);
        map.put("price",price);
        return map;
    }
    @RequestMapping("setPay")
    public String setPay(PayType payType) {
        String message="设置失败！";
        try {
            payTypeRepository.save(payType);
            message="设置成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }


}
