package com.test.collection.day24;

import java.util.*;

/**
 * 线程安全的Map
 */
public class SyncMapDemo {
    public static void main(String[] args) {
        //非线程安全的Map，java.util.ConcurrentModificationException
        Map<String, String> map = new HashMap<>();
        //Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        //Map<String, Integer> map = new Hashtable<>();

        for (int i = 0; i < 30; i++) {
            final int temp = i;
            new Thread(() -> {
                map.put("key-" + temp, "value-" + temp);
                System.out.println(map);
            }).start();
        }
    }
}
