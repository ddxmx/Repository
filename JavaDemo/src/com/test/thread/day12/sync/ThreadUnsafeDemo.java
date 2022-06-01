package com.test.thread.day12.sync;

import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) {
                break;
            }

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
        }
    }
}

/**
 * 线程不安全的问题
 * 一个对象被多个线程同时操作时，造成操作结果异常
 */
public class ThreadUnsafeDemo {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        /*
            Thread-1卖票，余票：4
            Thread-0卖票，余票：3
            Thread-2卖票，余票：2
            Thread-0卖票，余票：-1
            Thread-1卖票，余票：1
            Thread-2卖票，余票：0
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
