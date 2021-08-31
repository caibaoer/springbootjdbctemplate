package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/8/31 11:58
 * @Created by huangwencai
 */
@Data
public class User {
    private int id;
    private String username;
    private int age;
    /**
     * 是JSONFormat这个注解，不是@DateTimeFormat  特别要注意、、
     *
     *  注解@JsonFormat主要是后台到前台的时间格式的转换
     *
     *  注解@DateTimeFormat主要是前后到后台的时间格式的转换
     *
     */
   // @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8" )
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ctm;
}

