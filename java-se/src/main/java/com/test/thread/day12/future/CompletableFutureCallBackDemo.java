package com.test.thread.day12.future;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture异步编程
 * CompletableFuture实现了接口Future和CompletionStage
 */
public class CompletableFutureCallBackDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> theadPrint());
        // 等待子任务执行完成，打印返回值
        System.out.println(async.get());

        // 3、thenApply表示某个任务执行完成后执行的动作，即回调方法，会将该任务的执行结果即方法返回值作为入参传递到回调方法中
        // public <U> CompletableFuture<U> thenApply
        CompletableFuture<String> async3 = async.thenApply(result -> join(result, theadPrint()));
        System.out.println(async3.get());
        // public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn)
        // public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)
        CompletableFuture<String> async4 = async.thenApplyAsync(result -> join(result, theadPrint()));
        System.out.println(async4.get());

        // thenAccept 同thenApply接收上一个任务的返回值作为参数，但是无返回值
        CompletableFuture<Void> async5 = async.thenAcceptAsync(result -> System.out.println(join(result, theadPrint())));

        // thenRun 没有入参，也买有返回值
        CompletableFuture<Void> async6 = async.thenRunAsync(() -> System.out.println("thenRunAsync"));

        // exceptionally方法指定某个任务执行异常时执行的回调方法，会将抛出异常作为参数传递到回调方法中，如果该任务正常执行则会exceptionally方法返回的CompletionStage的result就是该任务正常执行的结果
        CompletableFuture<String> async7 = async.thenApply(result -> String.valueOf(10 / 0)).exceptionally(e -> e.getMessage());
        System.out.println(async7.get());

        // whenComplete

        // handle

    }

    public static String theadPrint() {
        return Thread.currentThread().getName();
    }

    public static String join(String result, String info) {
        return StringUtils.joinWith(" | ", result, info);
    }
}
