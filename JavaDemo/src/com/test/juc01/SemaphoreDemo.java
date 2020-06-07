package com.test.juc01;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 汽车0进入车位
 * 汽车1进入车位
 * 汽车1离开车位
 * 汽车2进入车位
 * 汽车0离开车位
 * 汽车3进入车位
 * 汽车2离开车位
 * 汽车4进入车位
 * 汽车3离开车位
 * 汽车4离开车位
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "进入车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(2) + 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "离开车位...");
                    semaphore.release();
                }
            }, "汽车" + i).start();
        }
    }
}
