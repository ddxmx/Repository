package com.test.thread.day14;

class ProductFactory {
    private static ProductFactory instance = new ProductFactory();

    public static ProductFactory getInstance() {
        return instance;
    }

    // 用于防止虚假唤醒，导致2个线程都进入wait状态
    private boolean flag;

    /**
     * wait和notify的调用对象必须是监视器对象
     */
    public synchronized void get() {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // try {
        //     TimeUnit.MILLISECONDS.sleep(800);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        System.out.println("**********消费中**********");
        flag = false;

        this.notify();
    }

    public synchronized void set() {
        // try {
        //     TimeUnit.MILLISECONDS.sleep(500);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        System.out.println("==========生产中==========");
        flag = true;
        
        this.notify();

        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者线程
 */
class Producer implements Runnable {
    @Override
    public void run() {
        while (true) {
            ProductFactory.getInstance().set();
        }
    }
}

/**
 * 消费者线程
 */
class Consumer implements Runnable {
    @Override
    public void run() {
        while (true) {
            ProductFactory.getInstance().get();
        }
    }
}

/**
 * 生产者消费者问题
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) throws Exception {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        new Thread(consumer).start();
        Thread.sleep(1000);
        new Thread(producer).start();
    }
}
