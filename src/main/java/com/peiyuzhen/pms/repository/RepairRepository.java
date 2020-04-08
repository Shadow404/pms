package com.peiyuzhen.pms.repository;

import com.peiyuzhen.pms.domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface RepairRepository extends JpaRepository<Repair,Long> {
    @Query(nativeQuery = true,value = "select * from repair where repair_id=?1")
    Repair getRepairByRepairId(String repairId);
    @Query(nativeQuery = true,value = "update repair set result=?2,dealing_man=?3,is_Deal=1 where repair_id=?1 ")
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void updateRepairByRepairId(long repairId, String result, String dealingMan);
    @Query(nativeQuery = true,value = "SELECT repair_id,owner_name,owner_phone,owner_sex,repair_content,repair_day,dealing_man,result,is_deal FROM repair A LEFT JOIN owner B ON A.owner_id=B.owner_id")
    List<Map<String, Object>> findAllRepair();
    @Query(nativeQuery = true,value = "select id,dealing_man,owner_id,type,content,day,result,\n" +
            "case is_deal when '1' then '已解决' else '未解决' end as is_deal\n" +
            "from (SELECT repair_id as id,dealing_man,is_deal,owner_id,'维修' as type,repair_content as content,repair_day as day, result from repair where owner_id=?1  union\n" +
            "SELECT complain_id as id,dealing_man,is_deal,owner_id,'投诉' as type,complain_content as content,complain_day as day, result from complain where owner_id=?1\n" +
            ") alias GROUP BY id ORDER BY day desc")
    List<Map<String,Object>> findAllRcByOwnerId(String ownerId);
}
//select * from (SELECT repair_id as id,dealing_man,is_deal,owner_id,'维修' as type,repair_content as content,repair_day as day, result from repair where owner_id=?1  union\n" +
//            "SELECT complain_id as id,dealing_man,is_deal,owner_id,'投诉' as type,complain_content as content,complain_day as day, result from complain where owner_id=?1 \n" +
//            ") alias GROUP BY id ORDER BY day desc