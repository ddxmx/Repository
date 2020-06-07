package com.test.juc02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * ForkJoin将大任务分成小任务执行，直到compute中条件不满足时不再分，类似递归思想
 */
class SumTask extends RecursiveTask<Long> {
    private long start;
    private long end;

    public SumTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start < 10000) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            //将一个任务分为两个任务
            long middle = (start + end) / 2;
            SumTask task1 = new SumTask(start, middle);
            SumTask task2 = new SumTask(middle + 1, end);
            //执行任务
            invokeAll(task1, task2);
            //合并任务结果
            return task1.join() + task2.join();
        }
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long sum = 0;
        long startTime1 = System.currentTimeMillis();
        for (long i = 1; i <= 20_0000_0000L; i++) {
            sum += i;
        }
        System.out.println("普通方式耗时：" + (System.currentTimeMillis() - startTime1));
        System.out.println(sum);

        //使用上和线程池一致
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new SumTask(1, 20_0000_0000L);
        long startTime2 = System.currentTimeMillis();
        pool.submit(task);
        Long sum2 = task.get();
        System.out.println("forkJoin耗时：" + (System.currentTimeMillis() - startTime2));
        System.out.println(sum2);

        //Stream方式
        long startTime3 = System.currentTimeMillis();
        long sum3 = LongStream.rangeClosed(1, 20_0000_0000L).parallel().reduce(Long::sum).getAsLong();
        System.out.println("stream耗时：" + (System.currentTimeMillis() - startTime3));
        System.out.println(sum3);
    }
}
