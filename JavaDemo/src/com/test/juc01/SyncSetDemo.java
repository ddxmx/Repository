package com.test.juc01;

import java.util.*;

/**
 * 线程安全的Set
 */
public class SyncSetDemo {
    public static void main(String[] args) throws InterruptedException {
        //非线程安全的Set，java.util.ConcurrentModificationException
        Set<String> set = new HashSet<>();
//        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
//        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 50; i++) {
            final int temp = i;
            new Thread(() -> {
                set.add(String.valueOf(temp));
                System.out.println(set);
            }).start();
        }
    }
}
