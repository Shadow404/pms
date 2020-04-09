package com.peiyuzhen.pms.service;

import com.peiyuzhen.pms.domain.User;

import java.util.List;

public interface UserService {
    List<User> allUser();//获取所有管理员

    void addUser(User user);//添加管理员账号

    void delUserById(String userId);

    User findUserById(String userId);

    void editUserByUserId(User user);

    int findUserName(String userName);
}
