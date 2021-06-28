package com.test.day24;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全的List
 */
public class SyncListDemo {
    public static void main(String[] args) throws InterruptedException {
        //非线程安全的List，多个线程同时修改同一个list，java.util.ConcurrentModificationException
        List<String> list = new ArrayList<>();
        //List<Object> list = Collections.synchronizedList(new ArrayList<>());
        //List<String> list = new CopyOnWriteArrayList<>();
        //List<String> list = new Vector<>();

        for (int i = 0; i < 30; i++) {
            final int temp = i;
            new Thread(() -> {
                list.add(String.valueOf(temp));
                System.out.println(list);
            }).start();
        }
    }
}
