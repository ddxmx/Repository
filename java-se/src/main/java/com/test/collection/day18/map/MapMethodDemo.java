package com.test.collection.day18.map;

import java.util.HashMap;
import java.util.Map;

/**
 * JDK8新增的map操作
 */
public class MapMethodDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhangsan", 15);

        System.out.println("=========================putIfAbsent=========================");
        // default V putIfAbsent(K key, V value)
        // 若key存在，返回原value值；若key不存在，存储新value返回null
        System.out.println(map.putIfAbsent("lisi", 12)); // null
        System.out.println(map); // {lisi=12, zhangsan=15}

        System.out.println(map.putIfAbsent("zhangsan", 20)); // 15
        System.out.println(map); // {lisi=12, zhangsan=15}

        System.out.println("=========================computeIfAbsent=========================");
        map.clear();
        map.put("zhangsan", 15);

        // default V computeIfAbsent(K key,Function<? super K, ? extends V> mappingFunction)
        // 若key存在，返回原value值；若key不存在，存储新value返回存储的值，新value为null，则不会添加进map
        System.out.println(map.computeIfAbsent("wangwu", k -> 16)); // 16
        System.out.println(map); // {zhangsan=15, wangwu=16}

        System.out.println(map.computeIfAbsent("zhangsan", k -> 20)); // 15
        System.out.println(map); // {zhangsan=15, wangwu=16}

        System.out.println(map.computeIfAbsent("lisi", k -> null)); // null
        System.out.println(map); // {zhangsan=15, wangwu=16}

        System.out.println("=========================computeIfPresent=========================");
        map.clear();
        map.put("zhangsan", 15);
        map.put("lisi", 20);

        // default V computeIfPresent(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        // 若key存在，对key和value操作得到newValue，替换原值，newValue为null，则删除key到value的映射
        System.out.println(map.computeIfPresent("zhangsan", (k, v) -> v + 1)); // 16
        System.out.println(map); // {lisi=20, zhangsan=16}

        System.out.println(map.computeIfPresent("lisi", (k, v) -> null)); // null
        System.out.println(map); // {zhangsan=16}

        System.out.println(map.computeIfPresent("wangwu", (k, v) -> v + 2)); // null
        System.out.println(map); // {zhangsan=16}

        System.out.println("=========================getOrDefault=========================");
        // default V getOrDefault(Object key, V defaultValue)
        // 若key不存在，返回默认值
        Integer value4 = map.getOrDefault("tom", 18);
        System.out.println(value4); // 18
    }
}
