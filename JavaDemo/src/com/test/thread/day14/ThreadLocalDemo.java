package com.test.thread.day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用ThreadLocal解决SimpleDateFormat线程不安全的问题
 */
public class ThreadLocalDemo {
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    public static SimpleDateFormat getDateFormat() {
        // 从threadLocal中获取当前线程的SimpleDateFormat对象
        SimpleDateFormat sdf = threadLocal.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            // 将当前对象放入threadLocal中
            threadLocal.set(sdf);
        }
        return sdf;
    }

    public static void main(String[] args) {
        // SimpleDateFormat线程不安全验证
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        // ExecutorService pool = Executors.newFixedThreadPool(100);
        // while (true) {
        //     pool.submit(() -> {
        //         Date date = new Date();
        //         String dateStr = sdf.format(date);
        //         Date date2 = null;
        //         try {
        //             date2 = sdf.parse(dateStr);
        //         } catch (ParseException e) {
        //             e.printStackTrace();
        //         }
        //         if (date.equals(date2)) {
        //             System.out.println(true);
        //         } else {
        //             System.out.println("==========false==========");
        //         }
        //     });
        // }

        // 使用ThreadLocal验证
        ExecutorService pool = Executors.newFixedThreadPool(100);
        while (true) {
            pool.submit(() -> {
                Date date = new Date();
                String dateStr = getDateFormat().format(date);
                Date date2 = null;
                try {
                    date2 = getDateFormat().parse(dateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (date.equals(date2)) {
                    System.out.println(true);
                } else {
                    System.out.println("==========false==========");
                }
            });
        }
    }
}
