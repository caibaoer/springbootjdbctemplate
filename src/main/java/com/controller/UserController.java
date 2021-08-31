package com.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pojo.ResultBody;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/8/31 12:11
 * @Created by huangwencai
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResultBody> getUserById (@PathVariable(value = "id") Integer id){
        ResultBody resultBody = new ResultBody();
        try {
            User user = userService.getUserById(id);
            resultBody.setData(user);
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
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<ResultBody> getUserList (){
        ResultBody r = new ResultBody();
        try {
            List<User> users = userService.getUserList();
            r.setData(users);
        } catch (Exception e) {
            r.setMessage(e.getClass().getName() + ":" + e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     * @param user
     * @return

     * @requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，

     * 比如说：application/json或者是application/xml等。一般情况下来说常用其来处理application/json类型。

     *   就是从json中提取数据  参见：https://www.cnblogs.com/qiankun-site/p/5774300.html
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<ResultBody> add (@RequestBody User user){
        ResultBody r = new ResultBody();
        try {
            int orderId = userService.add(user);
            if (orderId < 0) {
                r.setSuccess(true);

            } else {
                r.setSuccess(false);

            }
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
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResultBody> delete (@PathVariable(value = "id") Integer id){
        ResultBody r = new ResultBody();
        try {
            int ret = userService.delete(id);
        } catch (Exception e) {
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResultBody> update (@PathVariable("id") Integer id, @RequestBody User user){
        ResultBody r = new ResultBody();
        try {
            int ret = userService.update(id, user);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


}
