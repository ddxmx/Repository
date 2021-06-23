package com.test.day30;

import java.util.concurrent.TimeUnit;

/**
 * 八锁问题之三
 * 同步方法使用的是对象锁
 */
public class LockProblemDemo03 {
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

        /**
         * 非同步方法，执行时无需获取锁
         */
        public void playGames() {
            System.out.println("玩游戏");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*
            玩游戏
            打电话
         */
        Phone phone = new Phone();
        new Thread(() -> phone.call()).start();
        TimeUnit.SECONDS.sleep(1);
        // 非同步方法，不需要获取锁，直接执行
        new Thread(() -> phone.playGames()).start();
    }
}
