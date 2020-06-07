package com.test.juc02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.DiscardPolicy() //直接拒绝，不会有异常
//                new ThreadPoolExecutor.AbortPolicy() //直接拒绝，报异常
                new ThreadPoolExecutor.CallerRunsPolicy() //交给调用线程执行
        );
        try {
            for (int i = 0; i < 10; i++) {
                executor.submit(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "运行~");
                });
            }
        } finally {
            executor.shutdown();
        }

    }
}
