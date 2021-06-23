package com.test.day18;

/**
 * 线程的常用方法
 */
public class ThreadMethodDemo {
    public static void main(String[] args) {
        Thread mt = new Thread(() -> {
            //获取1~100的质数
            outer:
            for (int i = 2; i <= 100; i++) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        continue outer;
                    }
                }
                //Thread.currentThread()获取当前线程对象
                System.out.println(Thread.currentThread().getName() + "运行，i=" + i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //设置线程名称
        mt.setName("线程A");
        mt.start();

        //判断线程是否存活
        System.out.println(mt.isAlive());

        for (int i = 0; i < 20; i++) {
            //主线程执行到i=10时，强制其他线程执行
            if (i == 10) {
                try {
                    //调用线程对象的join()方法，让线程优先执行，其他线程等待该线程执行结束
                    mt.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "：i = " + i);

            if (i >= 3) {
                //线程礼让，礼让后哪个线程先执行，看CPU的调度
                Thread.yield();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
