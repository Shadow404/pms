package com.peiyuzhen.pms.domain;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class Rc {
    private String type;
    private String ownerId;
    private String content;
}
