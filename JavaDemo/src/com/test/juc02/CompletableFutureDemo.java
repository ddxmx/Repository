package com.test.juc02;

import java.util.concurrent.*;
import java.util.function.BiConsumer;

/**
 * JDK1.8新增的异步回调
 * public static CompletableFuture<Void> runAsync(Runnable runnable)
 * public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
 * public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
 * public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        //调用第三方接口无异常时
        服务器开始调用第三方接口...
        服务器结束调用第三方接口...
        服务器调用第三方接口正常，返回的数据为：hello world!
        客户端收到response：调用第三方接口正常，第三方数据长度为：12

        //调用第三方接口异常时
        服务器开始调用第三方接口...
        服务器调用第三方接口异常
        客户端收到response：调用第三方接口异常，异常信息：java.lang.ArithmeticException: / by zero
         */
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("服务器开始调用第三方接口...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            System.out.println(10 / 0);

            System.out.println("服务器结束调用第三方接口...");
            return "hello world!";
        }, threadPool);

        //同步方式
//        System.out.println("第三方接口调用结果：" + completableFuture.get());

        BiConsumer<? super String, ? super Throwable> action = (str, ex) -> {
            if (null != ex) {
                System.out.println("客户端收到response：" + ex.getMessage());
            } else {
                if (null != str) {
                    System.out.println("客户端收到response：" + str);
                }
            }
        };

        //回调，接受上一阶段的输出并返回结果，可用的如thenAccept(接受结果，不返回结果)、thenRun(不接收结果，也不返回结果)
        //正常或异常后，最后都执行whenComplete
        completableFuture.thenApply(str -> {
            System.out.println("服务器调用第三方接口正常，返回的数据为：" + str);
            //服务器处理时间
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "调用第三方接口正常，第三方数据长度为：" + str.length();
        }).exceptionally(e -> {
            System.out.println("服务器调用第三方接口异常");
            return "调用第三方接口异常，异常信息：" + e.getMessage();
        }).whenComplete(action);

        //无论是否有异常都会执行，功能更强大
//        completableFuture.handle((str, e) -> {
//            if (null == e) {
//                e.printStackTrace();
//                return null;
//            }
//            return str;
//        });

        /*
        服务器开始调用第三方接口...
        服务器调用第三方接口正常，返回的数据为：finished
        客户端收到response：调用第三方接口正常，第三方数据长度为：8
        服务器结束调用第三方接口...
         */
        //可以使用complete来完成一个future
        completableFuture.complete("finished");

        threadPool.shutdown();
    }
}
