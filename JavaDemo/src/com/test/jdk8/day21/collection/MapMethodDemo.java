package com.test.jdk8.day21.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * JDK8 map操作
 */
public class MapMethodDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zhangsan", 15);

        // default V putIfAbsent(K key, V value)
        // 若key存在，返回原value值；若映key不存在，存储新value返回null
        Integer value1 = map.putIfAbsent("lisi", 12);
        System.out.println(value1); // null
        System.out.println(map); // {lisi=12, zhangsan=15}

        // default V computeIfAbsent(K key,Function<? super K, ? extends V> mappingFunction)
        // 若key存在，返回原value值；若映key不存在，存储新value返回存储的值，新value为null，则不会加入映射
        Integer value2 = map.computeIfAbsent("wangwu", k -> 16);
        System.out.println(value2); // 16
        System.out.println(map); // {lisi=12, zhangsan=15, wangwu=16}

        // default V computeIfPresent(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        // 若key存在，对key和value操作得到newValue，替换原值，newValue为null，则删除key到value的映射
        Integer value3 = map.computeIfPresent("lisi", (k, v) -> v + 5);
        System.out.println(value3); // 17
        System.out.println(map); // {lisi=17, zhangsan=15, wangwu=16}

        // default V getOrDefault(Object key, V defaultValue)
        // 若key不存在，返回默认值
        Integer value4 = map.getOrDefault("tom", 18);
        System.out.println(value4); // 18
    }
}
