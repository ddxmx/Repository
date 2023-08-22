package com.test.thread.day11.basic;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Thread.yield() 线程礼让，使当前线程由执行状态，变成为就绪状态，让CPU重新调度
            Thread.yield();

            try {
                // Thread.sleep() 线程休眠，不释放锁
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Thread.currentThread() 获取当前线程对象
            Thread currentThread = Thread.currentThread();

            // thread.getName() 获取线程名称
            // thread.getPriority() 获取线程优先级
            System.out.println(currentThread.getName() + "，i = " + i
                    + "，优先级：" + currentThread.getPriority());
        }
    }
}

/**
 * 线程的常用方法
 */
public class ThreadMethodDemo {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();

        Thread mt = new Thread(runnable);
        Thread mt2 = new Thread(runnable);
        Thread mt3 = new Thread(runnable);

        // thread.setPriority() 设置线程优先级，高优先级的线程不一定比低优先级的线程先执行
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

        // main线程优先级：5
        System.out.println(Thread.currentThread().getName() + "线程优先级：" + Thread.currentThread().getPriority());

        // thread.isAlive() 判断线程是否存活
        System.out.println(mt.isAlive()); // true

        /*
         线程的生命周期，Thread.State类：新建、运行、阻塞、等待、计时等待、消亡
         一般线程经历如下五种状态：
         （1）新建：创建了线程类对象，但尚未调用start()方法
         （2）就绪：调用了start()方法，等待CPU的调度
         （3）运行：获得CPU执行权（CPU时间片结束或调用yield()方法，回到就绪状态）
         （4）阻塞：sleep、join、wait、等待同步锁（sleep时间结束、join优先执行的线程结束、notify、获取同步锁时，结束阻塞状态，回到就绪状态）
         （5）消亡：线程执行结束或被终止
         */
        // thread.getState() 获取线程状态
        System.out.println(mt.getState()); // RUNNABLE

        /*
            main：i = 0
            main：i = 1
            main：i = 2
            线程A，i = 0，优先级：10
            线程B，i = 0，优先级：5
            线程C，i = 0，优先级：1
            ...
            线程A，i = 4，优先级：10
            线程C，i = 4，优先级：1
            线程B，i = 4，优先级：5
            main：i = 3
            main：i = 4
         */
        for (int i = 0; i < 5; i++) {
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
