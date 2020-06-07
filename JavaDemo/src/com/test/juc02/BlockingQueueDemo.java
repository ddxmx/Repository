package com.test.juc02;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 使用阻塞队列实现的生产者消费者模型
 * 将数据放入到阻塞队列中，使用阻塞方法获取(take)和设置(put)
 */
class Info {
    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

    public void get() {
        try {
            String value = queue.take();
            System.out.println(Thread.currentThread().getName() + "消费一个数据：" + value);
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void set() {
        try {
            String value = UUID.randomUUID().toString();
            queue.put(value);
            System.out.println(Thread.currentThread().getName() + "生产一个数据：" + value);
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class BlockingQueueDemo {
    public static void main(String[] args) {
        Info info = new Info();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                info.set();
            }
        }, "线程A").start();

        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                info.get();
            }
        }, "线程B").start();

        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                info.get();
            }
        }, "线程C").start();
    }
}
