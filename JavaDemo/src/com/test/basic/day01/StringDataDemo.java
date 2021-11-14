package com.test.basic.day01;

/**
 * String属于引用数据类型
 * 字符串连接使用符号 +
 * 任何数据类型和字符串连接，都会向字符串类型转型
 */
public class StringDataDemo {
    public static void main(String[] args) {
        // 字符串定义
        String str1 = "Hello";
        // 定义一个空的字符串
        String str2 = "";
        // String类型是引用数据类型，可以使用null赋值
        String str3 = null;

        // 字符串连接
        System.out.println("计算结果：" + 1 + 2); // 计算结果：12
        System.out.println("计算结果：" + (1 + 2)); // 计算结果：3
        // \是转义字符
        System.out.println("Hello，\"Java\""); // Hello，"Java"

        /*
            String类型和数字不能直接进行转换
            数据类型之间直接转换的情况就两种：
            |- 7种基本数据类型之间数值转换；
            |- 引用数据类型中实例类型和声明类型之间存在父子关系
        */
        // 编译不通过，虽然字符串和数字可以使用+连接，但是两者没有任何关联，无法直接转换
        // String str4 = 123;

        // 使用String类和包装类中提供的API实现字符串和数字转换
        // int -> String，调用String类中的valueOf()方法
        String str5 = String.valueOf(123);
        System.out.println(str5); // 123
        // String -> int，调用Integer类中的parseInt()方法
        int num = Integer.parseInt(str5);
        System.out.println(num); // 123
    }
}
