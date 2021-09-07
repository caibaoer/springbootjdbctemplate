package com.pojo;

import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 使用阿里巴巴的fastjson 里面的@JSONField(format = "yyyy-MM-dd HH:mm:ss")  转换字段
 */
public class TestDemo {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.setAge(23);
        teacher.setName("zs");
        teacher.setBirth(new Date());
        teacher.setBirth2(LocalDateTime.now());
        System.out.println(JSON.toJSONString(teacher));
    }
}
