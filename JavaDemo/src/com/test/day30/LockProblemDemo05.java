package com.test.day30;

import java.util.concurrent.TimeUnit;

/**
 * 八锁问题之五
 */
public class LockProblemDemo05 {
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

        public static synchronized void sendSMS() {
            System.out.println("发短信");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*
            打电话
            发短信
         */
        Phone phone = new Phone();
        //先获得class的锁
        new Thread(() -> phone.call()).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> phone.sendSMS()).start();
    }
}
