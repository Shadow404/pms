package com.peiyuzhen.pms.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.peiyuzhen.pms.domain.Complain;
import com.peiyuzhen.pms.domain.Owner;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class ExportComplainVo {

    @ExcelProperty(value = "投诉人",index = 0)
    private String ownerName;//投诉人
    @ExcelProperty(value = "投诉人电话",index = 1)
    private String ownerPhone;//投诉人电话
    @ExcelProperty(value = "投诉人性别",index = 2)
    private String ownerSex;//投诉人性别
    @ExcelProperty(value = "投诉内容",index = 3)
    private String complainContent;//投诉内容
    @ExcelProperty(value = "投诉日期",index = 4)
    private String complainDay;//投诉日期
    @ExcelProperty(value = "处理人",index =5)
    private String dealingMan;//处理人
    @ExcelProperty(value = "处理结果",index = 6)
    private String result;//处理结果
    @ExcelProperty(value = "是否解决",index = 7)
    private String isDeal;//是否解决 1解决 0未解决


}
