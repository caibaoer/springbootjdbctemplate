package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2021/8/31 12:10
 * @Created by huangwencai
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }
    @Override
    public int add(User user) {
        return userDao.add(user);
    }
    @Override
    public int update(Integer id, User user) {
        return userDao.update(id, user);
    }
    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }
}
