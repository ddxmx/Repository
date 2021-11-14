package com.test.api.day17;

import java.util.Date;

/**
 * JDK8之前日期时间API
 */
public class DateTimeDemo {
    public static void main(String[] args) {
        // 1970-01-01 00:00:00.000到现在的毫秒数
        long millis = System.currentTimeMillis();
        System.out.println(millis); // 1612790429573

        /*
         * java.util.Date类  父类
         * |- java.sql.Date类   子类
         */
        // 一、无参构造，当前时间
        Date date = new Date();
        System.out.println(date); // Mon Feb 08 21:23:56 CST 2021
        // date对象对应时间的毫秒数
        long time = date.getTime();
        System.out.println(time); // 1612790701850

        // 二、有参构造，指定时间
        Date date2 = new Date(1612790501850L);
        System.out.println(date2); // Mon Feb 08 21:21:41 CST 2021

        // java.sql.Date操作
        java.sql.Date sqlDate = new java.sql.Date(1612790501850L);
        System.out.println(sqlDate); // 2021-02-08
        long time2 = sqlDate.getTime();
        System.out.println(time2); // 1612790501850

        // java.util.Date和java.sql.Date对象转换
        java.sql.Date sqlDate2 = new java.sql.Date(new Date().getTime());
        System.out.println(sqlDate2); // 2021-02-08
        Date date3 = new Date(new java.sql.Date(1612790501850L).getTime());
        System.out.println(date3); // Mon Feb 08 21:21:41 CST 2021
    }
}
