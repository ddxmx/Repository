package com.test.juc01;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全的List
 */
public class SyncListDemo {
    public static void main(String[] args) throws InterruptedException {
        //非线程安全的List，java.util.ConcurrentModificationException
        List<String> list = new ArrayList<>();
//        List<Object> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new CopyOnWriteArrayList<>();
//        List<String> list = new Vector<>();
        for (int i = 0; i < 50; i++) {
            final int temp = i;
            new Thread(() -> {
                list.add(String.valueOf(temp));
                System.out.println(list);
            }).start();
        }
    }
}
