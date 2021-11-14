package com.test.jdk8.day24;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 * 集合关注的是数据的存储，与内存打交道
 * 2.
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * 3.Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤、映射、...)
 * ③ 终止操作
 * 4.说明：
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 */
public class StreamAPIDemo {
    public static void main(String[] args) {
        // 创建 Stream方式一：通过集合
        List<String> list = Arrays.asList("hello", "world", "java", "python");
        // default Stream<E> stream() : 返回一个顺序流
        Stream<String> listStream = list.stream();
        // default Stream<E> parallelStream() : 返回一个并行流
        Stream<String> parallelListStream = list.parallelStream();

        // 创建 Stream方式二：通过数组
        String[] arr = new String[]{"hello", "world", "java", "python"};
        Stream<String> arrayStream = Arrays.stream(arr);

        // 创建 Stream方式三：通过Stream的of()
        Stream<String> stream = Stream.of("hello", "world", "java", "python");

        // 创建 Stream方式四：创建无限流
        // 迭代
        // public static<T > Stream < T > iterate( final T seed, final UnaryOperator<T> f)
        // 遍历前10个偶数
        /*
            0
            2
            4
            6
            8
         */
        Stream.iterate(0, t -> t + 2).limit(5).forEach(System.out::println);
        System.out.println("****************************");

        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        /*
            0.07994892148112387
            0.7695790745716187
            0.9124842337810374
         */
        Stream.generate(Math::random).limit(3).forEach(System.out::println);
        System.out.println("****************************");

        // filter(Predicate p)——接收 Lambda ，从流中排除某些元素。
        /*
            hello
            world
            python
         */
        list.stream().filter(e -> e.contains("o")).forEach(System.out::println);
        System.out.println("****************************");

        // limit(n)——截断流，使其元素不超过给定数量。
        /*
            hello
            world
         */
        list.stream().limit(2).forEach(System.out::println);
        System.out.println("****************************");

        // skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        /*
            python
         */
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("****************************");

        // distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        /*
            hello
            world
            java
         */
        Stream.of("hello", "world", "hello", "java").distinct().forEach(System.out::println);
        System.out.println("****************************");

        // map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        /*
            HELLO
            WORLD
            JAVA
            PYTHON
         */
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println("****************************");

        // map操作后自动转换为int类型Stream
        int sum = Stream.of("1", "2", "3", "4").mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
        System.out.println("****************************");

        // flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        /*
            helloworldjavapython
         */
        list.stream().flatMap(e -> {
            char[] chars = e.toCharArray();
            Character[] characters = new Character[chars.length];
            for (int i = 0; i < characters.length; i++) {
                characters[i] = chars[i];
            }
            return Arrays.stream(characters);
        }).forEach(System.out::print);
        System.out.println();
        System.out.println("****************************");

        // sorted()——自然排序
        /*
            hello
            java
            python
            world
         */
        list.stream().sorted().forEach(System.out::println);
        System.out.println("****************************");

        // sorted(Comparator com)——定制排序
        /*
            world
            python
            java
            hello
         */
        list.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
        System.out.println("****************************");

        // allMatch(Predicate p)——检查是否匹配所有元素。
        boolean match1 = list.stream().allMatch(e -> e.length() > 3);
        System.out.println(match1); // true
        boolean match2 = list.stream().allMatch(e -> e.length() > 5);
        System.out.println(match2); // false

        // anyMatch(Predicate p)——检查是否至少匹配一个元素。
        boolean match3 = list.stream().anyMatch(e -> e.length() > 5);
        System.out.println(match3); // true

        // noneMatch(Predicate p)——检查是否没有匹配的元素。
        boolean match4 = list.stream().noneMatch(e -> e.isEmpty());
        System.out.println(match4); // true
        System.out.println("****************************");

        System.out.println(list);
        // findFirst——返回第一个元素
        System.out.println(list.stream().findFirst().get()); // hello

        // findAny——返回当前流中的任意元素，串行流每次都是第一个，并行流每次都随机
        System.out.println(list.stream().findAny().get()); // hello
        System.out.println(list.parallelStream().findAny().get()); // java

        //  count——返回流中元素的总个数
        System.out.println(list.stream().filter(e -> e.contains("o")).count()); // 3

        // max(Comparator c)——返回流中最大值
        System.out.println(list.stream().max((a, b) -> a.compareTo(b)).get()); // world

        // min(Comparator c)——返回流中最小值
        System.out.println(list.stream().min((a, b) -> a.compareTo(b)).get()); // hello

        // forEach(Consumer c)——内部迭代

        // reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
        // identity为初始值
        System.out.println(Stream.of(1, 2, 3, 4).reduce(5, Integer::sum)); // 15

        // reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        // 方法需要一个函数式接口参数，该函数式接口需要两个参数，返回一个结果(reduce中返回的结果会作为下次累加器计算的第一个参数)，也就是累加器
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).get()); // 10

        // collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        String value = list.stream().collect(Collectors.joining(","));
        System.out.println(value); // hello,world,java,python

        // collect(Collector<? super T, A, R> collector)-将流转换为map
        Map<Integer, Integer> map = Stream.of(1, 2, 3, 4).collect(Collectors.toMap(x -> x * 2, x -> x * x));
        System.out.println(map); // {2=1, 4=4, 6=9, 8=16}

        // 生成统计对象
        IntSummaryStatistics statistics = IntStream.of(11, 22, 33, 44, 55).summaryStatistics();
        System.out.println(statistics.getSum()); // 165
        System.out.println(statistics.getMax()); // 55
        System.out.println(statistics.getMin()); // 11
        System.out.println(statistics.getAverage()); // 33.0
        System.out.println(statistics.getCount()); // 5
    }

}
