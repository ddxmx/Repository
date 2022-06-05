package com.test.jdk5.day16.generic;

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

        /*
            不支持泛型数组的原因：
            任何的数组类型都可以向Object[]转型，任何类型都可以向Object转型
            因此如下2步操作导致存在ClassCastException的可能
            Object[] arr = new ArrayList<String>[3]; // 其中的元素类型为ArrayList<String>
            arr[0] = new ArrayList<Integer>(); // 导致其中的元素类型被修改
            因为ArrayList<String>和ArrayList<Integer>类型不兼容 ，所以会出现ClassCastException
         */
        // 不支持泛型数组，编译失败
        // List<String>[] list1 = new ArrayList<String>[3];

        // 可变参数和泛型方法
        print(1, 2, 3);
    }

}
