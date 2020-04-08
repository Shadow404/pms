package com.peiyuzhen.pms.repository;

import com.peiyuzhen.pms.domain.PayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PayTypeRepository extends JpaRepository<PayType,Integer> {
    @Query(nativeQuery = true,value = "select unit_price from pay_type where pay_type_id=?1")
    String findUnitPriceById(String payTypeId);
}
