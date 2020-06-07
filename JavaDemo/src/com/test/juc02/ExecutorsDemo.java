package com.test.juc02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Executors创建线程池
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        /*
        pool-1-thread-1运行~
        pool-1-thread-1运行~
        pool-1-thread-1运行~
         */
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 3; i++) {
//            pool.submit(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "运行~");
//            });
//        }
//        pool.shutdown();

        /*
        pool-1-thread-2运行~
        pool-1-thread-3运行~
        pool-1-thread-1运行~
        pool-1-thread-3运行~
        pool-1-thread-1运行~
        pool-1-thread-2运行~
        pool-1-thread-1运行~
        pool-1-thread-2运行~
        pool-1-thread-3运行~
        pool-1-thread-1运行~
         */
//        ExecutorService pool2 = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            pool2.submit(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "运行~");
//            });
//        }
//        pool2.shutdown();

        /*
        pool-1-thread-1运行~
        pool-1-thread-2运行~
        pool-1-thread-3运行~
        pool-1-thread-5运行~
        pool-1-thread-4运行~
        pool-1-thread-6运行~
        pool-1-thread-7运行~
        pool-1-thread-8运行~
        pool-1-thread-9运行~
        pool-1-thread-10运行~
         */
        ExecutorService pool3 = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            pool3.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "运行~");
            });
        }
        pool3.shutdown();
    }
}
