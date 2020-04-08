package com.peiyuzhen.pms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complainId;
    @Column
    private Long ownerId;
    @Column
    private String complainContent;//投诉内容
    @Column(nullable = false,columnDefinition = "timestamp  DEFAULT CURRENT_TIMESTAMP ")
    private Timestamp complainDay;//投诉日期自动生成
    @Column
    private String dealingMan;//解决人
    @Column
    private String result;//解决的结果
    @Column(columnDefinition = "int default 0")
    private Integer isDeal;//是否解决 1解决 0未解决
}
