package com.peiyuzhen.pms.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
@Data
@Entity
@NoArgsConstructor
public class Pay {
    @GenericGenerator(strategy = "com.peiyuzhen.pms.util.CustomIdGenerator",name="sss")
    @GeneratedValue(generator = "sss")
    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    @Column
    private Long payId;//支付id
    @Column
    private Long ownerId;//业主Id
    @Column(nullable = false,scale = 2,precision = 10)
    private BigDecimal price;//金额
    @Column
    private String payName;//缴费名称
    @Column(nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ")
    private Timestamp payDay;
    @Column
    private String dealingMan;
    @Column(columnDefinition = "int default 0")
    private Integer isPay;//1完成 0未完成
    @Column
    private Integer payType;
}
