package com.dao.impl;

import com.dao.StudentDao;
import com.dao.UserDao;
import com.pojo.Student;
import com.pojo.Student2;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

        String studentss= jdbcTemplate.queryForObject("select nick_name from tb_student where user_name=?",String.class);


        Date date=jdbcTemplate.queryForObject("select birth_day from tb_student where user_name='zs'",Date.class);

        int a=0;
        //方式一
       List<Student> students= jdbcTemplate.query("select * from tb_student where id = ?",new BeanPropertyRowMapper<>(Student.class),id);
        //方式二
        Object[] arr={id};
        List<Student> students2= jdbcTemplate.query("select * from tb_student where id = ?",new BeanPropertyRowMapper<Student>(Student.class),arr);
       return students.get(0);
    }

    @Override
    public Student2 getlocalDateStudentById(Integer id) {
        List<Student2> list = jdbcTemplate.query("select * from tb_student2", new BeanPropertyRowMapper(Student2.class) );
        return list.get(0);
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> list = jdbcTemplate.query("select * from tb_student", new BeanPropertyRowMapper(Student.class) );
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
