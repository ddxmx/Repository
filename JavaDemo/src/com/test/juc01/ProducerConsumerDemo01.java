package com.test.juc01;

import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者问题，使用synchronized和Object类的方法
 * 可以定义多个消费者进行消费
 */
class Info {
    private int number = 0;

    public synchronized void set() throws InterruptedException {
        while (number != 0) { //防止虚假唤醒
            super.wait();
        }

        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println(Thread.currentThread().getName() + "线程运行，number=" + ++number);
        super.notifyAll();
    }

    public synchronized void get() throws InterruptedException {
        while (number == 0) { //放着虚假唤醒
            super.wait();
        }

        TimeUnit.MILLISECONDS.sleep(160);
        System.out.println(Thread.currentThread().getName() + "线程运行，number=" + --number);
        super.notifyAll();
    }
}

public class ProducerConsumerDemo01 {
    public static void main(String[] args) {
        Info info = new Info();
        //生产者
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    info.set();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        //消费者1
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    info.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        //消费者2
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    info.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}
