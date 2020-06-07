package com.test.juc01;

import java.util.concurrent.TimeUnit;

/**
 * 八锁问题之六
 */
public class LockProblemDemo06 {
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
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        //先获得class的锁
        new Thread(() -> phone1.call()).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> phone2.sendSMS()).start();
    }
}
