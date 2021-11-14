package com.test.jdk8.day24;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Lambda表达式的使用
 * 1.举例： (o1,o2) -> Integer.compare(o1,o2);
 * 2.格式：
 * -> :lambda操作符 或 箭头操作符
 * ->左边：lambda形参列表 （其实就是接口中的抽象方法的形参列表）
 * ->右边：lambda体 （其实就是重写的抽象方法的方法体）
 * 3. Lambda表达式的使用：（分为6种情况介绍）
 * ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 * ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 * 4.Lambda表达式的本质：作为函数式接口的实例
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用 @FunctionalInterface 注解，
 * 这样做可以检查它是否是一个函数式接口。
 * 6. 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 语法格式一：无参，无返回值
        Runnable runnable = () -> {
            System.out.println("hello world!");
        };
        runnable.run(); // hello world!

        // 语法格式二：Lambda 需要一个参数，但是没有返回值。
        Consumer<String> consumer = (String s) -> {
            System.out.println(s.toUpperCase());
        };
        consumer.accept("hello"); // HELLO

        // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<String> consumer2 = (s) -> {
            System.out.println(s.toUpperCase());
        };

        // 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
        Consumer<String> consumer3 = s -> {
            System.out.println(s.toUpperCase());
        };

        // 语法格式五：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
        Supplier<Integer> len = () -> "hello".length();
        System.out.println(len.get()); // 5

        // 语法格式六：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1); // -12
            System.out.println(o2); // 6
            Integer absValue1 = Integer.valueOf(Math.abs(o1.intValue()));
            Integer absValue2 = Integer.valueOf(Math.abs(o2.intValue()));
            return Math.max(absValue1, absValue2);
        };
        System.out.println(com2.compare(-12, 6)); // 12

    }
}
