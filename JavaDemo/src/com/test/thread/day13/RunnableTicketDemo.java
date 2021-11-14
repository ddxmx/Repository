package com.test.thread.day13;

class RunnableTicket implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            } else {
                break;
            }
        }
    }
}

/**
 * 多线程使用方式推荐实现Runnable接口，避免类单继承的局限性
 */
public class RunnableTicketDemo {
    public static void main(String[] args) {
        RunnableTicket runnable = new RunnableTicket();

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
