package com.test.jdk8.day21.api;

import java.util.Optional;

/**
 * Optional类是为了在程序中避免出现空指针异常而创建的
 */
public class OptionalDemo {
    /**
     * Optional.of(T t)：创建一个Optional实例，t必须非空；
     * Optional.ofNullable(T t)：t可以为null
     * Optional.empty()：创建一个空的Optional实例
     */
    public static void main(String[] args) {
        String str = null;

        // 运行失败，java.lang.NullPointerException，public static <T> Optional<T> of(T value)参数不允许为null
        Optional<String> optional1 = Optional.of(str);

        // public static <T> Optional<T> ofNullable(T value)，参数允许为null
        Optional<String> optional2 = Optional.ofNullable(str);

        // public T get()，获取Optional中的value值，值存在则返回，不存在抛出java.util.NoSuchElementException异常
        System.out.println(optional2.get()); // 抛出异常，java.util.NoSuchElementException: No value present
        System.out.println(optional2.orElse("world")); // world

        Optional<String> optional3 = Optional.ofNullable("hello");
        // public T orElse(T other)，如果Optional中的value值不为null，则返回value；如果值为null，则返回orElse()方法中的参数
        System.out.println(optional3.get()); // hello
        System.out.println(optional3.orElse("world")); // hello

        System.out.println("===========================将null使用Optional改写================================");
        if (null != str) {
            System.out.println(str);
        }

        // 使用Optional改写
        // ifPresent：如果值存在，就执行使用该值的方法调用，否则什么也不做
        // public void ifPresent(Consumer<? super T> consumer)
        Optional.ofNullable(str).ifPresent(System.out::println);
    }
}
