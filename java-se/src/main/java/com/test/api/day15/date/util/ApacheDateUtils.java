package com.test.api.day15.date.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 底层还是使用的java.util.Calendar类进行操作
 */
public class ApacheDateUtils {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date); // Sun Aug 27 12:51:08 CST 2023

        // 时间计算，并不会影响原Date对象
        System.out.println(DateUtils.addYears(date, -1));
        System.out.println(DateUtils.addMonths(date, 1));
        System.out.println(DateUtils.addDays(date, 7));
        System.out.println(DateUtils.addHours(date, -1));
        System.out.println(DateUtils.addMinutes(date, 10));
        System.out.println(DateUtils.addSeconds(date, 30));

        // 设置时间，并不会影响原Date对象
        System.out.println(DateUtils.setYears(date, 2000));
        System.out.println(DateUtils.setMonths(date, 10));
        System.out.println(DateUtils.setDays(date, 1));
        System.out.println(DateUtils.setHours(date, 10));
        System.out.println(DateUtils.setMinutes(date, 18));
        System.out.println(DateUtils.setSeconds(date, 18));
        System.out.println(DateUtils.setMilliseconds(date, 100));

        // 字符串转Date对象
        String dateStr = "2000-10-01 10:00:00.000";
        // public static Date parseDate(final String str, final String... parsePatterns) throws ParseException
        System.out.println(DateUtils.parseDate(dateStr, "yyyy-MM-dd HH:mm:ss.SSS"));

        System.out.println(date); // Sun Aug 27 12:51:08 CST 2023
    }
}
