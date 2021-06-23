package com.test.day19;

import java.util.concurrent.TimeUnit;

/**
 * 继承Thread类，使用同步方法
 */
class TicketRunnable3 extends Thread {
    private static int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (!sale()) {
                break;
            }
        }
    }

    /**
     * static修饰的同步方法，当前的监视器就是TicketRunnable3.class
     * 继承Thread类必须使用static的同步方法，因为线程启动时使用不同的Thread对象，监视器只能是类监视器，不能是this
     */
    public static synchronized boolean sale() {
        if (ticket > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            return true;
        }

        return false;
    }
}

public class SyncMethodDemo2 {
    public static void main(String[] args) {
        /*
            Thread-0卖票，余票：4
            Thread-2卖票，余票：3
            Thread-2卖票，余票：2
            Thread-1卖票，余票：1
            Thread-1卖票，余票：0
         */
        new TicketRunnable3().start();
        new TicketRunnable3().start();
        new TicketRunnable3().start();
    }
}
