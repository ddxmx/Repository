package com.test.juc02;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Function<String, Integer> function = x -> x.length();
        System.out.println(function.apply("hello world")); // 11

        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world"); // hello world

        Supplier<Long> supplier = () -> System.currentTimeMillis();
        System.out.println(supplier.get()); // 1590926677798

        Predicate<String> predicate = x -> x.contains("hello");
        System.out.println(predicate.test("hello world")); // true
    }
}
