package com.peiyuzhen.pms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor

public class Owner implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long ownerId;
    @Column
    private String ownerName;
    @Column
    private String ownerPassWord;
    @Column
    private String ownerSex;
    @Column
    private String ownerPhone;
    @Column(columnDefinition = "int default 0")
    private Integer isDel;//1删除 0
}
