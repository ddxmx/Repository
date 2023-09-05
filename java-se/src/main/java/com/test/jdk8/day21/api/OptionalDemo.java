package com.test.jdk8.day21.api;

import java.util.Optional;

/**
 * Optional类是为了在程序中避免出现空指针异常而创建的
 */
public class OptionalDemo {
    public static void main(String[] args) {
        String str = null;

        System.out.println("===========================Optional实例化===========================");
        // 创建Optional对象，参数不允许为null
        // Optional<String> optional1 = Optional.of(str); // 运行失败

        // 创建Optional对象，参数允许为null
        Optional<String> optional2 = Optional.ofNullable(str);

        // 创建空的Optional对象，value为null
        Optional<String> optionalEmpty = Optional.empty();

        System.out.println("===========================获取Optional中value值===========================");
        // public T get()，获取Optional中的value值，值存在则返回，不存在抛出java.util.NoSuchElementException异常
        // System.out.println(optional2.get()); // 抛出异常，java.util.NoSuchElementException: No value present

        // public T orElse(T other)，如果Optional中的value值不为null，则返回value；如果值为null，则返回orElse()方法中的参数
        System.out.println(optional2.orElse("world")); // world

        Optional<String> optional3 = Optional.ofNullable("hello");
        System.out.println(optional3.get()); // hello
        System.out.println(optional3.orElse("world")); // hello

        System.out.println("===========================判断Optional中value值是否为null===========================");
        System.out.println(optional2.isPresent()); // false
        System.out.println(optional3.isPresent()); // true

        System.out.println("===========================filter方法===========================");
        // 对Optional中value值进行判断，存在且满足判断条件返回当前Optional，否则返回empty Optional
        Optional.ofNullable("123").filter(e -> e.matches("\\d+")).ifPresent(System.out::println); // 123

        System.out.println("===========================map方法===========================");
        // 对Optional中value值进行函数处理
        Optional.ofNullable("class").map(e -> e.replaceAll("s", "z")).ifPresent(System.out::println); // clazz
        // flatMap和map的区别在于map会主动封装Function返回值为Optional，而flatMap不会进行封装，直接返回Function返回值
        Optional.ofNullable("class").flatMap(e -> Optional.ofNullable(e.replaceAll("s", "z"))).ifPresent(System.out::println); // clazz

        System.out.println("===========================将null判断使用Optional改写================================");
        if (null != str) {
            System.out.println(str);
        }

        // ifPresent：如果值存在，就执行使用该值的方法调用，否则什么也不做
        Optional.ofNullable(str).ifPresent(System.out::println);
    }
}
