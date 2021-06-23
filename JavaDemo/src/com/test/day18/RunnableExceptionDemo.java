package com.test.day18;

/**
 * 线程外部获取Runnable中抛出的异常
 */
public class RunnableExceptionDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("hello world-" + i);
                if (i == 3) {
                    //只能抛出RuntimeException异常，否则必须使用try-catch处理
                    throw new IllegalArgumentException("run方法抛出的异常");
                }
            }
        }, "线程A");

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("线程名称：" + t.getName());
            System.out.println("线程是否存活：" + t.isAlive());
            System.out.println("抛出的异常信息：" + e.getMessage());
        });

        /*
            hello world-0
            hello world-1
            hello world-2
            hello world-3
            线程名称：线程A
            线程是否存活：true
            抛出的异常信息：run方法抛出的异常
         */
        thread.start();
    }
}
