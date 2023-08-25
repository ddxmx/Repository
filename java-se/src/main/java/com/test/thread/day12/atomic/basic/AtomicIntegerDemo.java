package com.test.thread.day12.atomic.basic;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicIntegerRunnable implements Runnable {
    private int count = 0;
    // atomicCount的任何操作不会影响count
    private AtomicInteger atomicCount = new AtomicInteger(count);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // 非原子操作
            count++;
            // 原子操作
            atomicCount.incrementAndGet();
        }
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicCount() {
        return atomicCount;
    }
}

/**
 * 基本数据类型原子操作
 * CAS指令：lock cmpxchg 指令，lock保证执行cmpxchg指令过程中不会被其他线程打断
 * getAndIncrement、getAndSet类似的方法可以保证获取+赋值的原子性
 * getAndIncrement、getAndSet类似的方法会进行自旋操作，compareAndSet不会自旋，可以保证最终只有一个线程执行成功
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=====================原子类操作不使用锁，也能安全操作数据=====================");
        AtomicIntegerRunnable atomicIntegerRunnable = new AtomicIntegerRunnable();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            Thread thread = new Thread(atomicIntegerRunnable);
            thread.start();
            threads[i] = thread;
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("非原子操作，count=" + atomicIntegerRunnable.getCount()); // 非原子操作，count=65744
        System.out.println("原子操作，atomicCount=" + atomicIntegerRunnable.getAtomicCount()); // 原子操作，atomicCount=100000

        System.out.println("=====================原子类的常用方法=====================");
        atomicMethod();
    }

    public static void atomicMethod() {
        // 初始化
        AtomicInteger atomicInteger = new AtomicInteger(0);

        // 设置值
        atomicInteger.set(5);
        // 获取值
        System.out.println(atomicInteger.get()); // 5

        // 返回原来的值，并设置新值
        System.out.println(atomicInteger.getAndSet(10)); // 5
        System.out.println(atomicInteger.get()); // 10

        // 先获取再加1
        System.out.println(atomicInteger.getAndIncrement()); // 10
        System.out.println(atomicInteger.get()); // 11
        // 先加1再获取
        System.out.println(atomicInteger.incrementAndGet()); // 12
        System.out.println(atomicInteger.get()); // 12

        // 先获取再减1
        System.out.println(atomicInteger.getAndDecrement()); // 12
        System.out.println(atomicInteger.get()); // 11
        // 先减1再获取
        System.out.println(atomicInteger.decrementAndGet()); // 10
        System.out.println(atomicInteger.get()); // 10

        // 先获取再加指定值
        System.out.println(atomicInteger.getAndAdd(5)); // 10
        System.out.println(atomicInteger.get()); // 15
        // 先加指定值再获取
        System.out.println(atomicInteger.addAndGet(5)); // 20
        System.out.println(atomicInteger.get()); // 20

        // 当前值等于预期值时，设置新值，判断不成立
        atomicInteger.compareAndSet(10, 12);
        System.out.println(atomicInteger.get()); // 20
        // 当前值等于预期值时，设置新值，判断成立
        atomicInteger.compareAndSet(20, 22);
        System.out.println(atomicInteger.get()); // 22
    }
}
