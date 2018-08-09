package com.marlee.myblog.service.impl;

import com.marlee.myblog.dao.UserDao;
import com.marlee.myblog.entity.User;
import com.marlee.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

@Autowired
private UserDao userDao;
    @Override
    public int regist(User user) {
        return 0;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByPhone(String phone) {
        User user=new User();
        user.setPhone(phone);
        return userDao.selectOne(user);
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public void update(User user) {

    }
}
