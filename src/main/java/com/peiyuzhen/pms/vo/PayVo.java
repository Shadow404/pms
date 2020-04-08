package com.peiyuzhen.pms.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class PayVo {
    private String payId;//支付id
    private Long ownerId;//业主Id
    private BigDecimal price;//金额
    private String payName;//缴费名称
    private Timestamp payDay;
    private String dealingMan;
    private Integer isPay;//1完成 0未完成
    private Integer payType;
    private String ownerName;

    public PayVo(Long payId, Long ownerId, BigDecimal price, String payName, Timestamp payDay, String dealingMan, Integer isPay, Integer payType, String ownerName) {
        this.payId = payId.toString();
        this.ownerId = ownerId;
        this.price = price;
        this.payName = payName;
        this.payDay = payDay;
        this.dealingMan = dealingMan;
        this.isPay = isPay;
        this.payType = payType;
        this.ownerName = ownerName;
    }

}
