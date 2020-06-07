package com.test.juc02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 多线程是实现异步的一种方式
 * FutureTask类进行子线程启动后，调用get方法获取结果
 * 此种方式不能完全进行异步操作，get方法是阻塞的，无异于同步
 * 获取线程是否执行结束，可以通过阻塞方法get或通过非阻塞方法isDone来不停判断
 * 子线程完成后并不能通知创建者
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        把衣服送到洗衣店去洗
        去超市购买东西
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服还没有清洗完成~
        衣服清洗完成
         */
        System.out.println("把衣服送到洗衣店去洗");
        FutureTask<String> task = new FutureTask<String>(() -> {
            TimeUnit.SECONDS.sleep(5);
            return "衣服清洗完成";
        });
        new Thread(task).start();
        System.out.println("去超市购买东西");
        while (!task.isDone()){ // isDone可以判断任务是否完成
            System.out.println("衣服还没有清洗完成~");
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println(task.get());
    }
}
