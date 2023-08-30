package com.test.thread.day12.async;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture异步编程
 * CompletableFuture实现了接口Future和CompletionStage
 */
public class CompletableFutureCallBackDemo {
    public static void main(String[] args) {
        CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> "hello");

        System.out.println("==========================串行任务==========================");
        // 1、有参数有返回值，把前面任务的执行结果通过参数传入
        // public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn)
        async.thenApplyAsync(e -> e + " world");

        // 2、有参数无返回值，把前面任务的执行结果通过参数传入
        // public CompletableFuture<Void> thenAccept(Consumer<? super T> action)
        async.thenAcceptAsync(e -> System.out.println(e));

        // 3、无参数无返回值
        // public CompletableFuture<Void> thenRun(Runnable action)
        async.thenRunAsync(() -> System.out.println("hello"));

        // 4、有参数有返回值，返回一个新的CompletableFuture
        // public <U> CompletableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn)
        CompletableFuture<String> async12 = async.thenComposeAsync(e -> CompletableFuture.supplyAsync(() -> e + " world"));
        System.out.println(async12.join()); // hello world

        System.out.println("==========================并行AND关系==========================");
        // 1、有参数有返回值，两个并行任务都执行结束后，再执行后续任务
        // public <U,V> CompletableFuture<V> thenCombine(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn)
        async.thenCombine(CompletableFuture.supplyAsync(() -> " world"), (a, b) -> a + b);

        // 2、有参数无返回值，两个并行任务都执行结束后，再执行后续任务
        // public <U> CompletableFuture<Void> thenAcceptBoth(CompletionStage<? extends U> other,BiConsumer<? super T, ? super U> action)
        async.thenAcceptBoth(CompletableFuture.supplyAsync(() -> " world"), (a, b) -> System.out.println(a + b));

        // 3、无参数无返回值，两个并行任务都执行结束后，再执行后续任务
        // CompletableFuture<Void> runAfterBoth(CompletionStage<?> other,Runnable action)
        async.runAfterBoth(CompletableFuture.runAsync(() -> System.out.println("world")), () -> System.out.println("runAfterBoth"));

        // 4、无参无返回值，当所有给定的CompletableFuture完成时，返回一个新的CompletableFuture
        // public static CompletableFuture<Void> allOf(CompletableFuture<?>... cfs)
        CompletableFuture.allOf(async, CompletableFuture.supplyAsync(() -> "hello"), CompletableFuture.supplyAsync(() -> "world"));

        System.out.println("==========================并行OR关系==========================");
        // 1、两个任务哪个执行的快，就使用哪一个结果，有返回值
        // public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
        async.applyToEither(CompletableFuture.supplyAsync(() -> " world"), e -> e);

        // 2、两个任务哪个执行的快，就消费哪一个结果，无返回值
        // public CompletableFuture<Void> acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action)
        async.acceptEither(CompletableFuture.supplyAsync(() -> " world"), e -> System.out.println(e));

        // 3、任意一个任务执行完成，进行下一步操作(Runnable类型任务)
        // public CompletableFuture<Void> runAfterEither(CompletionStage<?> other,Runnable action)
        async.runAfterEither(CompletableFuture.runAsync(() -> System.out.println("world")), () -> System.out.println("runAfterEither"));

        // 4、当任何一个给定的CompletableFuture完成时，返回一个新的CompletableFuture
        // public static CompletableFuture<Object> anyOf(CompletableFuture<?>... cfs)
        CompletableFuture.anyOf(async, CompletableFuture.supplyAsync(() -> "hello"), CompletableFuture.supplyAsync(() -> "world"));

        System.out.println("==========================结果处理==========================");
        // 1、exceptionally：返回一个新的CompletableFuture，当前面的CompletableFuture完成时，它也完成，当它异常完成时，给定函数的异常触发这个CompletableFuture的完成，可以理解为catch结构
        // public CompletableFuture<T> exceptionally(Function<Throwable, ? extends T> fn)
        async.exceptionally(exception -> "hello world");

        // 2、whenComplete：当任务完成时，将使用结果和此阶段的异常执行给定操作，whenComplete中的逻辑不会影响计算结果，可以理解为finally结构
        // public CompletableFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> action)
        async.whenComplete((e, exception) -> System.out.println(exception));

        // 3、handle与whenComplete的作用有些类似，但是handle接收的处理函数有返回值，而且返回值会影响最终获取的计算结果，可以理解为finally结构
        // public <U> CompletableFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> fn)
        async.handle((e, exception) -> "result:" + e.toString());
    }
}
