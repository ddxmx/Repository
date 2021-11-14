package com.test.thread.day14;

import java.util.concurrent.TimeUnit;

/**
 * 方式二：同步方法
 * 实现Runnable接口，使用同步方法
 * （1）方式一：
 * 方法声明中使用synchronized关键字
 * 同步方法监视器对象就是this
 */
class SyncMethodRunnable implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (!sellTickets()) {
                break;
            }
        }
    }

    /**
     * 同步方法，同步监视器就是this
     */
    public synchronized boolean sellTickets() {
        if (ticket > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            return true;
        }

        return false;
    }
}

public class SyncMethodRunnableDemo {
    public static void main(String[] args) {
        SyncMethodRunnable runnable = new SyncMethodRunnable();

        /*
            Thread-0卖票，余票：4
            Thread-2卖票，余票：3
            Thread-2卖票，余票：2
            Thread-1卖票，余票：1
            Thread-1卖票，余票：0
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
