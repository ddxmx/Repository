package com.test.jdk8.day21.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Lambda表达式的使用
 * 1.举例： (o1,o2) -> Integer.compare(o1,o2);
 * 2.格式：
 * -> :lambda操作符或箭头操作符
 * ->左边：lambda形参列表（其实就是接口中的抽象方法的形参列表）
 * ->右边：lambda体（其实就是重写的抽象方法的方法体）
 * 3. Lambda表达式的使用：（分为6种情况介绍）
 * ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 * ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 * 4.Lambda表达式的本质：作为函数式接口的实例
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口，接口上使用 @FunctionalInterface注解
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 语法格式一：无参，无返回值
        Runnable runnable = () -> {
            System.out.println("hello world!");
        };

        // 语法格式二：需要一个参数，但是没有返回值
        Consumer<String> consumer = (String s) -> {
            System.out.println(s.toUpperCase());
        };

        // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为类型推断
        Consumer<String> consumer2 = (s) -> {
            System.out.println(s.toUpperCase());
        };

        // 语法格式四：若只需要一个参数时，参数的小括号可以省略
        Consumer<String> consumer3 = s -> {
            System.out.println(s.toUpperCase());
        };

        // 语法格式五：当Lambda体只有一条语句时，return与大括号都可以省略
        Supplier<Double> supplier = () -> Math.random();

        // 语法格式六：需要两个或以上的参数，多条执行语句，并且可以有返回值
        BiFunction<Integer, Integer, Integer> function = (o1, o2) -> {
            Integer absValue1 = Math.abs(o1.intValue());
            Integer absValue2 = Math.abs(o2.intValue());
            return absValue1 - absValue2;
        };
        System.out.println(function.apply(-10, 6)); // 4
    }
}
