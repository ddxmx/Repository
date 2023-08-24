package com.test.thread.day11.signal;

/**
 * 生产者消费者问题，使用synchronized和Object类的方法
 * 1、线程通讯的方式：
 * （1）wait：执行此方法，当前线程进入到阻塞状态，释放锁
 * （2）notify：执行此方法，唤醒被wait的一个线程。
 * （3）notifyAll：执行此方法，唤醒被wait的所有线程。
 * 2、这三个方法必须使用在同步代码块或同步方法中
 * 3、这三个方法的调用者必须是监视器对象
 */
class Container {
    private int number = 0;

    public synchronized void set() throws InterruptedException {
        // 使用while，不使用if，防止虚假唤醒
        while (number != 0) {
            super.wait();
        }

        // 生产产品
        System.out.println(Thread.currentThread().getName() + "运行，number=" + ++number);

        // 通知线程消费
        super.notifyAll();
    }

    public synchronized void get() throws InterruptedException {
        // 使用while，不使用if，防止虚假唤醒
        while (number == 0) {
            super.wait();
        }

        // 消费产品
        System.out.println(Thread.currentThread().getName() + "运行，number=" + --number);

        // 通知线程生产
        super.notifyAll();
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) {
        Container container = new Container();

        /*
            线程A运行，number=1
            线程C运行，number=0
            线程A运行，number=1
            线程B运行，number=0
            线程A运行，number=1
            线程C运行，number=0
            ...
         */
        // 生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        container.set();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程A").start();

        // 消费者1
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    container.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程B").start();

        // 消费者2
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    container.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程C").start();
    }
}
