package com.test.jdk5.day16.generic.qualifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型通配符
 * 同一个类或接口的不同泛型类之间是不兼容的
 * 通配符的使用主要还是为了不同泛型类之间的引用传递
 */
public class GenericWildcardDemo {
    public static void main(String[] args) {
        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("hello"));

        // 编译错误，ArrayList<Object>和ArrayList<String>类型不兼容
        // list1 = list2;

        // 泛型通配符？就是为了解决以上的问题
        ArrayList<?> list3 = list2;
        List<?> list4 = list2;

        // 因为?是一种类型实参，String类型和?类型并不匹配，导致编译错误
        // list3.add("world");

        // 只允许加入null
        list3.add(null);

        // 任何类型都是Object的子类，所以从ArrayList<?>取出的数据也可以使用Object类型接收
        Object value = list3.get(0);
        System.out.println(value); // hello
    }
}
