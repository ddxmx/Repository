package com.test.juc01;

import java.util.concurrent.TimeUnit;

/**
 * 八锁问题之一
 */
public class LockProblemDemo01 {
    static class Phone {
        public synchronized void call() {
            System.out.println("打电话");
        }

        public synchronized void sendSMS() {
            System.out.println("发短信");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        /*
        打电话
        发短信
         */
        Phone phone = new Phone();
        // 先获取对象锁
        new Thread(() -> phone.call()).start();
        TimeUnit.SECONDS.sleep(1);
        //等待锁释放后再次获取到才能执行
        new Thread(() -> phone.sendSMS()).start();
    }
}
