package com.test.thread.day13;

/**
 * 线程的常用方法
 */
public class ThreadMethodDemo {
    public static void main(String[] args) {
        /*
            true
            RUNNABLE
            main线程优先级：5
            main：i = 0
            main：i = 1
            main：i = 2
            线程A优先级：10，i = 0
            线程C优先级：1，i = 0
            线程B优先级：5，i = 0
            线程A优先级：10，i = 1
            线程B优先级：5，i = 1
            线程C优先级：1，i = 1
            线程A优先级：10，i = 2
            线程B优先级：5，i = 2
            线程C优先级：1，i = 2
            线程B优先级：5，i = 3
            线程A优先级：10，i = 3
            线程C优先级：1，i = 3
            线程B优先级：5，i = 4
            线程C优先级：1，i = 4
            线程A优先级：10，i = 4
            main：i = 3
            main：i = 4
            main：i = 5
            main：i = 6
            main：i = 7
            main：i = 8
            main：i = 9
         */
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                // Thread.yield() 使当前线程由执行状态，变成为就绪状态，让CPU重新调度
                Thread.yield();

                try {
                    // Thread.sleep() 线程休眠
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Thread.currentThread() 获取当前线程对象
                Thread currentThread = Thread.currentThread();
                // thread.getName() 获取线程名称
                // thread.getPriority() 获取线程优先级
                System.out.println(currentThread.getName() + "优先级：" + currentThread.getPriority()
                        + "，i = " + i);
            }
        };

        Thread mt = new Thread(runnable);
        Thread mt2 = new Thread(runnable);
        Thread mt3 = new Thread(runnable);

        // thread.setPriority() 设置线程优先级
        // 高优先级的线程不一定比低优先级的线程先执行
        mt.setPriority(Thread.MAX_PRIORITY); // 高优先级，10
        mt2.setPriority(Thread.NORM_PRIORITY); // 中等优先级，5
        mt3.setPriority(Thread.MIN_PRIORITY); // 低优先级，1

        // thread.setName() 设置线程名称
        mt.setName("线程A");
        mt2.setName("线程B");
        mt3.setName("线程C");

        mt.start();
        mt2.start();
        mt3.start();

        // thread.isAlive() 判断线程是否存活
        System.out.println(mt.isAlive()); // true

        // thread.getState() 获取线程状态
        System.out.println(mt.getState()); // RUNNABLE

        // main线程优先级：5
        System.out.println(Thread.currentThread().getName() + "线程优先级：" + Thread.currentThread().getPriority());

        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                try {
                    // thread.join() 当前线程等待指定线程先执行结束后再执行，只有当前线程会阻塞，不会导致其他线程阻塞
                    mt.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "：i = " + i);
        }
    }
}
