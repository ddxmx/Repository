package com.test.day19;

/**
 * 线程通讯的方法
 * wait：执行此方法，当前线程进入到阻塞状态，释放锁
 * notify：执行此方法，唤醒被wait的一个线程。
 * notifyAll：执行此方法，唤醒被wait的所有线程。
 * 1、这三个方法必须使用在同步代码块或同步方法中
 * 2、这三个方法的调用者必须是监视器对象
 * sleep不会释放锁，wait会释放锁
 */
class Count implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();

                if (number <= 10) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "，运行：" + number++);
                } else {
                    break;
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) {
        Count count = new Count();
        new Thread(count).start();
        new Thread(count).start();
    }
}
