package com.test.thread.day12.create;

import java.time.LocalDateTime;
import java.util.concurrent.*;

class MyTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now() + "，线程" + Thread.currentThread().getName() + "运行，i=" + i);
        }
    }
}

/**
 * 创建线程的第四种方式：线程池
 * 如果执行任务是CPU密集型的，创建超过CPU数量的线程就是没有必要的，不会加快程序的执行。
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        /*
            2021-12-21T22:22:46.667，线程pool-2-thread-2运行，i=1
            2021-12-21T22:22:46.667，线程pool-1-thread-1运行，i=1
            2021-12-21T22:22:46.668，线程pool-2-thread-1运行，i=1
            2021-12-21T22:22:46.668，线程pool-1-thread-2运行，i=1

            2021-12-21T22:22:47.669，线程pool-1-thread-1运行，i=2
            2021-12-21T22:22:47.669，线程pool-2-thread-2运行，i=2
            2021-12-21T22:22:47.669，线程pool-2-thread-1运行，i=2
            2021-12-21T22:22:47.669，线程pool-1-thread-2运行，i=2

            2021-12-21T22:22:48.680，线程pool-2-thread-1运行，i=3
            2021-12-21T22:22:48.680，线程pool-1-thread-1运行，i=3
            2021-12-21T22:22:48.680，线程pool-2-thread-2运行，i=3
            2021-12-21T22:22:48.680，线程pool-1-thread-2运行，i=3

            2021-12-21T22:22:49.691，线程pool-1-thread-2运行，i=4
            2021-12-21T22:22:49.691，线程pool-2-thread-2运行，i=4
            2021-12-21T22:22:49.691，线程pool-2-thread-1运行，i=4
            2021-12-21T22:22:49.691，线程pool-1-thread-1运行，i=4

            2021-12-21T22:22:50.704，线程pool-1-thread-2运行，i=5
            2021-12-21T22:22:50.704，线程pool-2-thread-2运行，i=5
            2021-12-21T22:22:50.704，线程pool-1-thread-1运行，i=5
            2021-12-21T22:22:50.704，线程pool-2-thread-1运行，i=5
         */
        Runnable task = new MyTask();

        // 使用Executors工具类创建线程池
        {
            // 创建固定线程数量的线程池
            ExecutorService service = Executors.newFixedThreadPool(10);

            // 向线程池中提交任务
            service.submit(task);
            service.submit(task);

            // 线程池关闭，执行方法后，线程池任务执行结束后就关闭了
            service.shutdown();
        }

        // 使用ThreadPoolExecutor类创建线程池
        {
            // 核心线程数，初始线程的数量
            int corePoolSize = 3;
            // 最大线程数
            int maximumPoolSize = 10;
            // 超过核心线程数的线程，超过keepAliveTime空闲就回收
            int keepAliveTime = 300;
            ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                    keepAliveTime, TimeUnit.SECONDS,
                    new LinkedBlockingQueue(100));

            executor.submit(task);
            executor.submit(task);

            executor.shutdown();
        }
    }
}
