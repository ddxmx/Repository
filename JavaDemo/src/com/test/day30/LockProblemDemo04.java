package com.test.day30;

import java.util.concurrent.TimeUnit;

/**
 * 八锁问题之四
 * 同步方法使用的是对象锁
 */
public class LockProblemDemo04 {
    static class Phone {
        public synchronized void call() {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("打电话");
        }

        public synchronized void sendSMS() {
            System.out.println("发短信");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*
            发短信
            打电话
         */
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> phone1.call()).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> phone2.sendSMS()).start(); //两个锁，互不影响
    }
}
