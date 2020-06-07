package com.test.juc02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Message {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private List<Integer> list = new ArrayList();

    public void get() {
        lock.readLock().lock(); //读锁，多个线程都在读的时候是共享的
        try {
            list.forEach(x -> System.out.print(x + "、"));
            System.out.println();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set() {
        lock.writeLock().lock(); //多个线程在写的时候是互斥的，读和写同时也是互斥的
        try {
            list.add(new Random().nextInt(10000));
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Message message = new Message();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> message.get()).start();
            new Thread(() -> message.set()).start();
        }
    }
}
