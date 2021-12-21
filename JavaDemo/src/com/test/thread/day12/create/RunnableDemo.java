package com.test.thread.day12.create;

/**
 * 实现多线程的方法二：
 * 实现Runnable接口，覆写接口中的run()方法
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程" + Thread.currentThread().getName() + "运行，i = " + i);
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        /*
            线程Thread-1运行，i = 0
            线程Thread-1运行，i = 1
            线程Thread-0运行，i = 0
            线程Thread-1运行，i = 2
            线程Thread-0运行，i = 1
            线程Thread-1运行，i = 3
         */
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
