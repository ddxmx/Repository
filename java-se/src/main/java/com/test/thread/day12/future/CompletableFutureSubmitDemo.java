package com.test.thread.day12.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * CompletableFuture异步编程，创建异步任务
 * CompletableFuture实现了接口Future和CompletionStage
 */
public class CompletableFutureSubmitDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("==========================supplyAsync==========================");
        // 1、supplyAsync创建带有返回值的异步任务
        // public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
        // public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
        CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName());
        // 等待子任务执行完成，打印返回值
        System.out.println(async.get()); // ForkJoinPool.commonPool-worker-1

        System.out.println("==========================runAsync==========================");
        // 2、runAsync创建没有返回值的异步任务
        // public static CompletableFuture<Void> runAsync(Runnable runnable)
        // public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
        CompletableFuture<Void> async2 = CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println(async2.get()); // null
    }
}
