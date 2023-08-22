package com.test.thread.day11.basic.create;

/**
 * 实现多线程的方法二：实现Runnable接口，覆写接口中的run()方法
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        // 创建线程类对象，多线程的启动依赖Thread类
        Thread mt = new Thread(runnable, "线程A");
        Thread mt2 = new Thread(runnable, "线程B");

        /*
            线程B运行，i = 0
            线程A运行，i = 0
            线程A运行，i = 1
            线程A运行，i = 2
            线程A运行，i = 3
            线程A运行，i = 4
            线程B运行，i = 1
            线程B运行，i = 2
            线程B运行，i = 3
            线程B运行，i = 4
         */
        // 启动线程
        mt.start();
        mt2.start();
    }
}
