package com.test.api.day21;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * JDK 8新增的日期时间Instant
 */
public class InstantDemo {
    public static void main(String[] args) {
        // UTC时间
        Instant instant = Instant.now();
        System.out.println(instant); // 2021-02-08T14:49:38.738Z

        // 从Instant转换为java.util.Date
        Date date = Date.from(instant);
        System.out.println(date); // Mon Feb 08 23:23:37 CST 2021

        // 获取偏移量时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2021-02-08T22:52:12.081+08:00

        // 获取毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli); // 1612796005669

        System.out.println(new Date(milli)); // Mon Feb 08 22:54:22 CST 2021

        Instant instant2 = Instant.ofEpochMilli(1612786005669L);
        System.out.println(instant2); // 2021-02-08T12:06:45.669Z

    }
}
