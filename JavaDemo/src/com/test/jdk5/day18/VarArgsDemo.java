package com.test.jdk5.day18;

/**
 * JDK 5.0支持方法可变参数
 * 可变参数在一个方法的参数列表中只能存在一个，并且只能在所有参数的末尾
 * 可变参数的方法和普通方法一样，支持重载
 */
public class VarArgsDemo {
    public static void main(String[] args) {
        System.out.println(VarArgsDemo.add(1, 2)); // 3

        // 优先精确匹配 public int add(int x, int y)
        System.out.println(VarArgsDemo.add(10, 20));

        // 可变参数传参时可以传递0个、1个和多个参数，也可以传递数组
        System.out.println(VarArgsDemo.add(100)); // 100
        System.out.println(VarArgsDemo.add(10, 20, 30)); // 60
        System.out.println(VarArgsDemo.add()); // 0
        System.out.println(VarArgsDemo.add(new int[]{11, 22, 33})); // 66
    }

    public static int add(int x, int y) {
        return x + y;
    }

    /*
        方法参数定义为可变参数，可变参数实际上使用数组接收
        因此可变参数方法不能和同名的数组类型方法构成重载
     */
    public static int add(int... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }

    /*
        编译失败，和可变参数方法重复定义
     */
    // public static int add(int[] args) {
    //     int sum = 0;
    //     for (int i = 0; i < args.length; i++) {
    //         sum += args[i];
    //     }
    //     return sum;
    // }

    // 编译错误 Vararg parameter must be the last in the list
    // public void show(int... args,String str){}

    // 编译失败 Vararg parameter must be the last in the list
    // public void show(int... args,String... strs){}
}
