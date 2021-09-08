package com.controller;

import com.pojo.Person;
import com.pojo.ResultBody;
import com.pojo.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname TestTimeController
 * @Description c
 * @Date 2021/9/8 16:53
 * @Created by huangwencai
 */
@RestController
public class TestTimeController {
    @RequestMapping(value = "person", method = RequestMethod.POST)
    public Person update (@RequestBody Person person){
        ResultBody r = new ResultBody();
        try {
            int a=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }


    @RequestMapping(value = "person2", method = RequestMethod.POST)
    public Person t (Person person){
        ResultBody r = new ResultBody();
        try {
            int a=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }
}
