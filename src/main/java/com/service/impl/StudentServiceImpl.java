package com.service.impl;

import com.dao.StudentDao;
import com.dao.UserDao;
import com.pojo.Student;
import com.pojo.User;
import com.service.StudentService;
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
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }
    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }
    @Override
    public int add(Student user) {
        return studentDao.add(user);
    }
    @Override
    public int update(Integer id, Student user) {
        return studentDao.update(id, user);
    }
    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }
}
