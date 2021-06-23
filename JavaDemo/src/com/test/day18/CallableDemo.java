package com.test.day18;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口
 * 优点：
 * 1、线程可以有返回值
 * 2、线程可以抛出异常
 */
class CallableTicket implements Callable<Integer> {
    private int ticket = 5;

    @Override
    public Integer call() throws Exception {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票，余票：" + --ticket);
            } else {
                throw new Exception("callable中抛出的异常");
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
        CallableTicket ticket = new CallableTicket();
        FutureTask task = new FutureTask(ticket);
        FutureTask task2 = new FutureTask(ticket);
        FutureTask task3 = new FutureTask(ticket);
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

        System.out.println("等待线程结束，获取结果...");
        try {
            //FutureTak的get()方法是阻塞的
            System.out.println(task.get());
            System.out.println(task2.get());
            System.out.println(task3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {  //callable中的异常被捕获处理后，抛出ExecutionException
            e.printStackTrace();
        }
    }
}
