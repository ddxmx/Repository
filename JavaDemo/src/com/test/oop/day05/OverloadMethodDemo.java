package com.test.oop.day05;

/**
 * 方法重载：方法名称相同，参数的类型或个数不同
 * 重载可以发生在一个类中，也可以发生在父子类中（子类定义的方法和从父类继承的方法构成重载）
 * 重载方法调用，根据参数类型和个数确定调用哪个方法
 * 方法名称和参数列表相同，方法的返回值不同，这样的方法不是重载，方法调用时无法明确知道调用哪个方法
 * System.out.println()方法能够打印各种数据类型的数据，实际上也是重载了println方法
 */
public class OverloadMethodDemo {
    public static void main(String[] args) {
        /*
            当public int add(int x, int y) 方法被注释后
            调用add(1, 2)也能正常运行，此时实际调用的是 public double add(double x, double y)
            参数进行了自动类型提升
            匹配时先进行参数的精确匹配，无法精确匹配时，再根据自动类型提升后的结果进行匹配
            结果为：3.0
         */
        System.out.println(add(1, 2)); // 3
        System.out.println(add(10.1, 20.3)); // 30.4
        System.out.println(add(10, 20, 30)); // 60
    }

    /**
     * 以下三个方法构成重载
     */
    public static int add(int x, int y) {
        System.out.println("两个int类型求和");
        return x + y;
    }

    public static double add(double x, double y) {
        System.out.println("两个double类型求和");
        return x + y;
    }

    public static int add(int x, int y, int z) {
        System.out.println("三个int类型求和");
        return x + y + z;
    }
}
