package com.test.thread.day13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生存者消费者问题，使用Lock和Condition类的方法
 * Condition是在java1.5才出现。它用来替换传统的 wait(), notify()实现线程之间的协作。但是更加强大。
 * Condition用 await(), signal, signalAll方法替代wait(), notify()。
 * 假如用wait，notify，有三个线程调用一个对象的某个方法，notify只能随机的唤醒一个线程，而不能指定唤醒某个线程，但是用condition的话，就可以唤醒指定的线程。
 * condition的await，signal和 wait，notify都需要在锁之间运行。
 * condition也被用来实现阻塞队列。
 */
public class ProducerConsumerDemo02 {
    private static class Info {
        private int number;
        private Lock lock = new ReentrantLock();
        // 通过lock对象实例化
        private Condition condition = lock.newCondition();

        public void set() {
            lock.lock();

            try {
                while (number != 0) {
                    condition.await();
                }

                TimeUnit.MILLISECONDS.sleep(100);
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

                TimeUnit.MILLISECONDS.sleep(70);
                System.out.println(Thread.currentThread().getName() + "运行，number=" + --number);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Info info = new Info();

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
