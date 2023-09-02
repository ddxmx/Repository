package com.test.jdk8.day21.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * JDK 8新增的日期时间LocalDateTime
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // 使用当前时间实例化
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(date); // 2021-02-08
        System.out.println(time); // 22:34:07.219
        System.out.println(dateTime); // 2021-02-08T22:34:07.219

        // 使用指定时间实例化
        LocalDateTime localDateTime = LocalDateTime.of(2021, 2, 1, 18, 30, 15);
        System.out.println(localDateTime); // 2021-02-01T18:30:15

        // get()方法
        System.out.println(localDateTime.getYear()); // 2021
        System.out.println(localDateTime.getMonthValue()); // 2
        System.out.println(localDateTime.getDayOfMonth()); // 1
        System.out.println(localDateTime.getHour()); // 18
        System.out.println(localDateTime.getMinute()); // 30
        System.out.println(localDateTime.getSecond()); // 15

        // LocalDateTime不可变性
        LocalDateTime localDateTime3 = localDateTime.withMonth(11).withDayOfMonth(15);
        System.out.println(localDateTime); // 2021-02-01T18:30:15
        System.out.println(localDateTime3); // 2021-11-15T18:30:15

        // 加时间
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3);
        System.out.println(localDateTime4); // 2021-05-01T18:30:15

        // 减时间
        LocalDateTime localDateTime5 = localDateTime.minusDays(2);
        System.out.println(localDateTime5); // 2021-01-30T18:30:15
    }
}
