package com.test.juc01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int number = new Random().nextInt(100);
            list.add(number);
            System.out.println(number);
            Thread.sleep(500);
        }

        return list.get(list.size() - 1);
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        new Thread(task).start();
        System.out.println("最后一次随机数是：" + task.get());
    }
}
