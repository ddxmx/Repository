package com.test.thread.day12;

/**
 * 线程外部获取Runnable中抛出的异常
 * Runnable中run()方法没有声明异常，因此run()方法中只能抛出RuntimeException
 */
public class ThreadExceptionDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                if (i == 3) {
                    // 只能抛出RuntimeException异常，否则必须使用try-catch处理
                    throw new IllegalArgumentException("Runnable中run()方法抛出的异常");
                }
                System.out.println("i = " + i);
            }
        };

        // 创建线程类对象
        Thread thread = new Thread(runnable, "线程A");

        // Thread可以通过setUncaughtExceptionHandler注册一个回调接口
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("线程名称：" + t.getName() + "，异常信息：" + e.getMessage());
        });

        /*
            i = 0
            i = 1
            i = 2
            线程名称：线程A，异常信息：Runnable中run()方法抛出的异常
         */
        thread.start();
    }
}
