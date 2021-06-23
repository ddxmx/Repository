package com.test.day19;

import java.util.concurrent.TimeUnit;

class RunnableTicket implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
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

/**
 * 线程不安全
 */
public class AsyncDemo {
    public static void main(String[] args) {
        RunnableTicket ticket = new RunnableTicket();
        /*
            Thread-0卖票，余票：2
            Thread-2卖票，余票：3
            Thread-1卖票，余票：4
            Thread-0卖票，余票：1
            Thread-1卖票，余票：-1
            Thread-2卖票，余票：0
         */
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
