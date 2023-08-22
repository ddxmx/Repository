package com.test.thread.day11.sync;

class MyRunnable implements Runnable {
    // 多个线程同时卖5张票
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
            // 票卖完结束线程
            if (ticket <= 0) {
                break;
            }

            // 判断余票数量和卖票之间存在时间间隔，可能导致票在此期间已经被售卖
            try {
                Thread.sleep(500);
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
