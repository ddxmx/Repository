package com.test.jdk8.day21.date;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * JDK 8新增的日期时间Instant时间戳
 */
public class InstantDemo {
    public static void main(String[] args) {
        // UTC时间
        Instant instant = Instant.now();
        System.out.println(instant); // 2021-10-26T16:07:05.514Z

        // 从Instant转换为java.util.Date
        Date date = Date.from(instant);
        System.out.println(date); // Wed Oct 27 00:07:05 CST 2021

        // 当前时间推后1天
        Instant next = instant.plusSeconds(TimeUnit.DAYS.toSeconds(1));
        System.out.println(next); // 2021-10-27T16:07:05.514Z

        // 获取偏移量时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2021-10-27T00:07:05.514+08:00

        // 获取秒数
        long seconds = instant.getEpochSecond();
        System.out.println(seconds); // 1635264425

        // 获取毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli); // 1635264425514

        Instant instant2 = Instant.ofEpochMilli(milli);
        System.out.println(instant2); // 2021-10-26T16:07:05.514Z

    }
}
