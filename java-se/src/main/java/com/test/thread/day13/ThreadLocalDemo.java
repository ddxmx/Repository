package com.test.thread.day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用ThreadLocal解决SimpleDateFormat线程不安全的问题
 * ThreadLocal对象，每个线程使用的是独占的对象
 */
public class ThreadLocalDemo {
    // ThreadLocal初始化
    private static ThreadLocal<SimpleDateFormat> threadLocal
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

    public static void main(String[] args) {
        // SimpleDateFormat线程不安全验证
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        ExecutorService pool = Executors.newFixedThreadPool(100);
        while (true) {
            pool.submit(() -> {
                Date date = new Date();
                String dateStr = sdf.format(date);
                Date date2 = null;
                try {
                    date2 = sdf.parse(dateStr);
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
        */

        // 使用ThreadLocal验证
        ExecutorService pool = Executors.newFixedThreadPool(100);
        while (true) {
            pool.submit(() -> {
                Date date = new Date();
                String dateStr = threadLocal.get().format(date);
                Date date2 = null;
                try {
                    date2 = threadLocal.get().parse(dateStr);
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
