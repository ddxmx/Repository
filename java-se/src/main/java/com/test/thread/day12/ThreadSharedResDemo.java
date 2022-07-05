package com.test.thread.day12;

/**
 * 多线程使用方式不推荐使用Thread类，具有单继承局限性
 * 使用Runnable接口，可以共享资源
 */
class TicketRunnable implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
        }
    }
}

public class ThreadSharedResDemo {
    public static void main(String[] args) {
        // TicketRunnable中ticket被多个线程共享
        TicketRunnable runnable = new TicketRunnable();

        /*
            Thread-0卖票，余票：4
            Thread-1卖票，余票：3
            Thread-0卖票，余票：2
            Thread-2卖票，余票：1
            Thread-1卖票，余票：0
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
