package com.test.jdk8.day21.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * JDK 8新增的日期时间LocalDateTime
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        System.out.println("============================LocalDateTime实例化============================");
        // 使用当前时间实例化
        LocalDate date = LocalDate.now(); // 获取日期
        LocalTime time = LocalTime.now(); // 获取时间
        LocalDateTime dateTime = LocalDateTime.now(); // 获取日期时间
        System.out.println(date); // 2021-02-08
        System.out.println(time); // 22:34:07.219
        System.out.println(dateTime); // 2021-02-08T22:34:07.219

        // 使用指定时间实例化
        LocalDateTime localDateTime = LocalDateTime.of(2021, 2, 1, 18, 30, 15);
        System.out.println(localDateTime); // 2021-02-01T18:30:15

        System.out.println("============================获取LocalDateTime属性============================");
        // get()方法
        System.out.println(localDateTime.getYear()); // 2021
        System.out.println(localDateTime.getMonthValue()); // 2
        System.out.println(localDateTime.getDayOfMonth()); // 1
        System.out.println(localDateTime.getHour()); // 18
        System.out.println(localDateTime.getMinute()); // 30
        System.out.println(localDateTime.getSecond()); // 15

        System.out.println("============================LocalDateTime不可变============================");
        // LocalDateTime不可变性
        LocalDateTime nextDateTime = localDateTime.withMonth(11).withDayOfMonth(15);
        System.out.println(localDateTime); // 2021-02-01T18:30:15
        System.out.println(nextDateTime); // 2021-11-15T18:30:15

        System.out.println("============================LocalDateTime时间计算============================");
        // 加时间
        System.out.println(localDateTime.plusMonths(3)); // 2021-05-01T18:30:15

        // 减时间
        System.out.println(localDateTime.minusDays(2)); // 2021-01-30T18:30:15
    }
}
