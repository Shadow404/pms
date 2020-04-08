package com.peiyuzhen.pms.vo;

import com.peiyuzhen.pms.domain.Complain;
import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.util.DateUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class ComplainVo {
    private Long complainId;//维修ID
    private String ownerName;//报修人
    private String ownerPhone;//报修人电话
    private String ownerSex;//报修人性别
    private String complainContent;//报修内容
    private Timestamp complainDay;//报修日期
    private String dealingMan;//处理人
    private String result;//处理结果
    private int isDeal;//是否解决 1解决 0未解决
    public ComplainVo(Complain complain, Owner owner){
        this.complainId=complain.getComplainId();
        this.ownerName=owner.getOwnerName();
        this.ownerPhone=owner.getOwnerPhone();
        this.ownerSex=owner.getOwnerSex();
        this.complainContent=complain.getComplainContent();
        this.complainDay=complain.getComplainDay();
        this.dealingMan=complain.getDealingMan();
        this.isDeal=complain.getIsDeal();
        this.result=complain.getResult();
    }

    public ExportComplainVo convertToExportVO() {
        ExportComplainVo exportComplainVo = new ExportComplainVo();
        exportComplainVo.setOwnerName(this.getOwnerName());
        exportComplainVo.setOwnerPhone(this.getOwnerPhone());
        exportComplainVo.setOwnerSex(this.getOwnerSex());
        exportComplainVo.setComplainContent(this.getComplainContent());
        exportComplainVo.setComplainDay(DateUtil.getTime(this.getComplainDay()) );
        exportComplainVo.setDealingMan(this.getDealingMan());
        exportComplainVo.setResult(this.getResult());
        exportComplainVo.setIsDeal(1 == this.getIsDeal()? "已解决":"未解决");
        return exportComplainVo;
    }

}
