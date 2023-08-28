package com.test.thread.day12.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * CompletableFuture异步编程，获取异步任务结果
 * CompletableFuture实现了接口Future和CompletionStage
 */
public class CompletableFutureGetDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> async = null;
        Supplier<Integer> supplier = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10 / 0;
        };

        System.out.println("===========================get===========================");
        // 1、如果完成则返回结果，否则就抛出具体的异常ExecutionException
        // public T get() throws InterruptedException, ExecutionException
        // public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
        async = CompletableFuture.supplyAsync(supplier);
        try {
            System.out.println(async.get()); // 抛出异常
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(async.isDone()); // true

        System.out.println("===========================join===========================");
        // 2、完成时返回结果值，否则抛出unchecked异常CompletionException，join会阻塞当前线程等待异步线程结束
        // public T join()
        async = CompletableFuture.supplyAsync(supplier);
        try {
            System.out.println(async.join()); // 抛出异常
        } catch (CompletionException e) {
            e.printStackTrace();
        }
        System.out.println(async.isDone()); // true

        System.out.println("===========================getNow===========================");
        // 3、如果完成则返回结果值（或抛出任何遇到的异常），否则返回给定的 valueIfAbsent，不调用get()方法阻塞等待，就直接返回valueIfAbsent了
        // public T getNow(T valueIfAbsent)
        async = CompletableFuture.supplyAsync(() -> 10);
        // 任务正常完成
        System.out.println(async.get()); // 10
        System.out.println(async.getNow(999)); // 10
        System.out.println(async.isDone()); // true

        // 任务异常
        async = CompletableFuture.supplyAsync(supplier);
        try {
            System.out.println(async.get()); // 抛出异常
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(async.getNow(999)); // 抛出异常
        } catch (CompletionException e) {
            e.printStackTrace();
        }
        System.out.println(async.isDone()); // true

        // 任务未完成
        async = CompletableFuture.supplyAsync(supplier);
        System.out.println(async.getNow(999)); // 999
        System.out.println(async.isDone()); // false

        System.out.println("===========================complete===========================");
        // 4、如果任务没有完成，返回的值设置为给定值，并且设置完成状态，否则不主动设置完成状态
        // public boolean complete(T value)
        // 任务未完成
        async = CompletableFuture.supplyAsync(supplier);
        System.out.println(async.complete(99)); // true
        System.out.println(async.get()); // 99
        System.out.println(async.isDone()); // true

        // 任务已完成
        async = CompletableFuture.supplyAsync(() -> 10);
        System.out.println(async.get()); // 10
        System.out.println(async.complete(99)); // false
        System.out.println(async.isDone()); // true

        System.out.println("===========================completeExceptionally===========================");
        // 5、如果任务没有完成，就抛出给定异常
        // public boolean completeExceptionally(Throwable ex)
        // 任务未完成
        async = CompletableFuture.supplyAsync(supplier);
        System.out.println(async.completeExceptionally(new InterruptedException("任务没有完成"))); // true
        System.out.println(async.isDone()); // true
        try {
            System.out.println(async.get()); // 抛出异常
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 任务已完成
        async = CompletableFuture.supplyAsync(() -> 10);
        System.out.println(async.get()); // 10
        System.out.println(async.completeExceptionally(new InterruptedException("任务没有完成"))); // false
        System.out.println(async.isDone()); // true
    }
}
