package com.test.day19;

import java.util.concurrent.TimeUnit;

/**
 * 方式二：同步方法
 * 方法声明中使用synchronized关键字
 * 继承Runnable接口使用同步方法
 */
class TicketRunnable2 implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (!sale()) {
                break;
            }
        }
    }

    /**
     * 同步方法，同步监视器就是this
     */
    public synchronized boolean sale() {
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

public class SyncMethodDemo {
    public static void main(String[] args) {
        TicketRunnable2 ticket = new TicketRunnable2();
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
