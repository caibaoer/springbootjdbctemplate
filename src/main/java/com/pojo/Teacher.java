package com.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Teacher {
    @JSONField(name = "NAME")
    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birth;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birth2;
}
