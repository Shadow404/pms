package com.peiyuzhen.pms.service.impl;

import com.peiyuzhen.pms.domain.Repair;
import com.peiyuzhen.pms.repository.OwnerRepository;
import com.peiyuzhen.pms.repository.RepairRepository;
import com.peiyuzhen.pms.service.RepairService;
import com.peiyuzhen.pms.util.CommUtils;
import com.peiyuzhen.pms.vo.RcVo;
import com.peiyuzhen.pms.vo.RepairVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Override
    public List<RepairVo> getAllRepairList() {

       List<RepairVo> repairVos=new ArrayList<>();
       List<Map<String,Object>> maps=repairRepository.findAllRepair();
       for (Map<String,Object> map:maps){
           repairVos.add(CommUtils.toCamelCase(map,RepairVo.class));
       }
        return repairVos;
    }

    @Override
    public Repair getRepairByRepairId(String repairId) {
        return repairRepository.getRepairByRepairId(repairId);
    }

    @Override
    public void updateRepairByRepairId(Repair repair) {
        repairRepository.updateRepairByRepairId(repair.getRepairId(),repair.getResult(),repair.getDealingMan());
    }

    @Override
    public void delRepair(String repairId) {
        repairRepository.deleteById(Long.parseLong(repairId));
    }

    @Override
    public List<RcVo> findAllRcByOwnerId(String ownerId) {
        List<RcVo> rcVos=new ArrayList<>();
        List<Map<String,Object>> maps=repairRepository.findAllRcByOwnerId(ownerId);
        for (Map<String,Object> map:maps){
            rcVos.add(CommUtils.toCamelCase(map,RcVo.class));
        }
        return rcVos;

    }
}
