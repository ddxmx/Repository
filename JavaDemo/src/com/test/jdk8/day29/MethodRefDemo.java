package com.test.jdk8.day29;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java内置的4大核心函数式接口
 * 函数型接口 Function<T,R>   R apply(T t)
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 断定型接口 Predicate<T>    boolean test(T t)
 * <p>
 * 方法引用的使用
 * 1.使用场景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例。
 * 3. 使用格式：  类(或对象) :: 方法名
 * 4. 具体分为如下的四种情况：
 * 情况1     对象 :: 非静态方法
 * 情况2     类 :: 静态方法
 * 情况3     类 :: 非静态方法
 * 情况3      类 :: new
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！（针对于情况1和情况2）
 */
public class MethodRefDemo {
    public static void main(String[] args) {
        Function<String, Integer> function = String::length;
        Integer len = function.apply("hello");
        System.out.println(len); // 5

        Consumer<String> consumer = System.out::println;
        consumer.accept("test"); // test

        Supplier<Double> random = Math::random;
        System.out.println(random.get()); // 0.024196878541718037

        Predicate<String> filter = "hello world"::startsWith;
        System.out.println(filter.test("hel")); // true

        // 返回一个实例化对象
        Supplier<Date> dateSupplier = Date::new;
    }
}
