package com.peiyuzhen.pms.service.impl;

import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.domain.Pay;
import com.peiyuzhen.pms.repository.ParkingRepository;
import com.peiyuzhen.pms.repository.PayRepository;
import com.peiyuzhen.pms.service.PayService;
import com.peiyuzhen.pms.util.CommUtils;
import com.peiyuzhen.pms.vo.PayVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayRepository payRepository;
    @Autowired
    private ParkingRepository parkingRepository;
    @Override
    public List<PayVo> allPay() {
        List<PayVo> payVos=new ArrayList<>();
        List<Map<String,Object>>maps= payRepository.findAllPay();
        for(Map<String,Object> map:maps){
            payVos.add(CommUtils.toCamelCase(map,PayVo.class));
        }
        return payVos;
    }

    @Override
    public List<Pay> allPayByOwnerId(Integer id) {
        return payRepository.findAllByOwnerId(id);
    }





    @Override
    public Pay findAllByPayId(Integer payId) {
        return payRepository.findAllByPayId(payId);
    }

    @Override
    public Integer editPayById(String pay_name, Integer owner_id, Double price, String dealing_man, Integer payId) {
        return null;
    }


    @Override
    public void addPay(Pay pay) {
        payRepository.save(pay);
    }

    @Override
    public PayVo findPayByPayId(String payId) {
        PayVo payVo;
        Map<String,Object> map=payRepository.findPayByPayId(payId);
        payVo=CommUtils.toCamelCase(map,PayVo.class);
        return payVo;
    }

    @Override
    public List<PayVo> findAllByOwnerId(String ownerId) {
        List<PayVo> payVos=new ArrayList<>();
        List<Map<String,Object>> maps=payRepository.findAllByOwnerId(ownerId);
       for(Map<String,Object> map:maps){
           payVos.add(CommUtils.toCamelCase(map,PayVo.class));
       }
        return payVos;
    }

    @Override
    public String addParkingPay(Pay pay, String parkingId) {
        String message = "添加缴费失败！";
        try {
            payRepository.save(pay);
            log.info("{} payid",pay.getPayId());
            parkingRepository.addParkingPay(pay.getPayId(),parkingId);
            message="添加缴费成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }

    @Override
    public String addOverDateParkingPay(Pay pay, Parking parking) {
        String message = "添加缴费失败！";
        try {
            payRepository.save(pay);
            log.info("{} payid",pay.getPayId());
            parkingRepository.addOverDateParkingPay(pay.getPayId(),parking.getParkingBuyDay(),parking.getParkingEndDay(),parking.getParkingId());
            message="添加缴费成功！";
        }catch (Exception e){
            message+=e.getMessage();
        }
        return message;
    }

    @Override
    public int payMoney(String payId) {
        int result=0;
        try {
            payRepository.payMoney(payId);
            result=1;
        }catch (Exception e){

        }
        return result;
    }


}
