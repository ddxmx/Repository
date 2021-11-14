package com.test.jdk8.day24;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的。
 * 常用的方法：ofNullable(T t)
 * orElse(T t)
 */
public class OptionalDemo {
    /**
     * Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
     * Optional.ofNullable(T t)：t可以为null
     * Optional.empty() : 创建一个空的 Optional 实例
     */
    public static void main(String[] args) {
        String str1 = null;
        // Optional<String> optional1 = Optional.of(str1); // 运行失败，java.lang.NullPointerException

        Optional<String> optional2 = Optional.ofNullable(str1);
        // System.out.println(optional2.get()); // 运行失败，java.util.NoSuchElementException: No value present

        Optional<String> optional3 = Optional.ofNullable("hello");
        // orElse(T t1):如果当前的Optional内部封装的t是非空的，则返回内部的t.
        // 如果内部的t是空的，则返回orElse()方法中的参数t1.
        System.out.println(optional2.orElse("world")); // world
        System.out.println(optional3.orElse("world")); // hello

        str1 = "test";
        if (null != str1) {
            System.out.println(LocalDateTime.now()); // 2021-04-09T01:06:30.725
        }

        // 使用Optional改写
        // ifPresent：如果值存在，就执行使用该值的方法调用，否则什么也不做
        Optional.ofNullable(str1).ifPresent(e -> System.out.println(LocalDateTime.now())); // 2021-04-09T01:06:30.730
    }
}
