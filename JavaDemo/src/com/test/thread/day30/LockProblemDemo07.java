package com.test.thread.day30;

import java.util.concurrent.TimeUnit;

/**
 * 八锁问题之七
 */
public class LockProblemDemo07 {
    static class Phone {
        /*
            static synchronized锁的是class
         */
        public static synchronized void call() {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("打电话");
        }

        /*
            synchronized锁的是对象
         */
        public synchronized void sendSMS() {
            System.out.println("发短信");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*
            发短信
            打电话
         */
        Phone phone = new Phone();
        //获得class的锁
        new Thread(() -> phone.call()).start();
        TimeUnit.SECONDS.sleep(1);
        // 获取对象锁
        new Thread(() -> phone.sendSMS()).start(); //2个不同的锁，不会相互影响
    }
}
