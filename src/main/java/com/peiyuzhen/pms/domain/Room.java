package com.peiyuzhen.pms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;//romID
    @Column
    private String buildingName;//楼名称
    @Column
    private String uintName;//单元名称
    @Column
    private String roomName;//房间名
    @Column(nullable = false,precision = 10)
    private BigDecimal area;//面积
    @Column
    private Long ownerId;//用户Id
    @Column(columnDefinition = "int default 0")
    private Integer isDel;//是否删除
}
