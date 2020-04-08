package com.peiyuzhen.pms.vo;

import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.domain.Parking;
import lombok.Data;

import java.util.Date;

@Data
public class ParkingVo {
    private Integer parkingId;
    private String parkingName;
    private Long ownerId;
    private Date parkingBuyDay;
    private Date parkingEndDay;
    private Integer isDel;
    private String ownerName;
    private String ownerPhone;//
    private String ownerSex;//
    private int overDate;//超时
    private long payId;

    public ParkingVo(Parking parking, Owner owner){
        this.parkingId=parking.getParkingId();
        this.parkingName=parking.getParkingName();
        this.ownerId=parking.getOwnerId();
        this.parkingBuyDay=parking.getParkingBuyDay();
        this.parkingEndDay=parking.getParkingEndDay();
        this.isDel=parking.getIsDel();
        this.ownerName=owner.getOwnerName();
        this.ownerPhone=owner.getOwnerPhone();//
        this.ownerSex=owner.getOwnerSex();//
        this.payId=parking.getPayId();

    }
    public int getOverDate(){
        Date now=new Date();
        this.overDate=0;
        if(this.getParkingEndDay()!=null){
            if(now.after(this.parkingEndDay))
            this.overDate=1;
        }

        return overDate;
    }

}
