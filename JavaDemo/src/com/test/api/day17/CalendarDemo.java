package com.test.api.day17;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar类
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
        System.out.println("year=" + year + ",month=" + month + ",day=" + day); // year=2021,month=9,day=26

        // set()
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 15

        // add()
        calendar.add(Calendar.YEAR, -1);
        System.out.println(calendar.get(Calendar.YEAR)); // 2020

        // getTime()，Calendar -> Date
        Date date = calendar.getTime();
        System.out.println(date); // Thu Oct 15 00:06:01 CST 2020

        // setTime()，Date -> Calendar
        Date date2 = new Date();
        calendar.setTime(date2);
        System.out.println(calendar.get(Calendar.MONTH)); // 9
    }
}
