package com.test.thread.day12.sync;

import java.util.concurrent.TimeUnit;

/**
 * 方式二：同步方法
 * 实现Runnable接口，使用同步方法
 * （1）方式一：
 * 方法声明中使用synchronized关键字
 * 同步方法监视器对象就是this
 */
class SyncMethod implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        while (true) {
            if (!sell()) {
                break;
            }
        }
    }

    /**
     * 同步方法，同步监视器就是this
     */
    public synchronized boolean sell() {
        if (ticket <= 0) {
            return false;
        }

        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);

        return true;
    }
}

/**
 * 静态同步方法
 */
class SyncStaticMethod implements Runnable {
    private static int value = 1;

    @Override
    public void run() {
        calculate();
    }

    /**
     * static修饰的同步方法，当前的监视器就是SyncStaticMethod.class
     * 如果需要对static修饰的对象进行同步操作，需要使用static的同步方法
     */
    public static synchronized void calculate() {
        // value = value * 2 + 1
        value *= 2;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value += 1;
        System.out.println(Thread.currentThread().getName() + ",value = " + value);
    }

    public static int getValue() {
        return value;
    }
}

public class SyncMethodDemo {
    public static void main(String[] args) {
        SyncMethod runnable = new SyncMethod();

        /*
            Thread-0卖票，余票：4
            Thread-2卖票，余票：3
            Thread-2卖票，余票：2
            Thread-1卖票，余票：1
            Thread-1卖票，余票：0
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        /*
            Thread-3,value = 3
            Thread-5,value = 7
            Thread-4,value = 15
         */
        new Thread(new SyncStaticMethod()).start();
        new Thread(new SyncStaticMethod()).start();
        new Thread(new SyncStaticMethod()).start();
    }
}
