package com.dao;

import com.pojo.User;

import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2021/8/31 12:01
 * @Created by huangwencai
 */
public interface UserDao {
    User getUserById(Integer id);
    public List<User> getUserList();
    public int add(User user);
    public int update(Integer id, User user);
    public int delete(Integer id);
}
