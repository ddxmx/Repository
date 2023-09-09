package com.test.jdk8.day21.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算，与CPU打交道
 * 集合关注的是数据的存储，与内存打交道
 * 2.Steam的特点
 * （1）Stream自己不会存储元素
 * （2）Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream
 * （3）Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 */
public class StreamProgrammingDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "java", "python");
        String[] arr = new String[]{"hello", "world", "java", "python"};

        System.out.println("=====================实例化Stream对象=====================");
        // Stream实例化方式一：通过集合
        // default Stream<E> stream() : 返回一个顺序流
        Stream<String> listStream = list.stream();
        // default Stream<E> parallelStream() : 返回一个并行流
        Stream<String> parallelListStream = list.parallelStream();

        // Stream实例化方式二：通过数组
        Stream<String> arrayStream = Arrays.stream(arr);

        // Steam实例化方式三：通过Stream的of()
        Stream<String> stream = Stream.of(arr);

        // Steam实例化方式四：通过Stream.iterate()创建无限流
        // public static<T > Stream < T > iterate( final T seed, final UnaryOperator<T> f)
        // 第一个参数为初始值，第二个参数为下一个数的生成规则
        Stream<Integer> steam2 = Stream.iterate(1, n -> n * 2 + 1);

        // Steam实例化方式五：通过Stream.generate()创建无序流
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream<Double> stream3 = Stream.generate(Math::random);

        System.out.println("=====================filter：过滤流中元素=====================");
        // filter(Predicate p)，从流中过滤元素
        list.stream().filter(e -> e.contains("o")).forEach(System.out::println);

        System.out.println("=====================limit：保留流中指定数量的元素=====================");
        // limit(n)，截断流，使其元素不超过给定数量
        list.stream().limit(2).forEach(System.out::println);

        System.out.println("=====================skip：抛弃流中指定数量元素=====================");
        // skip(n)，跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("=====================distinct：流中元素去重=====================");
        // distinct()，筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        Stream.of("hello", "world", "hello", "java").distinct().forEach(System.out::println);

        System.out.println("=====================map：根据函数重新生成流的元素=====================");
        // map(Function f)，接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        // map操作后自动转换为int类型Stream
        int sum = Stream.of("1", "2", "3", "4").mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

        System.out.println("=====================flatMap：根据函数重新生成流的元素=====================");
        /*
            1
            2
            3
            4
            5
            6
         */
        // flatMap(Function f)，接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream.of("1", "23", "456").flatMap(e -> {
            String[] array = new String[e.length()];
            for (int i = 0; i < e.length(); i++) {
                array[i] = String.valueOf(e.charAt(i));
            }
            return Arrays.stream(array);
        }).forEach(System.out::println);
        System.out.println();

        System.out.println("=====================sorted：排序=====================");
        // sorted()，自然排序，流中的元素需要实现Comparable接口
        list.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com)，指定排序规则
        list.stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);

        System.out.println("=====================allMatch：判断是否匹配所有元素=====================");
        // allMatch(Predicate p)，检查是否匹配所有元素
        System.out.println(list.stream().allMatch(e -> e.length() > 3)); // true
        System.out.println(list.stream().allMatch(e -> e.length() > 5)); // false

        System.out.println("=====================anyMatch：判断是否匹配其中某一个元素=====================");
        // anyMatch(Predicate p)，检查是否至少匹配一个元素。
        System.out.println(list.stream().anyMatch(e -> e.length() > 5)); // true

        System.out.println("=====================noneMatch：判断是否所有元素都不匹配=====================");
        // noneMatch(Predicate p)，检查是否没有匹配的元素。
        System.out.println(list.stream().noneMatch(e -> e.isEmpty())); // false

        System.out.println("=====================findFirst：返回流中第一个元素=====================");
        // Optional<T> findFirst()
        System.out.println(list.stream().findFirst().get()); // hello

        System.out.println("=====================findAny：返回流中任意一个元素=====================");
        // findAny，返回当前流中的任意元素，串行流每次都是第一个，并行流每次都随机
        // Optional<T> findAny()
        System.out.println(list.stream().findAny().get()); // hello
        System.out.println(list.parallelStream().findAny().get()); // java

        System.out.println("=====================count：返回流中元素个数=====================");
        // count，返回流中元素的总个数
        System.out.println(list.stream().count()); // 4

        System.out.println("=====================max：返回流中最大值=====================");
        // Optional<T> max(Comparator<? super T> comparator)
        System.out.println(list.stream().max((a, b) -> a.length() - b.length()).get()); // python

        System.out.println("=====================min：返回流中最小值=====================");
        // Optional<T> min(Comparator<? super T> comparator)
        System.out.println(list.stream().min((a, b) -> a.length() - b.length()).get()); // java

        // forEach(Consumer c)，内部迭代

        System.out.println("=====================reduce：对流中元素进行组合=====================");
        // T reduce(T identity, BinaryOperator<T> accumulator)，对流中的数据按照指定计算方式计算出一个结果
        // identity为初始值，accumulator为计算函数（初始值和流中元素）
        System.out.println(Stream.of(1, 2, 3, 4).reduce(5, Integer::sum)); // 15

        // Optional<T> reduce(BinaryOperator<T> accumulator)
        // 方法需要一个函数式接口参数，该函数式接口需要两个参数，返回一个结果(reduce中返回的结果会作为下次累加器计算的第一个参数)，也就是累加器
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).get()); // 10

        System.out.println("=====================collect：收集流中的数据=====================");
        // <R, A> R collect(Collector<? super T, A, R> collector)
        // collect(Collector c)，将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        String tempStr = list.stream().collect(Collectors.joining(","));
        System.out.println(tempStr); // hello,world,java,python

        // Stream转换为list
        List<Integer> tempList = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        System.out.println(tempList);

        // Stream转换为set
        Set<Integer> tempSet = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toSet());
        System.out.println(tempSet);

        // Stream转换为map
        // public static <T, K, U> Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,Function<? super T, ? extends U> valueMapper)
        Map<Integer, Integer> tempMap = Stream.of(1, 2, 3, 4).collect(Collectors.toMap(x -> x * 2, x -> x * x));
        System.out.println(tempMap); // {2=1, 4=4, 6=9, 8=16}

        System.out.println("=====================summaryStatistics：生成统计对象=====================");
        IntSummaryStatistics statistics = IntStream.of(11, 22, 33, 44, 55).summaryStatistics();
        System.out.println(statistics.getSum()); // 165
        System.out.println(statistics.getMax()); // 55
        System.out.println(statistics.getMin()); // 11
        System.out.println(statistics.getAverage()); // 33.0
        System.out.println(statistics.getCount()); // 5
    }
}
