package com.peiyuzhen.pms.service;

import com.peiyuzhen.pms.domain.Repair;
import com.peiyuzhen.pms.vo.RcVo;
import com.peiyuzhen.pms.vo.RepairVo;

import java.util.List;

public interface RepairService {
    List<RepairVo> getAllRepairList();

    Repair getRepairByRepairId(String repairId);

    void updateRepairByRepairId(Repair repair);

    void delRepair(String repairId);

    List<RcVo> findAllRcByOwnerId(String ownerId);
}
