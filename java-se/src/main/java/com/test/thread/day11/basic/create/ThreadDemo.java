package com.test.thread.day11.basic.create;

/**
 * 多线程创建的四种方式：继承Thread类、实现Runnable接口、实现Callable接口、使用线程池
 * 多线程的创建方式一：继承Thread类，覆写类中的run方法
 */
class MyThread extends Thread {
    public MyThread(String name) {
        // 设置线程的名称
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
        }
    }
}

/**
 * 1、进程是程序的一次执行，线程是在进程基础上的进一步划分
 * 进程是操作系统进行资源分配的基本单位，而线程是操作系统进行调度的基本单位
 * 2、上下文切换是指CPU从一个进程（或线程）切换到另一个进程（或线程）。上下文是指某一时间点CPU寄存器和程序计数器的内容
 * CPU通过为每个线程分配CPU时间片来实现多线程机制。CPU通过时间片分配算法来循环执行任务，当前任务执行一个时间片后会切换到下一个任务
 * 上下文切换通常是计算密集型的，意味着此操作会消耗大量的CPU时间，故线程也不是越多越好
 * 3、并发：CPU交替切换执行，并行：多个CPU同时执行
 * 4、一个java应用程序java.exe，至少有两个线程： main()主线程， gc()垃圾回收线程
 * 5、启动多线程的两个步骤
 * （1）创建线程类对象
 * （2）调用线程类的start()方法，启动线程
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 1、创建线程类对象
        MyThread mt = new MyThread("线程A");
        MyThread mt2 = new MyThread("线程B");

        /*
            线程A运行，i = 0
            线程B运行，i = 0
            线程A运行，i = 1
            线程B运行，i = 1
            线程A运行，i = 2
            线程B运行，i = 2
            线程A运行，i = 3
            线程A运行，i = 4
            线程B运行，i = 3
            线程B运行，i = 4
         */
        // 2、调用线程类的start()方法启动线程
        // run()方法不能启动线程，多线程依赖操作系统的支持
        mt.start();
        mt2.start();

        // 3、启动的线程不能再次启动，java.lang.IllegalThreadStateException
        // mt.start();
    }
}
