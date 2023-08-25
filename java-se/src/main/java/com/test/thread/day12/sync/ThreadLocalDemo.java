package com.test.thread.day12.sync;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 使用ThreadLocal解决SimpleDateFormat线程不安全的问题
 * ThreadLocal对象，每个线程使用的是独占的对象
 */
public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=======================SimpleDateFormat线程不安全验证=======================");
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            ExecutorService pool = Executors.newFixedThreadPool(100);
            for (int i = 0; i < 100; i++) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        Date now = new Date();
                        String nowStr = sdf.format(now);
                        Date date = null;
                        try {
                            date = sdf.parse(nowStr);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (!now.equals(date)) {
                            System.out.println(now + "->" + nowStr + "->" + date);
                        }
                    }
                });
            }

            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        }

        System.out.println("=======================使用ThreadLocal=======================");
        {
            ThreadLocal<SimpleDateFormat> localSdf
                    = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

            ExecutorService pool = Executors.newFixedThreadPool(100);
            for (int i = 0; i < 100; i++) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        Date now = new Date();
                        String nowStr = localSdf.get().format(now);
                        Date date = null;
                        try {
                            date = localSdf.get().parse(nowStr);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (!now.equals(date)) {
                            System.out.println(now + "->" + nowStr + "->" + date);
                        }
                    }
                });
            }

            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        }
    }
}
