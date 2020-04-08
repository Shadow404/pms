package com.peiyuzhen.pms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class PayType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PayTypeId;
    @Column(nullable = false,scale = 2,precision = 10)
    private BigDecimal unitPrice;//单价
    @Column
    private String PayTypeName;
}
