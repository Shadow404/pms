package com.peiyuzhen.pms.repository;

import com.peiyuzhen.pms.domain.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ComplainRepository extends JpaRepository<Complain,Long> {

    @Query(nativeQuery = true,value = "SELECT complain_id,owner_name,owner_phone,owner_sex,complain_content,complain_day,dealing_man,result,is_deal FROM complain A LEFT JOIN owner B ON a.owner_id=b.owner_id")
    List<Map<String,Object>> findAllComplain();


    @Query(nativeQuery = true,value = "select * from complain where complain_id = ?")
    Complain findComplainById(String complainId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update complain set result = ?1, dealing_man = ?2 ,is_deal = 1 where complain_id = ?3")
    Integer editComplainById(String result,String dealing_man, Long complainId);


}
