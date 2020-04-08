package com.peiyuzhen.pms.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class RcVo {
    private String id;
    private String dealingMan;
    private String isDeal;
    private String ownerId;
    private String type;
    private String content;
    private Timestamp day;
    private String result;
}
