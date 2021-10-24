package com.test.thread.day19;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SyncLockRunnable implements Runnable {
    private int ticket = 5;

    // 实例化lock对象，使用实现类ReentrantLock实例化
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    lock.unlock();
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            } else {
                lock.unlock();
                break;
            }
            lock.unlock();
        }
    }
}

/**
 * 使用Lock锁实现同步
 * lock锁要手动释放
 */
public class SyncLockDemo {
    public static void main(String[] args) {
        SyncLockRunnable runnable = new SyncLockRunnable();

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
