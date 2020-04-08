package com.peiyuzhen.pms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Parking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer parkingId;
    @Column
    private String parkingName;
    @Column
    private Long ownerId;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date parkingBuyDay;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date parkingEndDay;
    @Column(columnDefinition = "int default 0")
    private Integer isDel;//1删除 0
    @Column(columnDefinition = "long default 0l")
    private long payId;//订单id
}
