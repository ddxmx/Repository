package com.test.day18;

import java.util.concurrent.*;

/**
 * 创建线程的第四种方式：线程池
 * 如果执行任务时CPU密集型的，创建超过CPU数量的线程就是没有必要的，不会加快程序的执行。
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "运行，i=" + i);
                sum += i;
            }
            System.out.println("线程" + Thread.currentThread().getName() + "运行，1+2+...+10=" + sum);
        };

        //使用Executors工具类
        {
            //创建指定线程数量的线程池
            ExecutorService service = Executors.newFixedThreadPool(10);

            //向线程池中提交任务
            service.submit(runnable);
            service.submit(runnable);

            //线程池关闭，执行方法后，线程池任务执行结束后就关闭了
            service.shutdown();
        }

        //使用ThreadPoolExecutor线程池创建类
        {
            int corePoolSize = 3;
            int maximumPoolSize = 10;
            int keepAliveTime = 30;
            ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                    keepAliveTime, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>());

            executor.submit(runnable);
            executor.submit(runnable);

            executor.shutdown();
        }
    }
}
