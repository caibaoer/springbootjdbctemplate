package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Date 2021/8/31 12:02
 * @Created by huangwencai
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;  //这个是系统自带的
    @Override
    public User getUserById(Integer id) {
        List<User> list=jdbcTemplate.query("select * from tb_user where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper(User.class)
        );
        if(CollectionUtils.isEmpty(list)){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    public List<User> getUserList() {
        List<User> list = jdbcTemplate.query("select * from tb_user", new Object[]{}, new BeanPropertyRowMapper(User.class));
        return list;
    }

    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into tb_user(username, age, ctm) values(?, ?, ?)",
                user.getUsername(),user.getAge(), new Date());
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update("UPDATE tb_user SET username = ? , age = ? WHERE id=?",
                user.getUsername(),user.getAge(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE from tb_user where id = ? ",id);
    }
}
