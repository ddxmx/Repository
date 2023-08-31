package com.test.collection.day18.map;

import java.util.*;

/**
 * Map：存储键值对key-value
 * （1）HashMap：Map的主要实现类，线程不安全，可以存储null的key和value，底层用的数组+链表+红黑树，key的元素需要覆写hashCode和equals方法
 * （2）LinkedHashMap：HashMap的子类，可以按照添加的顺序实现遍历
 * （3）TreeMap：可以进行排序，key的元素需要实现comparable接口
 * （4）Hashtable：古老的实现类，线程安全，不能存储null的key和value，已经逐步被ConcurrentHashMap取代
 */
public class MapDemo {
    public static void main(String[] args) {
        // 实例化HashMap并不会创建数组，首次调用put方法时，才创建长度为16的数组
        Map<String, Integer> map = new HashMap<>();
        map.put("AA", 123);
        map.put("45", 123);
        map.put("BB", 56);
        // 相同key会覆盖
        map.put("AA", 87);
        System.out.println(map); // {AA=87, BB=56, 45=123}

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("CC", 123);
        map2.put("DD", 123);
        // 将其他map中所有元素添加进来
        map.putAll(map2);
        System.out.println(map); // {AA=87, BB=56, CC=123, DD=123, 45=123}

        System.out.println("======================map常用方法======================");
        // 返回移除元素的value值
        Integer value = map.remove("CC");
        System.out.println(value); // 123
        System.out.println(map); // {AA=87, BB=56, DD=123, 45=123}

        System.out.println(map.get(45)); // 123
        System.out.println(map.containsKey("BB")); // true
        System.out.println(map.containsValue(123)); // true

        map.clear();
        System.out.println(map.size()); // 0
        System.out.println(map.isEmpty()); // true
        System.out.println(map); // {}

        System.out.println(map.get(45)); // null
        // key不存在，返回默认value值
        Integer defaultValue = map.getOrDefault(45, 10);
        System.out.println(defaultValue); // 10

        System.out.println("======================遍历key======================");
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        {
            Set<String> keySet = map.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                System.out.println(key + "->" + map.get(key));
            }
        }

        System.out.println("======================遍历value======================");
        {
            Collection<Integer> values = map.values();
            Iterator<Integer> iterator = values.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

        System.out.println("======================遍历键值对======================");
        {
            Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                System.out.println(entry.getKey() + "->" + entry.getValue());
            }
        }
    }
}
