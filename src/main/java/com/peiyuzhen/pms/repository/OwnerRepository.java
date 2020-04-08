package com.peiyuzhen.pms.repository;

import com.peiyuzhen.pms.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    @Query(nativeQuery = true,value = "select * from owner where is_del=0")
    List<Owner> findAllOwnerNotDel();
    @Query(nativeQuery = true,value = "update owner set is_del=1 where owner_id=?1")
    @Modifying
    @Transactional
    void delOwnerByOwnerId(String ownerId);
    @Query(nativeQuery = true,value = "select * from owner where owner_phone=?1 and is_del=0")
    Owner findByOwnerPhone(String ownerPhone);

    @Query(nativeQuery = true,value = "select * from owner where owner_id=?1 and is_del=0")
    Owner findOwnerById(String ownerId);
    @Query(nativeQuery = true,value = "select count(*) from owner where owner_phone=?1 and is_del=0")
    int findOwnerByPhone(String phone);
}
