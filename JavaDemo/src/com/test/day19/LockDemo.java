package com.test.day19;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketLock implements Runnable {
    private int ticket = 5;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    lock.unlock();
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            } else {
                break;
            }
            lock.unlock();
        }
    }
}

/**
 * Lock锁
 * lock锁要手动释放
 */
public class LockDemo {
    public static void main(String[] args) {
        TicketLock ticketLock = new TicketLock();
        new Thread(ticketLock).start();
        new Thread(ticketLock).start();
        new Thread(ticketLock).start();
    }
}
