package com.test.juc02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

/**
 * Streams API
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //2、4、6、8、
        list.stream().filter(e -> e % 2 == 0).forEach(x -> System.out.print(x + "、"));
        System.out.println();

        //2、4、6、8、10、12、14、16、18、
        list.stream().map(e -> e * 2).forEach(x -> System.out.print(x + "、"));
        System.out.println();

        //1、2、3、4、5、
        list.stream().limit(5).forEach((x -> System.out.print(x + "、")));
        System.out.println();

        //71
        System.out.println(Arrays.asList(34, 12, 68, 54, 20, 71).stream().max((a, b) -> a - b).get());

        //12
        System.out.println(Arrays.asList(34, 12, 68, 54, 20, 71).stream().min((a, b) -> a - b).get());

        //12、20、34、54、68、71、
        Arrays.asList(34, 12, 68, 54, 20, 71).stream().sorted().forEach(x -> System.out.print(x + "、"));
        System.out.println();

        //71、68、54、34、20、12、
        Arrays.asList(34, 12, 68, 54, 20, 71).stream().sorted((a, b) -> b - a).forEach(x -> System.out.print(x + "、"));
        System.out.println();

        //9
        System.out.println(list.stream().count());

        //20、12、68、71、
        Arrays.asList(20, 12, 68, 12, 20, 71).stream().distinct().forEach(x -> System.out.print(x + "、"));
        System.out.println();

        //45
        System.out.println(list.stream().reduce((a, b) -> a + b).get());

        //5050
        System.out.println(LongStream.rangeClosed(1, 100).reduce(Long::sum).getAsLong());
    }

}
