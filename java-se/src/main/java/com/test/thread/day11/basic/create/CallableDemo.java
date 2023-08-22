package com.test.thread.day11.basic.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口，覆写call()方法
 * 1、call()方法相比Runnable接口的run()方法，优点：
 * （1）线程可以有返回值
 * （2）线程可以抛出异常
 */
class MyCallable implements Callable<Integer> {
    private int ticket = 5;

    @Override
    public Integer call() throws Exception {
        int salCount = 0;

        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
                salCount++;
                Thread.sleep(500);
            } else {
                // 返回线程售卖的票数
                return salCount;
            }
        }
    }
}

/**
 * callable中的异常只有在使用FutureTask对象的get()方法时才抛出
 * 线程运行过程中不会抛出异常，原因是内部捕获了Throwable异常
 */
public class CallableDemo {
    public static void main(String[] args) {
        System.out.println("========将FutureTask作为Runnable对象使用，不会抛出异常========");
        MyCallable callable = new MyCallable();

        // 不同的线程需要使用不同的FutureTask，通过FutureTask获取线程的执行状态
        // 继承关系：FutureTask -> RunnableFuture -> Runnable、Future
        FutureTask task = new FutureTask(callable);
        FutureTask task2 = new FutureTask(callable);
        FutureTask task3 = new FutureTask(callable);

        /*
            线程A卖票，余票：4
            线程B卖票，余票：3
            线程C卖票，余票：2
            线程C卖票，余票：0
            线程A卖票，余票：1
         */
        new Thread(task, "线程A").start();
        new Thread(task2, "线程B").start();
        new Thread(task3, "线程C").start();

        System.out.println("========使用FutureTask的get()方法获取线程的返回值========");
        try {
            // FutureTask的get()方法是阻塞的，等待线程执行完成
            System.out.println(task.get()); // 2
            System.out.println(task2.get()); // 1
            System.out.println(task3.get()); // 2
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) { // callable中的异常被捕获处理后，抛出ExecutionException
            e.printStackTrace();
        }
    }
}
