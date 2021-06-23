package com.test.day30;

import java.util.concurrent.TimeUnit;

/**
 * 八锁问题之二
 * 同步方法使用的是对象锁
 */
public class LockProblemDemo02 {
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
            打电话
            发短信
         */
        Phone phone = new Phone();
        // 先获取对象锁
        new Thread(() -> phone.call()).start();
        TimeUnit.SECONDS.sleep(1);
        //1秒后，但是锁未释放，等待锁释放后再次获取到才能执行
        new Thread(() -> phone.sendSMS()).start();
    }
}
