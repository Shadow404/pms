package com.peiyuzhen.pms.repository;

import com.peiyuzhen.pms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    @Query(nativeQuery = true,value = "select * from user where user_name=?1 and is_del=0")
    User findByUserName(String userName);
    @Query(nativeQuery = true,value = "select * from user where is_del=0 order  by user_id")
    List<User> findAll();
    @Query(nativeQuery = true,value = "update user set is_del=1 where user_id=?1")
    @Modifying
    @Transactional
    void delUserById(String userId);
    @Query(nativeQuery = true,value = "select * from user where is_del=0 and user_id=?1")
    User findUserById(String userId);
    @Query(nativeQuery = true,value = "update user set user_addr=?1,user_phone=?2 where user_id=?3")
    @Modifying
    @Transactional
    void editUserByUserId(String userAddr, String userPhone, String userId);
    @Query(nativeQuery = true,value = "select count(1) from user where is_del=0 and user_name=?1")
    int findUserName(String userName);
}
