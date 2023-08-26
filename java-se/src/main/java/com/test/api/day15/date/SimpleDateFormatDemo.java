package com.test.api.day15.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间格式化
 * SimpleDateFormat是非线程安全的，多线程场景下可能出现线程安全问题
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        // 时间 -> 指定格式的字符串
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        // public final String format(Date date)
        System.out.println(sdf.format(now)); // 2021-02-08 21:43:26.546

        // 指定格式的字符串 -> 时间
        String pastStr = "2000-03-12 18:18:18.111";
        Date past = sdf.parse(pastStr);
        System.out.println(past); // Sun Mar 12 18:18:18 CST 2000

        // 格式化的pattern中指定非匹配字符，应该使用单引号引起来
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String dateStr = sdf2.format(now);
        System.out.println(dateStr); // 2021-02-08T21:43:26.546
    }
}
