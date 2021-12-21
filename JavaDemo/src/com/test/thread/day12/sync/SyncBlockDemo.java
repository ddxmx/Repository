package com.test.thread.day12.sync;

import java.util.concurrent.TimeUnit;

/**
 * 同步代码块
 */
class SyncBlock implements Runnable {
    private int ticket = 5;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步监视器，就是锁，任何一个类的对象都可以作为同步监视器，多个线程要共用一个锁才能同步
            // synchronized (this) {
            // synchronized (SyncBlockRunnable.class) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
                } else {
                    break;
                }
            }
        }
    }
}

/**
 * 通过同步机制可以解决线程不安全的问题，但是过多的同步操作将导致性能的下降
 * 线程同步的方式：
 * 方式一：使用同步代码块
 * synchronized(同步监视器){
 * 需要被同步的代码
 * }
 * 方式二：使用同步方法
 * 权限修饰符 synchronized 返回值 方法名(参数列表)
 * <p>
 * synchronized的特点：
 * 1、可重入的：同一个执行线程获取锁后，调用其他相同锁的代码，可以直接调用
 * 2、直接读写共享内存
 * 3、过多的同步容易引起死锁，应该尽量避免持有一个锁的同时去申请另一个锁
 */
public class SyncBlockDemo {
    public static void main(String[] args) {
        SyncBlock runnable = new SyncBlock();

        /*
            Thread-1卖票，余票：4
            Thread-1卖票，余票：3
            Thread-0卖票，余票：2
            Thread-0卖票，余票：1
            Thread-2卖票，余票：0
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
