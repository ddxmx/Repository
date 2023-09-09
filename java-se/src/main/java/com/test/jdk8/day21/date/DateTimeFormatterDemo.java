package com.test.jdk8.day21.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * JDK 8新增的日期时间格式化类DateTimeFormatter
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        // 创建日期时间格式化对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("=================LocalDateTime转换为字符串=================");
        // 格式化日期时间
        String dateTimeStr = dtf.format(LocalDateTime.now());
        System.out.println(dateTimeStr); // 2021-02-08 22:59:09

        System.out.println("=================字符串转换为LocalDateTime=================");
        // 解析日期时间
        TemporalAccessor accessor = dtf.parse("2020-01-02 14:12:20");
        LocalDateTime localDateTime = LocalDateTime.from(accessor);
        System.out.println(localDateTime); // 2020-01-02T14:12:20
    }
}
