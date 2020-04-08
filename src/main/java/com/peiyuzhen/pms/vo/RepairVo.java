package com.peiyuzhen.pms.vo;

import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.domain.Repair;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class RepairVo {
    private Long repairId;//维修ID
    private String ownerName;//报修人
    private String ownerPhone;//报修人电话
    private String ownerSex;//报修人性别
    private String repairContent;//报修内容
    private Timestamp repairDay;//报修日期
    private String dealingMan;//处理人
    private String result;//处理结果
    private int isDeal;//是否解决 1解决 0未解决
    public RepairVo(Repair repair, Owner owner){
        this.repairId=repair.getRepairId();
        this.ownerName=owner.getOwnerName();
        this.ownerPhone=owner.getOwnerPhone();
        this.ownerSex=owner.getOwnerSex();
        this.repairContent=repair.getRepairContent();
        this.repairDay=repair.getRepairDay();
        this.dealingMan=repair.getDealingMan();
        this.isDeal=repair.getIsDeal();
        this.result=repair.getResult();
    }
//    public RepairVo(Long repairId,String ownerName,String ownerPhone,String ownerSex,String repairContent,Timestamp repairDay,String dealingMan,String result,int isDeal){
//        this.repairId=repairId;
//        this.ownerName=ownerName;
//        this.ownerPhone=ownerPhone;
//        this.ownerSex= ownerSex;
//        this.repairContent=repairContent;
//        this.repairDay=repairDay;
//        this.dealingMan=dealingMan;
//        this.result=result;
//        this.isDeal=isDeal;
//
//    }

}
