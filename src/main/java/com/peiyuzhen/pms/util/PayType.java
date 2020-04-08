package com.peiyuzhen.pms.util;

public enum PayType {
    DIANFEI(1,"电费"),
    SHUIFEI(2,"水费"),
    TINGCHEFEI(3,"停车费"),
    WUYEFEI(4,"物业费");
    private int code;
    private String name;
    private PayType(int code, String name) {
        this.code = code;
        this.name = name;
    }
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
