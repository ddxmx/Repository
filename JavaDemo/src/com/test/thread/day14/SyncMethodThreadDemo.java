package com.test.thread.day14;

import java.util.concurrent.TimeUnit;

/**
 * 继承Thread类，使用同步方法
 * （2）方式二：
 * 方法声明中使用static synchronized关键字
 * 同步方法监视器对象就是 当前类.class
 */
class SyncMethodThread extends Thread {
    // 在static synchronized声明的方法中使用，变量必须使用static修饰
    private static int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (!sellTickets()) {
                break;
            }
        }
    }

    /**
     * static修饰的同步方法，当前的监视器就是SyncMethodThread.class
     * 继承Thread类必须使用static的同步方法，因为线程启动时使用不同的Thread对象，监视器只能是类监视器，不能是this
     */
    public static synchronized boolean sellTickets() {
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

public class SyncMethodThreadDemo {
    public static void main(String[] args) {
        /*
            Thread-0卖票，余票：4
            Thread-2卖票，余票：3
            Thread-2卖票，余票：2
            Thread-1卖票，余票：1
            Thread-1卖票，余票：0
         */
        new SyncMethodThread().start();
        new SyncMethodThread().start();
        new SyncMethodThread().start();
    }
}
