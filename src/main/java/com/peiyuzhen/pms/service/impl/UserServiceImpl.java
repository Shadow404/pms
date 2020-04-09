package com.peiyuzhen.pms.service.impl;

import com.peiyuzhen.pms.domain.User;
import com.peiyuzhen.pms.repository.UserRepository;
import com.peiyuzhen.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
         userRepository.save(user);
    }

    @Override
    public void delUserById(String userId) {
        userRepository.delUserById(userId);
    }

    @Override
    public User findUserById(String userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public void editUserByUserId(User user) {
         userRepository.editUserByUserId(user.getUserAddr(),user.getUserPhone(),user.getUserId().toString());
    }

    @Override
    public int findUserName(String userName) {
        return userRepository.findUserName(userName);
    }
}
