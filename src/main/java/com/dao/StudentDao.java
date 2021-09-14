package com.dao;

import com.pojo.Student;
import com.pojo.Student2;
import com.pojo.User;

import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2021/8/31 12:01
 * @Created by huangwencai
 */
public interface StudentDao {
    Student getStudentById(Integer id);
    Student2 getlocalDateStudentById(Integer id);
    public List<Student> getStudentList();
    public int add(Student student);
    public int update(Integer id, Student student);
    public int delete(Integer id);
}
