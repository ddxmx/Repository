package com.test.thread.day13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicRunnable implements Runnable {
    private static CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            AtomicDemo.increase();
        }
        latch.countDown();
    }

    public static CountDownLatch getLatch() {
        return latch;
    }
}

/**
 * 原子操作
 */
public class AtomicDemo {
    // private static int value = 0;
    private static AtomicInteger value = new AtomicInteger(0);

    public static void increase() {
        // ++操作为非原子性操作
        // value++;
        value.incrementAndGet();
    }

    public static void main(String[] args) {
        new Thread(new AtomicRunnable()).start();
        new Thread(new AtomicRunnable()).start();
        new Thread(new AtomicRunnable()).start();

        try {
            AtomicRunnable.getLatch().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(value); // 30000
    }
}
