package com.test.thread.day11.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁
 * 使用lock锁实现同步
 * lock锁要手动释放
 */
class SyncLockRunnable implements Runnable {
    private int ticket = 5;

    // 实例化lock对象，使用实现类ReentrantLock实例化
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();

            try {
                // 票卖完结束线程
                if (ticket <= 0) {
                    break;
                }

                // 判断余票数量和卖票之间存在时间间隔，可能导致票在此期间已经被售卖
                Thread.sleep(500);

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
