package com.test.thread.day19;

class SignalRunnable implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();

                if (number <= 10) {
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "，运行：" + number++);
                } else {
                    break;
                }

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 线程通讯的方式：
 * wait：执行此方法，当前线程进入到阻塞状态，释放锁
 * notify：执行此方法，唤醒被wait的一个线程。
 * notifyAll：执行此方法，唤醒被wait的所有线程。
 * |- 这三个方法必须使用在同步代码块或同步方法中
 * |- 这三个方法的调用者必须是监视器对象
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        /*
            Thread-0，运行：1
            Thread-1，运行：2
            Thread-0，运行：3
            Thread-1，运行：4
            Thread-0，运行：5
            Thread-1，运行：6
            Thread-0，运行：7
            Thread-1，运行：8
            Thread-0，运行：9
            Thread-1，运行：10
         */
        SignalRunnable runnable = new SignalRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
