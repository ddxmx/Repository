package com.test.day19;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class CountThread extends Thread {
    //public static int count = 0;
    public static AtomicInteger count = new AtomicInteger();

    private CountDownLatch downLatch;

    public CountThread(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //count++;
            count.getAndIncrement();
        }
        downLatch.countDown();
    }
}

/**
 * 不使用原子操作可能存在的问题
 */
public class AtomicOperDemo {
    public static void main(String[] args) {
        int threadSize = 1000;
        CountDownLatch downLatch = new CountDownLatch(threadSize);

        for (int i = 0; i < 1000; i++) {
            new CountThread(downLatch).start();
        }

        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
            count++是非原子性操作，导致相同的值被重复累计
         */
        //System.out.println(CountThread.count); //999314
        System.out.println(CountThread.count.get()); //1000000
    }
}
