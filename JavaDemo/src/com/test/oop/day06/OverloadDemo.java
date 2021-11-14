package com.test.oop.day06;

/**
 * 方法重载：方法名称相同，参数的类型或个数不同
 * 重载可以发生在一个类中，也可以发生在父子类中（子类定义的方法和从父类继承的方法构成重载）
 * 重载方法调用，根据参数类型和个数确定调用哪个方法
 * 方法名称和参数相同，方法的返回值不同，这样的方法不是重载，因为方法调用时无法明确知道调用哪个方法
 */
public class OverloadDemo {
    public static void main(String[] args) {
        OverloadDemo demo = new OverloadDemo();
        System.out.println(demo.add(1, 2)); // 3
        System.out.println(demo.add(10.1, 20.3)); // 30.4
        System.out.println(demo.add(10, 20, 30)); // 60
        /*
            当public int add(int x, int y) 方法被注释后
            调用add(1, 2)也能正常运行，此时实际调用的是 public double add(double x, double y)
            参数进行了自动类型提升
            匹配时先进行参数的精确匹配，无法精确匹配时，再根据自动类型提升后的结果进行匹配
         */
        System.out.println(demo.add(1, 2)); // 3.0，有小数点也表明了实际返回的是double类型
    }

    /*
        以下三个方法构成重载
     */
    public int add(int x, int y) {
        System.out.println("两个int类型求和");
        return x + y;
    }

    public double add(double x, double y) {
        System.out.println("两个double类型求和");
        return x + y;
    }

    public int add(int x, int y, int z) {
        System.out.println("三个int类型求和");
        return x + y + z;
    }

    // 面试题
    {
        int[] a = new int[]{1, 2, 3};
        // 实际调用的是  public void println(Object x)
        System.out.println(a); // [I@1b6d3586

        char[] b = new char[]{'a', 'b', 'c'};
        // 实际调用的是  public void println(char x[])
        System.out.println(b); // abc
    }
}
