package com.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @Classname T
 * @Description TODO
 * @Date 2021/9/14 11:04
 * @Created by huangwencai
 */
public class T {
    public static void main(String[] args) {



        LocalDate localDate = LocalDate.now();

        LocalDate localDate1 = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(localDate);
        System.out.println(localDate1);
    }
}
