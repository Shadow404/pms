package com.peiyuzhen.pms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String userName;
    @Column
    private String userPassWord;
    @Column
    private String userPhone;
    @Column
    private String userAddr;
    @Column
    private String ip;
    @Column(columnDefinition = "int default 0")
    private int userPower;//1是最高管理员0是普通
    @Column(columnDefinition = "int default 0")
    private Integer isDel;//1删除 0
}
