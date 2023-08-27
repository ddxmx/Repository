package com.test.jdk5.day16.generic.basic;

/**
 * 泛型方法，是在调用方法的时候指明泛型的具体类型
 * 泛型方法和泛型类没有必然的关联，非泛型类中可以存在泛型方法
 */
public class GenericMethodDemo {
    /**
     * 使用<T>表示是一个泛型类型声明，否则编译器将认为T是一个普通类型
     * T可以出现在泛型方法的任意位置：参数类型、返回值类型
     * static方法要使用泛型能力，就必须使其成为泛型方法。
     */
    public static <T> void show(T info) {
        System.out.println(info);
    }

    public static <T> void print(T... array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        show("hello");

        // 任何数组类型可以向Object[]类型转型，Object[]中添加同一个类的不同泛型类型元素无法被检查出来，导致取出元素可能转型异常
        // 不支持泛型数组，编译错误
        // List<String>[] listArr = new ArrayList<String>[10];

        // 可变参数和泛型方法
        print(1, 2, 3);
    }
}
