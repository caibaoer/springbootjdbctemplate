package com.dao.impl;

import com.dao.StudentDao;
import com.dao.UserDao;
import com.pojo.Student;
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
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;  //这个是系统自带的
    @Override
    public Student getStudentById(Integer id) {
        List<Student> list=jdbcTemplate.query("select * from tb_student where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper(Student.class)
        );
        if(CollectionUtils.isEmpty(list)){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> list = jdbcTemplate.query("select * from tb_student", new Object[]{}, new BeanPropertyRowMapper(Student.class));
        return list;
    }

    @Override
    public int add(Student student) {
        return jdbcTemplate.update("insert into tb_student(user_name, age, birth_day) values(?, ?, ?)",
                student.getUserName(),student.getAge(), student.getBirthDay());
    }

    @Override
    public int update(Integer id, Student student) {
        return jdbcTemplate.update("UPDATE tb_student SET user_name = ? , age = ? WHERE id=?",
                student.getUserName(),student.getAge(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE from tb_student where id = ? ",id);
    }
}
