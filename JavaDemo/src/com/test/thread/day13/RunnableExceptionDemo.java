package com.test.thread.day13;

/**
 * 线程外部获取Runnable中抛出的异常
 * Runnable中run()方法没有声明异常，因此run()方法中只能抛出runtime exception
 */
public class RunnableExceptionDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("hello world：" + i);
                if (i == 3) {
                    // 只能抛出RuntimeException异常，否则必须使用try-catch处理
                    throw new IllegalArgumentException("Runnable中run()方法抛出的异常");
                }
            }
        }, "子线程");

        // Thread可以通过setUncaughtExceptionHandler注册一个回调接口
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + "抛出的异常信息：" + e.getMessage());
        });

        /*
            hello world：0
            hello world：1
            hello world：2
            hello world：3
            子线程抛出的异常信息：Runnable中run()方法抛出的异常
         */
        thread.start();
    }
}
