package com.test.day18;

/**
 * 守护线程
 * 主线程结束后，守护线程也结束
 */
public class DaemonDemo {
    public static void main(String[] args) {
        /*
            Thread-0线程当前第1次执行
            main线程当前第1次执行
            main线程当前第2次执行
            Thread-0线程当前第2次执行
            Thread-0线程当前第3次执行
            main线程当前第3次执行
            main线程当前第4次执行
            Thread-0线程当前第4次执行
            Thread-0线程当前第5次执行
            main线程当前第5次执行
         */
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程当前第" + (i + 1) + "次执行");
            }
        });

        thread.setDaemon(true);
        thread.start();
        thread.isDaemon();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程当前第" + (i + 1) + "次执行");
        }

    }
}
