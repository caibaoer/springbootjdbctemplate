package com.service;

import com.pojo.Student;
import com.pojo.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/8/31 12:09
 * @Created by huangwencai
 */
public interface StudentService {
    Student getStudentById(Integer id);
    public List<Student> getStudentList();
    public int add(Student user);
    public int update(Integer id, Student user);
    public int delete(Integer id);
}

