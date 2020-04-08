package com.peiyuzhen.pms.repository;

import com.peiyuzhen.pms.domain.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PayRepository extends JpaRepository<Pay,Long> {
    @Query(nativeQuery = true,value = "select a.*,b.owner_name from pay a left JOIN owner b on a.owner_id=b.owner_id order by is_pay")
    List<Map<String,Object>> findAllPay();

    @Query(nativeQuery = true,value = "select * from pay order by is_pay where owner_id = ? order by is_pay")
    List<Pay> findAllByOwnerId(Integer id);

    @Query(nativeQuery = true,value = "select * from pay  where pay_id = ?")
    Pay findAllByPayId(Integer id);

    // 修改缴费单
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update pay set pay_name = ?1, owner_id = ?2, price = ?3, dealing_man = ?4 where pay_id = ?5")
    Integer editPayById(String pay_name, Long owner_id, BigDecimal price, String dealing_man, Integer payId);


    @Query(nativeQuery = true,value = "insert into pay(owner_id, pay_name,pay_type, price, dealing_man) values (?1,?2,?3,?4,?5)")
    @Modifying
    @Transactional
    void addPay(Long ownerId, String payName, Integer payType, BigDecimal price, String dealingMan);
    @Query(nativeQuery = true,value = "select a.*,b.owner_name from pay a left JOIN owner b on a.owner_id=b.owner_id where pay_id=?1")
    Map<String, Object> findPayByPayId(String payId);
    @Query(nativeQuery = true,value = "select a.*,b.owner_name from pay a left JOIN owner b on a.owner_id=b.owner_id where a.owner_id=?1 order by is_pay")
    List<Map<String, Object>> findAllByOwnerId(String ownerId);
    @Query(nativeQuery = true,value = "update pay set is_pay=1 where pay_id=?1")
    @Modifying
    @Transactional
    void payMoney(String payId);
}
