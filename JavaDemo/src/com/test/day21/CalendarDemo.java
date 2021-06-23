package com.test.day21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar类
 */
public class CalendarDemo {
    public static void main(String[] args) {
        //实例化方式一，推荐
        Calendar calendar = Calendar.getInstance();
        //实例化方式二
        Calendar calendar2 = new GregorianCalendar();

        //常用方法
        //get()
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); //month是从0开始的
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("year=" + year + ",month=" + month + ",day=" + day); //year=2021,month=1,day=8

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //15

        //add()
        calendar.add(Calendar.YEAR, -1);
        System.out.println(calendar.get(Calendar.YEAR)); //2020

        //getTime()
        Date date = calendar.getTime();
        System.out.println(date); //Sat Feb 15 22:17:13 CST 2020

        //setTime()
        Date date2 = null;
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date2);
        System.out.println(calendar.get(Calendar.MONTH)); //10
    }
}
