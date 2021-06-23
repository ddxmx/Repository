package com.test.day18;

class ThreadPriority extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "运行，优先级："
                    + Thread.currentThread().getPriority() + "，i = " + i);
        }
    }
}

/**
 * 线程的优先级
 * Thread-1运行，优先级：5，i = 0
 * Thread-0运行，优先级：10，i = 0
 * Thread-2运行，优先级：1，i = 0
 * Thread-0运行，优先级：10，i = 1
 * Thread-1运行，优先级：5，i = 1
 * Thread-0运行，优先级：10，i = 2
 * Thread-2运行，优先级：1，i = 1
 * Thread-0运行，优先级：10，i = 3
 * Thread-1运行，优先级：5，i = 2
 * Thread-0运行，优先级：10，i = 4
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        ThreadPriority mt = new ThreadPriority();
        //高优先级的线程不一定比低优先级的线程限制性
        mt.setPriority(Thread.MAX_PRIORITY);

        ThreadPriority mt2 = new ThreadPriority();
        mt2.setPriority(Thread.NORM_PRIORITY);

        ThreadPriority mt3 = new ThreadPriority();
        mt3.setPriority(Thread.MIN_PRIORITY);

        mt.start();
        mt2.start();
        mt3.start();
    }
}
