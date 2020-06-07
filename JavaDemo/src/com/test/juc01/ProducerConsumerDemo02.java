package com.test.juc01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生存者消费者问题，使用Lock和Condition类的方法
 */
class Info02 {
    private int number;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void set() {
        lock.lock();

        try {
            while (number != 0) { //避免虚假唤醒
                condition.await();
            }

            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println(Thread.currentThread().getName() + "运行，number=" + ++number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();

        try {
            while (number == 0) {
                condition.await();
            }

            TimeUnit.MILLISECONDS.sleep(160);
            System.out.println(Thread.currentThread().getName() + "运行，number=" + --number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProducerConsumerDemo02 {
    public static void main(String[] args) {
        Info02 info = new Info02();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                info.set();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                info.get();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                info.get();
            }
        }, "C").start();
    }
}
