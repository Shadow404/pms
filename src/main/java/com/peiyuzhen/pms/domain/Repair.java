package com.peiyuzhen.pms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairId;//维修ID
    @Column
    private Long ownerId;//报修人
    @Column
    private String repairContent;//报修内容
    @Column(nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ")
    private Timestamp repairDay;//报修日期
    @Column
    private String dealingMan;//处理人
    @Column
    private String result;//处理结果
    @Column(columnDefinition = "int default 0")
    private Integer isDeal;//是否解决 1解决 0未解决
}
