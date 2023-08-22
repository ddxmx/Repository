package com.test.thread.day11.sync;

/**
 * 同步方法
 */
class SyncMethodRunnable implements Runnable {
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
        // 票卖完结束线程
        if (ticket <= 0) {
            return false;
        }

        // 判断余票数量和卖票之间存在时间间隔，可能导致票在此期间已经被售卖
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
        return true;
    }
}

/**
 * 静态同步方法
 * 对静态变量进行同步，需要使用静态同步块
 */
class SyncStaticMethodRunnable implements Runnable {
    private static int value = 1;

    @Override
    public void run() {
        calculate();
    }

    /**
     * static修饰的同步方法，当前的监视器就是SyncStaticMethodRunnable.class
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
}

public class SyncMethodDemo {
    public static void main(String[] args) {
        SyncMethodRunnable runnable = new SyncMethodRunnable();

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
        SyncStaticMethodRunnable staticMethodRunnable = new SyncStaticMethodRunnable();
        new Thread(staticMethodRunnable).start();
        new Thread(staticMethodRunnable).start();
        new Thread(staticMethodRunnable).start();
    }
}
