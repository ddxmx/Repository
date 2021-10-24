package com.test.api.day21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间格式化
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        // 时间 -> 指定格式的字符串
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sdf.format(date)); // 2021-02-08 21:43:26.546

        // 指定格式的字符串 -> 时间
        String dateStr = "2000-03-12 18:18:18.111";
        Date date2 = null;
        try {
            date2 = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2); // Sun Mar 12 18:18:18 CST 2000

        // 格式化的pattern中指定非匹配字符，应该使用单引号引起来
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String dateStr2 = sdf2.format(new Date());
        System.out.println(dateStr2); // 2021-02-08T21:56:50.544
    }
}
