package com.test.thread.day12.create;

import java.time.LocalDateTime;
import java.util.concurrent.*;

class MyTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
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
        Runnable task = new MyTask();

        // 使用Executors工具类创建线程池
        /*
            2022-05-29T11:53:29.351，线程pool-1-thread-1运行，i=1
            2022-05-29T11:53:29.351，线程pool-1-thread-2运行，i=1
            2022-05-29T11:53:30.372，线程pool-1-thread-2运行，i=2
            2022-05-29T11:53:30.372，线程pool-1-thread-1运行，i=2
            2022-05-29T11:53:31.375，线程pool-1-thread-2运行，i=3
            2022-05-29T11:53:31.375，线程pool-1-thread-1运行，i=3
            2022-05-29T11:53:32.391，线程pool-1-thread-2运行，i=4
            2022-05-29T11:53:32.391，线程pool-1-thread-1运行，i=4
            2022-05-29T11:53:33.399，线程pool-1-thread-2运行，i=5
            2022-05-29T11:53:33.399，线程pool-1-thread-1运行，i=5
         */
        {
            // 创建固定线程数量的线程池
            ExecutorService service = Executors.newFixedThreadPool(10);

            // 向线程池中提交任务
            service.submit(task);
            service.submit(task);

            // 线程池关闭，执行方法后，线程池任务执行结束后就关闭了
            service.shutdown();

            // 等待线程池任务执行结束
            try {
                service.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 使用ThreadPoolExecutor类创建线程池
        /*
            2022-05-29T11:58:54.197，线程pool-2-thread-1运行，i=1
            2022-05-29T11:58:54.197，线程pool-2-thread-2运行，i=1
            2022-05-29T11:58:55.206，线程pool-2-thread-1运行，i=2
            2022-05-29T11:58:55.206，线程pool-2-thread-2运行，i=2
            2022-05-29T11:58:56.222，线程pool-2-thread-1运行，i=3
            2022-05-29T11:58:56.222，线程pool-2-thread-2运行，i=3
            2022-05-29T11:58:57.237，线程pool-2-thread-2运行，i=4
            2022-05-29T11:58:57.237，线程pool-2-thread-1运行，i=4
            2022-05-29T11:58:58.252，线程pool-2-thread-1运行，i=5
            2022-05-29T11:58:58.252，线程pool-2-thread-2运行，i=5
         */
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
