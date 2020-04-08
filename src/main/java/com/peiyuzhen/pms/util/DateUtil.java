package com.peiyuzhen.pms.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {
    public static String getTime(Timestamp timestamp){
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
        String formatDate=format.format(timestamp);
        return formatDate;
    }
}
