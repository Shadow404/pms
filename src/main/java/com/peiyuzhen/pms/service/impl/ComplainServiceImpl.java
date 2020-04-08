package com.peiyuzhen.pms.service.impl;

import com.peiyuzhen.pms.domain.Complain;
import com.peiyuzhen.pms.repository.ComplainRepository;
import com.peiyuzhen.pms.service.ComplainService;
import com.peiyuzhen.pms.util.CommUtils;
import com.peiyuzhen.pms.vo.ComplainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    private ComplainRepository complainRepository;


    @Override
    public List<ComplainVo> allComplain() {
        List<ComplainVo> complainVos=new ArrayList<>();
        List<Map<String,Object>>maps=complainRepository.findAllComplain();
        for (Map<String,Object> map:maps
             ) {
            complainVos.add(CommUtils.toCamelCase(map,ComplainVo.class));
        }
        return complainVos;
    }

    @Override
    public Complain findComplainById(String complainId) {
        return complainRepository.findComplainById(complainId);
    }

    @Override
    public void updateComplainByRepairId(Complain complain) {
        complainRepository.editComplainById(complain.getResult(),complain.getDealingMan(),complain.getComplainId());
    }

    @Override
    public void delComplain(String complainId) {
        complainRepository.deleteById(Long.parseLong(complainId));
    }

}
