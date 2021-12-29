package com.test.api.day15.date;

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
        Date now = new Date();
        System.out.println(now); // Mon Feb 08 21:23:56 CST 2021
        // date对象对应时间的毫秒数
        System.out.println(now.getTime()); // 1612790701850

        // 二、有参构造，指定时间
        Date date = new Date(1612790501850L);
        System.out.println(date); // Mon Feb 08 21:21:41 CST 2021

        // java.sql.Date操作
        java.sql.Date sqlDate = new java.sql.Date(1612790501850L);
        System.out.println(sqlDate); // 2021-02-08
        long time = sqlDate.getTime();
        System.out.println(time); // 1612790501850

        // java.util.Date和java.sql.Date对象转换
        // java.util.Date -> java.sql.Date
        Date date2 = new Date();
        java.sql.Date sqlDate2 = new java.sql.Date(date2.getTime());
        System.out.println(sqlDate2); // 2021-02-08
        // java.sql.Date -> java.util.Date
        java.sql.Date sqlDate3 = new java.sql.Date(1612790501850L);
        Date date3 = new Date(sqlDate3.getTime());
        System.out.println(date3); // Mon Feb 08 21:21:41 CST 2021
    }
}
