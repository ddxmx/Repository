package com.test.juc01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock实现同步
 */
class Ticket02 {
    private int number = 10;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + "买票，剩余" + number + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LockDemo {
    public static void main(String[] args) {
        int times = 30;
        Ticket02 ticket = new Ticket02();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    ticket.sale();
                }
            }, String.valueOf("线程" + i)).start();
        }
    }
}
