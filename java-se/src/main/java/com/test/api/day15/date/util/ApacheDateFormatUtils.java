package com.test.api.day15.date.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;

public class ApacheDateFormatUtils {
    public static void main(String[] args) {
        Date nowDate = new Date();
        Calendar nowCalendar = Calendar.getInstance();
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";

        // public static String format(final Date date, final String pattern)
        System.out.println(DateFormatUtils.format(nowDate, pattern)); // 2023-08-27 13:04:53.356

        // public static String formatUTC(final Date date, final String pattern)
        System.out.println(DateFormatUtils.formatUTC(nowDate, pattern)); // 2023-08-27 05:04:53.356

        // public static String format(final long millis, final String pattern)
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(), pattern)); // 2023-08-27 13:04:53.450

        // public static String format(final Calendar calendar, final String pattern)
        System.out.println(DateFormatUtils.format(nowCalendar, pattern)); // 2023-08-27 13:04:53.356
    }
}
