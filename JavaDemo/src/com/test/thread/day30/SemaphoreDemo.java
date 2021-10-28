package com.test.thread.day30;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 * Semaphore也是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制。
 * 使用Semaphore可以控制同时访问资源的线程个数，例如，实现一个文件允许的并发访问数。
 * 　　void acquire():从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
 * 　　void release():释放一个许可，将其返回给信号量。
 * 　　int availablePermits():返回此信号量中当前可用的许可数。
 * 　　boolean hasQueuedThreads():查询是否有线程正在等待获取。
 * <p>
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
                    //申请信号量，未申请到的线程阻塞
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "进入车位");
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(3000));
                    System.out.println(Thread.currentThread().getName() + "离开车位...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "汽车" + i).start();
        }
    }
}
