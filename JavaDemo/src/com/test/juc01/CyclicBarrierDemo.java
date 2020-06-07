package com.test.juc01;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 线程2运行
 * 线程1运行
 * 线程5运行
 * 线程6运行
 * 线程3运行
 * 线程0运行
 * 线程4运行
 * 召唤神龙
 * 线程2继续运行...
 * 线程1继续运行...
 * 线程6继续运行...
 * 线程3继续运行...
 * 线程5继续运行...
 * 线程0继续运行...
 * 线程4继续运行...
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("聚齐七颗龙珠，召唤神龙"));
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "已收集");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "消失...");
            }, i + "星龙珠").start();
        }
    }
}
