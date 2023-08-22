package com.test.thread.day11.sync;

/**
 * 同步代码块
 */
class SyncBlockRunnable implements Runnable {
    private int ticket = 5;
    private Object obj = new Object();

    @Override
    public void run() {
        // 在while外使用同步代码块，将导致只有一个线程可以卖票
        while (true) {
            // 同步监视器，就是锁，任何一个类的对象都可以作为同步监视器，多个线程要共用一个同步监视器才能同步
            // synchronized (this)
            // synchronized (SyncBlock.class) 使用class当作监视器导致不同的SyncBlockRunnable实例创建的线程也会同步等待
            synchronized (obj) {
                // 票卖完结束线程
                if (ticket <= 0) {
                    break;
                }

                // 判断余票数量和卖票之间存在时间间隔，可能导致票在此期间已经被售卖
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            }
        }
    }
}

/**
 * 通过同步机制可以解决线程不安全的问题，但是过多的同步操作将导致性能的下降
 * 1、线程同步的方式：
 * （1）使用同步代码块
 * synchronized(同步监视器){
 * 需要被同步的代码
 * }
 * （2）使用同步方法
 * 权限修饰符 synchronized 返回值 方法名(参数列表)
 * synchronized的特点：
 * （A）可重入的：同一个执行线程获取锁后，调用其他相同锁的代码，可以直接调用
 * （B）直接读写共享内存
 * （C）过多的同步容易引起死锁，应该尽量避免持有一个锁的同时去申请另一个锁
 */
public class SyncBlockDemo {
    public static void main(String[] args) {
        SyncBlockRunnable runnable = new SyncBlockRunnable();

        /*
            Thread-1卖票，余票：4
            Thread-1卖票，余票：3
            Thread-0卖票，余票：2
            Thread-0卖票，余票：1
            Thread-2卖票，余票：0
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
