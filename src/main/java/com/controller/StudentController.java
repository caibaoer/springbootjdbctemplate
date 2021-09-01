package com.controller;

import com.pojo.ResultBody;
import com.pojo.Student;
import com.pojo.User;
import com.service.StudentService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname StudentController
 * @Description TODO
 * @Date 2021/8/31 12:11
 * @Created by huangwencai
 */
@RestController
public class StudentController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResultBody> getStudentById (@PathVariable(value = "id") Integer id){
        ResultBody resultBody = new ResultBody();
        try {
            Student student = studentService.getStudentById(id);
            resultBody.setData(student);
            resultBody.setSuccess(true);
        } catch (Exception e) {
            resultBody.setSuccess(false);
            e.printStackTrace();
        }
        return ResponseEntity.ok(resultBody);
    }



    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "students", method = RequestMethod.GET)
    public ResponseEntity<ResultBody> getUserList (){
        ResultBody r = new ResultBody();
        try {
            List<Student> students = studentService.getStudentList();
            r.setData(students);
        } catch (Exception e) {
            r.setMessage(e.getClass().getName() + ":" + e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     * @param
     * @return

     * @requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，

     * 比如说：application/json或者是application/xml等。一般情况下来说常用其来处理application/json类型。

     *   就是从json中提取数据  参见：https://www.cnblogs.com/qiankun-site/p/5774300.html
     */
    @RequestMapping(value = "student", method = RequestMethod.POST)
    public ResponseEntity<ResultBody> add (@RequestBody Student student){
        ResultBody r = new ResultBody();
        try {
             studentService.add(student);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResultBody> delete (@PathVariable(value = "id") Integer id){
        ResultBody r = new ResultBody();
        try {
            int ret = studentService.delete(id);
        } catch (Exception e) {
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改用户信息
     * @param student
     * @return
     */
    @RequestMapping(value = "student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResultBody> update (@PathVariable("id") Integer id, @RequestBody Student student){
        ResultBody r = new ResultBody();
        try {
            int ret = studentService.update(id, student);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


}
