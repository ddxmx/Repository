package com.test.thread.day12.atomic.basic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDemo {
    private static boolean initStatus = false;
    // atomicBoolean的任何操作不会影响initStatus
    private static AtomicBoolean atomicInitStatus = new AtomicBoolean(initStatus);

    /**
     * 初始化方法，只允许执行一次
     */
    public static void init() {
        if (atomicInitStatus.compareAndSet(initStatus, true)) {
            System.out.println(Thread.currentThread().getName() + " ---- start init, need 1 second");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ---- end init....");
        } else {
            System.out.println("已经有其他线程在进行初始化操作....");
        }
    }

    public static void main(String[] args) {
        Runnable atomicBooleanRunnable = new Runnable() {
            @Override
            public void run() {
                AtomicBooleanDemo.init();
            }
        };

        // 多个线程同时进行初始化
        for (int i = 0; i < 10; i++) {
            new Thread(atomicBooleanRunnable).start();
        }
    }
}
