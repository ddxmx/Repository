package com.test.thread.day19;

import java.util.concurrent.TimeUnit;

class MyRunnable implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
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

/**
 * 线程不安全的问题
 */
public class AsyncProblemDemo {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        /*
            Thread-0卖票，余票：2
            Thread-2卖票，余票：3
            Thread-1卖票，余票：4
            Thread-0卖票，余票：1
            Thread-1卖票，余票：-1
            Thread-2卖票，余票：0
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
