package com.test.thread.day15;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子操作
 */
public class AtomicDemo {
    // private static int sum = 0;
    private static AtomicInteger sum = new AtomicInteger(0);

    public static void increase() {
        // ++操作为非原子性操作
        // sum++;
        sum.incrementAndGet();
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        int count = 10000;

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                AtomicDemo.increase();
            }
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                AtomicDemo.increase();
            }
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                AtomicDemo.increase();
            }
            countDownLatch.countDown();
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum); // 29919
    }
}
