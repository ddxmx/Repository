package com.test.juc01;

import java.util.*;

/**
 * 线程安全的Map
 */
public class SyncMapDemo {
    public static void main(String[] args) {
        //非线程安全的Map，java.util.ConcurrentModificationException
        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
//        Map<Integer, Integer> map = new Hashtable<>();
        for (int i = 0; i < 50; i++) {
            final int temp = i;
            new Thread(() -> {
                map.put(temp, temp);
                System.out.println(map);
            }).start();
        }
    }
}
