package com.peiyuzhen.pms.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.domain.Repair;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@ContentRowHeight(13)
@HeadRowHeight(15)
@ColumnWidth(15)
public class ExportRepairVo {

    @ExcelProperty(value = "报修人",index = 0)
    private String ownerName;//报修人
    @ExcelProperty(value = "报修人电话",index = 1)
    private String ownerPhone;//报修人电话
    @ExcelProperty(value = "报修人性别",index = 2)
    private String ownerSex;//报修人性别
    @ExcelProperty(value = "报修内容",index = 3)
    private String repairContent;//报修内容
    @ExcelProperty(value = "报修日期",index = 4)
    private String repairDay;//报修日期
    @ExcelProperty(value = "处理人",index =5)
    private String dealingMan;//处理人
    @ExcelProperty(value = "处理结果",index = 6)
    private String result;//处理结果
    @ExcelProperty(value = "是否解决",index = 7)
    private String isDeal;//是否解决 1解决 0未解决


}
