package com.test.jdk8.day21.lambda;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * lambda是匿名内部类的简化，方法引用是lambda的简化
 * 1.使用场景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例
 * java内置的4大核心函数式接口
 * （1）函数型接口 Function<T,R>，public R apply(T t)
 * （2）消费型接口 Consumer<T>，public void accept(T t)
 * （3）供给型接口 Supplier<T>，public T get()
 * （4）断定型接口 Predicate<T>，public boolean test(T t)
 * 3. 使用格式：  类(或对象) :: 方法名
 * 4. 具体分为如下的四种情况：
 * 类型		    语法		        对应的Lambda表达式
 * （1）静态方法引用	类名::staticMethod	(args) -> 类名.staticMethod(args)
 * （2）实例方法引用	inst::instMethod	(args) -> inst.instMethod(args)
 * （3）对象方法引用	类名::instMethod	(inst,args) -> 类名.instMethod(args)
 * （4）构造方法引用	类名::new		    (args) -> new 类名(args)
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！（针对于情况1和情况2）
 */
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // 对象方法引用，(String instance)->instance.length();
        Function<String, Integer> function = String::length;
        Integer len = function.apply("hello");
        System.out.println(len); // 5

        // 实例方法引用，(String e)->System.out.println(e);
        Consumer<String> consumer = System.out::println;
        consumer.accept("test"); // test

        // 静态方法引用，()->Math.random();
        Supplier<Double> randomSupplier = Math::random;
        System.out.println(randomSupplier.get()); // 0.024196878541718037

        // 实例方法引用，(String instance)->instance.isEmpty();
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test("hello")); // false

        // 构造方法引用，()->new Date();
        Supplier<Date> dateSupplier = Date::new;
        System.out.println(dateSupplier.get()); // Sun Nov 14 09:45:27 CST 2021
    }
}
