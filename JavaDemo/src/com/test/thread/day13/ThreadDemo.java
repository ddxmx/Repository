package com.test.thread.day13;

/**
 * 多线程创建四种方式：继承Thread类、实现Runnable接口、实现Callable接口、使用线程池
 * 多线程的创建方式一：
 * 继承Thread类，覆写类中的run方法
 */
class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程" + this.name + "运行，i = " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 进程是程序的一次执行
 * 线程是在进程基础上的进一步划分
 * 并发：CPU交替切换执行
 * 并行：多个CPU同时执行
 * 一个Java应用程序java.exe，其实至少有三个线程： main()主线程， gc()垃圾回收线程，异常处理线程。
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 启动线程的方式
        // 1、创建线程类对象
        MyThread mt = new MyThread("线程A");
        MyThread mt2 = new MyThread("线程B");

        /*
            线程线程A运行，i = 0
            线程线程B运行，i = 0
            线程线程A运行，i = 1
            线程线程B运行，i = 1
            线程线程A运行，i = 2
            线程线程A运行，i = 3
         */
        // 2、调用线程类的start()方法启动线程
        // run()方法不能启动线程，多线程依赖操作系统的支持
        mt.start();
        mt2.start();

        // 启动的线程不能再次启动，java.lang.IllegalThreadStateException
        // mt.start();
    }
}
