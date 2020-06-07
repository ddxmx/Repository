package com.test.juc01;

import java.util.concurrent.TimeUnit;

/**
 * Synchronized实现同步
 */
class Ticket {
    private int number = 10;

    public synchronized void sale() {
        if (number > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "买票，剩余" + number + "张");
        }
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        final int times = 10;
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    ticket.sale();
                }
            }, String.valueOf("线程" + i)).start();
        }
    }
}
