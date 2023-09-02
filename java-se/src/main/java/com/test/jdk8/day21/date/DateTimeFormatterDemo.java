package com.test.jdk8.day21.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * JDK 8新增的日期时间格式化类DateTimeFormatter
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        // 实例化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化日期时间
        String dateStr = dtf.format(LocalDateTime.now());
        System.out.println(dateStr); // 2021-02-08 22:59:09

        // 解析日期时间
        TemporalAccessor parse = dtf.parse("2020-01-02 14:12:20");
        LocalDateTime localDateTime = LocalDateTime.from(parse);
        System.out.println(localDateTime); // 2020-01-02T14:12:20
    }
}
