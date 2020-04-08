package com.peiyuzhen.pms.service;

import com.peiyuzhen.pms.domain.Complain;
import com.peiyuzhen.pms.vo.ComplainVo;

import java.util.List;

public interface ComplainService {
    List<ComplainVo> allComplain();//获取所有投诉信息

    Complain findComplainById(String complainId);

    void updateComplainByRepairId(Complain complain);

    void delComplain(String complainId);
}
