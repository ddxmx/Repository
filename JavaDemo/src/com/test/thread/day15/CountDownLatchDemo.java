package com.test.thread.day15;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。
 * 使用一个计数器进行实现。计数器初始值为线程的数量。当每一个线程完成自己任务后，计数器的值就会减一。
 * 当计数器的值为0时，表示所有的线程都已经完成一些任务，然后在CountDownLatch上等待的线程就可以恢复执行接下来的任务。
 * CountDownLatch是一次性的，计算器的值只能在构造方法中初始化一次，之后没有任何机制再次对其设置值，当CountDownLatch使用完毕后，它不能再次被使用。
 * <p>
 * 6星龙珠已获得~
 * 7星龙珠已获得~
 * 3星龙珠已获得~
 * 4星龙珠已获得~
 * 2星龙珠已获得~
 * 1星龙珠已获得~
 * 5星龙珠已获得~
 * 所有线程完成耗时：2166
 * 召唤神龙
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int dragonBallSize = 7;
        CountDownLatch latch = new CountDownLatch(dragonBallSize);
        for (int i = 1; i <= dragonBallSize; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "已获得~");
                latch.countDown();
            }, i + "星龙珠").start();
        }
        // 等待其他线程结束
        latch.await();
        long endTime = System.currentTimeMillis();
        System.out.println("所有线程完成耗时：" + (endTime - startTime));
        // 其他线程结束后才可以继续执行
        System.out.println("召唤神龙");
    }
}
