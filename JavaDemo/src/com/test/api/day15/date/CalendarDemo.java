package com.test.api.day15.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar类
 * month从0开始
 */
public class CalendarDemo {
    public static void main(String[] args) {
        // 获取实例化对象
        Calendar calendar = Calendar.getInstance();

        // 常用方法
        // get()
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // month是从0开始的
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("year=" + year + ",month=" + month + ",day=" + day); // year=2021,month=11,day=29

        // set()
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 15

        // add()
        calendar.add(Calendar.YEAR, -1);
        System.out.println(calendar.get(Calendar.YEAR)); // 2020

        // getTime()，Calendar -> Date
        Date date = calendar.getTime();
        System.out.println(date); // Tue Dec 15 22:43:22 CST 2020

        // setTime()，Date -> Calendar
        Date date2 = new Date();
        calendar.setTime(date2);
        System.out.println(calendar.get(Calendar.MONTH)); // 11

        // 获取2小时前的时间戳
        calendar.add(Calendar.HOUR_OF_DAY, -2);
        System.out.println(calendar.getTime()); // Wed Dec 29 20:43:22 CST 2021
        System.out.println(calendar.getTime().getTime()); // 1640781802714
    }
}
