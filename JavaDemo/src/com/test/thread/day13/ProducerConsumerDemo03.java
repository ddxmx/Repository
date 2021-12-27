package com.test.thread.day13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者问题，使用Condition实现精准控制
 * A -> B -> C -> A -> B -> C
 */
class Info03 {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void fun1() {
        lock.lock();

        try {
            while (number != 1) {
                condition1.await();
            }

            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(Thread.currentThread().getName() + "运行，number=" + number);
            number = 2;
            condition2.signal(); // 精准唤醒2
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void fun2() {
        lock.lock();

        try {
            while (number != 2) {
                condition2.await();
            }

            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(Thread.currentThread().getName() + "运行，number=" + number);
            number = 3;
            condition3.signal(); // 精准唤醒3
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void fun3() {
        lock.lock();

        try {
            while (number != 3) {
                condition3.await();
            }

            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(Thread.currentThread().getName() + "运行，number=" + number);
            number = 1;
            condition1.signal(); // 精准唤醒1
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProducerConsumerDemo03 {
    public static void main(String[] args) {
        Info03 info = new Info03();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                info.fun1();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                info.fun2();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                info.fun3();
            }
        }, "C").start();
    }
}
