package com.test.jdk8.day24;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda是匿名内部类的简化，方法引用是lambda的简化
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
 * 类型		    语法		        对应的Lambda表达式
 * 静态方法引用	类名::staticMethod	(args) -> 类名.staticMethod(args)
 * 实例方法引用	inst::instMethod	(args) -> inst.instMethod(args)
 * 对象方法引用	类名::instMethod	(inst,args) -> 类名.instMethod(args)
 * 构造方法引用	类名::new		    (args) -> new 类名(args)
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！（针对于情况1和情况2）
 */
public class MethodRefDemo {
    public static void main(String[] args) {
        // 对象方法引用
        Function<String, Integer> function = String::length;
        Integer len = function.apply("hello");
        System.out.println(len); // 5

        // 实例方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("test"); // test

        // 静态方法引用
        Supplier<Double> random = Math::random;
        System.out.println(random.get()); // 0.024196878541718037

        // 实例方法引用
        Predicate<String> filter = "hello world"::startsWith;
        System.out.println(filter.test("hel")); // true

        // 构造方法引用
        Supplier<Date> dateSupplier = Date::new;
        System.out.println(dateSupplier.get()); // Sun Nov 14 09:45:27 CST 2021
    }
}
