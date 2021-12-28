package com.test.thread.day12.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口
 * 优点：
 * 1、线程可以有返回值
 * 2、线程可以抛出异常
 */
class MyCallable implements Callable<Integer> {
    private int ticket = 5;

    @Override
    public Integer call() throws Exception {
        while (true) {
            if (ticket > 0) {
                Thread.sleep(10);
                System.out.println("线程" + Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            } else if (ticket == 0) {
                return 0;
            } else {
                throw new Exception("线程" + Thread.currentThread().getName() + "：ticket不能小于0");
            }
        }
    }
}

/**
 * callable中的异常只有在使用FutureTask对象的get()方法时才抛出
 * 线程运行过程中不会抛出异常，原因是异常被内部捕获了
 */
public class CallableDemo {
    public static void main(String[] args) {
        MyCallable callable = new MyCallable();

        // 创建异步任务
        FutureTask task = new FutureTask(callable);
        FutureTask task2 = new FutureTask(callable);
        FutureTask task3 = new FutureTask(callable);

        System.out.println("========将task作为Runnable对象使用，不会抛出异常========");
        /*
            Thread-0卖票，余票：4
            Thread-0卖票，余票：3
            Thread-2卖票，余票：2
            Thread-1卖票，余票：1
            Thread-2卖票，余票：0
         */
        new Thread(task).start();
        new Thread(task2).start();
        new Thread(task3).start();

        System.out.println("========使用FutureTask的get获取========");
        /*
            线程Thread-0卖票，余票：4
            线程Thread-1卖票，余票：2
            线程Thread-2卖票，余票：3
            线程Thread-1卖票，余票：0
            线程Thread-0卖票，余票：-1
            线程Thread-2卖票，余票：1
            java.util.concurrent.ExecutionException: java.lang.Exception: 线程Thread-0：ticket不能小于0
         */
        try {
            // FutureTask的get()方法是阻塞的
            System.out.println(task.get());
            System.out.println(task2.get());
            System.out.println(task3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // callable中的异常被捕获处理后，抛出ExecutionException
        catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}