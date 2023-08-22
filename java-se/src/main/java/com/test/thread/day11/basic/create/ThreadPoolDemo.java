package com.test.thread.day11.basic.create;

import java.util.concurrent.*;

class MyRunnableTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "运行，i=" + i);
        }
    }
}

/**
 * 创建线程的第四种方式：线程池
 * 如果执行任务是CPU密集型的，创建超过CPU数量的线程就是没有必要的，不会加快程序的执行。
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        Runnable task = new MyRunnableTask();

        System.out.println("==========================使用线程池工具类创建线程==========================");
        {
            /*
                线程pool-1-thread-3运行，i=1
                线程pool-1-thread-2运行，i=1
                线程pool-1-thread-1运行，i=1
                线程pool-1-thread-1运行，i=2
                线程pool-1-thread-3运行，i=2
                线程pool-1-thread-2运行，i=2
                线程pool-1-thread-1运行，i=3
                线程pool-1-thread-2运行，i=3
                线程pool-1-thread-3运行，i=3
             */
            // 创建固定线程数量的线程池，线程数量=cpu核数+1
            ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

            // 向线程池中提交任务
            for (int i = 0; i < 3; i++) {
                service.submit(task);
            }

            // 线程池关闭，线程池任务执行结束后就关闭了，方法不阻塞
            service.shutdown();
            // 调用线程池的shutdown方法后，isShutdown()就返回true，不再接收新的任务
            System.out.println("isShutdown：" + service.isShutdown()); // true
            // 等待线程池中所有任务都已完成后，isTerminated()才返回true
            System.out.println("isTerminated：" + service.isTerminated()); // false

            // 等待线程池任务执行结束，方法阻塞
            try {
                service.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("isShutdown：" + service.isShutdown()); // true
            System.out.println("isTerminated：" + service.isTerminated()); // true
        }

        System.out.println("==========================手动指定线程参数创建线程（推荐）==========================");
        {
            /*
                线程pool-2-thread-2运行，i=1
                线程pool-2-thread-1运行，i=1
                线程pool-2-thread-2运行，i=2
                线程pool-2-thread-1运行，i=2
                线程pool-2-thread-1运行，i=3
                线程pool-2-thread-2运行，i=3
                线程pool-2-thread-1运行，i=1
                线程pool-2-thread-1运行，i=2
                线程pool-2-thread-1运行，i=3
             */
            // 核心线程数，初始线程的数量
            int corePoolSize = 2;
            // 最大线程数
            int maximumPoolSize = Runtime.getRuntime().availableProcessors() + 1;
            // 超过核心线程数的线程，超过keepAliveTime空闲就回收
            int keepAliveTime = 300;

            ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                    keepAliveTime, TimeUnit.SECONDS,
                    new LinkedBlockingQueue(10)); // 线程池等待队列长度

            executor.submit(task);
            executor.submit(task);
            executor.submit(task);

            // 线程池关闭，线程池任务执行结束后就关闭了，方法不阻塞
            executor.shutdown();
            // 调用线程池的shutdown方法后，isShutdown()就返回true，不再接收新的任务
            System.out.println("isShutdown：" + executor.isShutdown()); // true
            // 等待线程池中所有任务都已完成后，isTerminated()才返回true
            System.out.println("isTerminated：" + executor.isTerminated()); // false

            // 等待线程池任务执行结束，方法阻塞
            try {
                executor.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("isShutdown：" + executor.isShutdown()); // true
            System.out.println("isTerminated：" + executor.isTerminated()); // true
        }
    }
}
