package com.test.thread.day12.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁
 * 使用lock锁实现同步
 * lock锁要手动释放
 */
class SyncLock implements Runnable {
    private int ticket = 5;

    // 实例化lock对象，使用实现类ReentrantLock实例化
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                if (ticket <= 0) {
                    break;
                }
                Thread.sleep(50);
                System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

public class SyncLockDemo {
    public static void main(String[] args) {
        SyncLock runnable = new SyncLock();

        /*
            Thread-0卖票，余票：4
            Thread-0卖票，余票：3
            Thread-0卖票，余票：2
            Thread-1卖票，余票：1
            Thread-1卖票，余票：0
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
