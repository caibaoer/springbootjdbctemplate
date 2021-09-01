package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2021/8/31 11:58
 * @Created by huangwencai
 */
@Data
@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "age")
    //@Transient   //不持久化，意思就是保存的时候，不保存该字段的值  但是查询是可以查到的  但是在该项目里面的话，是使用JDBCTemplate方法，这个注解没起效果，应该是要在 JPA方式的才可以。
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
    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "nick_name")
    private String nickName;

}

