package com.test.day19;

import java.util.concurrent.TimeUnit;

/**
 * synchronized
 * 通过同步机制解决线程不安全的方式
 * 但是也造成性能的下降
 * 1、可重入的：同一个执行线程获取锁后，调用其他相同锁的代码，可以直接调用
 * 2、直接读写共享内存
 * 3、过多的同步容易引起死锁，应该尽量避免持有一个锁的同时去申请另一个锁
 * <p>
 * 方式一：使用同步代码块
 * synchronized(同步监视器){
 * //需要被同步的代码
 * }
 * 方式二：同步方法
 */
class TicketRunnable implements Runnable {
    private int ticket = 5;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //同步监视器，就是锁，任何一个类的对象都可以作为同步监视器，多个线程要共用一个才能同步
            /*synchronized (obj)*/
            /*synchronized (this) */
            synchronized (TicketRunnable.class) {
                if (ticket > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
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

public class SyncBlockDemo {
    public static void main(String[] args) {
        TicketRunnable ticket = new TicketRunnable();
        /*
            Thread-0卖票，余票：4
            Thread-2卖票，余票：3
            Thread-2卖票，余票：2
            Thread-1卖票，余票：1
            Thread-1卖票，余票：0
         */
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
