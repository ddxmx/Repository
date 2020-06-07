package com.test.juc01;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 等待龙珠收集
 * 龙珠3已获取
 * 龙珠0已获取
 * 龙珠3收入包中~
 * 龙珠0收入包中~
 * 龙珠1已获取
 * 龙珠1收入包中~
 * 龙珠4已获取
 * 龙珠4收入包中~
 * 龙珠2已获取
 * 龙珠2收入包中~
 * 召唤神龙
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "已获取");
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + "收入包中~");
            }, "龙珠" + i).start();
        }
        System.out.println("等待龙珠收集");
        latch.await();
        System.out.println("召唤神龙");
    }
}
