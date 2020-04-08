package com.peiyuzhen.pms.service;

import com.peiyuzhen.pms.domain.Parking;
import com.peiyuzhen.pms.domain.Pay;
import com.peiyuzhen.pms.vo.PayVo;

import java.util.List;

public interface PayService {
    List <PayVo> allPay();//获取所有缴费信息

    List<Pay> allPayByOwnerId(Integer id); //通过用户id获取缴费信息

    Pay findAllByPayId(Integer payId);

    Integer editPayById(String pay_name, Integer owner_id,Double price, String dealing_man, Integer payId);

    void addPay(Pay pay);

    PayVo findPayByPayId(String payId);

    List<PayVo> findAllByOwnerId(String ownerId);

    String addParkingPay(Pay pay, String parkingId);

    String addOverDateParkingPay(Pay pay, Parking parking);

    int payMoney(String payId);
}
