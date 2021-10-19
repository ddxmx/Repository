package com.test.oop.day13;

/**
 * 包装类
 * java提供了8中基本数据类型的包装类，使得基本数据类型具有类的特征
 * Byte、Short、Integer、Long、Float、Double、Character、Boolean
 * 其中 Byte、Short、Integer、Long、Float、Double都是Number的子类
 */
public class WrapperDemo {
    public static void main(String[] args) {
        // 基本数据类型转换为包装类：包装类.valueOf(xxx)
        // 包装类转换为基本数据类型，包装类.xxxValue()方法
        {
            Integer i1 = Integer.valueOf(10);
            System.out.println(i1.intValue()); // 10

            // 编译通过，运行错误，java.lang.NumberFormatException: For input string: "abc"
            // Integer i2 = Integer.valueOf("abc");

            Integer i3 = Integer.valueOf("123");
            System.out.println(i3.intValue()); // 123

            Float f1 = Float.valueOf(12.5f);
            System.out.println(f1.floatValue()); // 12.5

            Boolean b1 = Boolean.valueOf(true);
            System.out.println(b1.booleanValue()); // true

            // 参数不为true/false时，直接转换为false处理
            Boolean b2 = Boolean.valueOf("hello");
            System.out.println(b2.booleanValue()); // false
        }

        System.out.println("*********************************");
        // 自动装箱和自动拆箱
        {
            // 基本数据类型直接使用包装类接收
            Integer i1 = 20;
            // 包装类直接使用基本数据类型接收
            int num2 = i1;
            System.out.println(num2); // 20

            // 包装类可以和基本数据类型直接进行运算
            System.out.println(i1 + 1); // 21
            System.out.println(i1 == 20); // true

            // 自动装箱后，基本数据类型可以直接使用Object接收，int -> integer -> Object
            Object obj = num2;
            System.out.println(obj.toString()); // 20，说明最终调用的不是object的toString()方法，而是Integer的toString()方法
        }

        System.out.println("*********************************");
        // 基本数据类型转换为String，调用String的valueOf(xxx)方法
        // String转换为基本数据类型，调用包装类的parseXXX("xxx")方法
        {
            String s1 = String.valueOf(100);
            System.out.println(s1); // 100

            Boolean b2 = Boolean.valueOf("hello");
            String s2 = String.valueOf(b2);
            System.out.println(s2); // false

            int i3 = Integer.parseInt("123");
            System.out.println(i3); // 123

            boolean b4 = Boolean.parseBoolean("True");
            System.out.println(b4); // true
        }

        System.out.println("*********************************");
        // 面试题一
        {
            // new表示每次都进行堆内存空间创建
            Integer i1 = new Integer(1);
            Integer i2 = new Integer(1);
            System.out.println(i1 == i2); // false

            // Integer中缓存了-128~127的值
            Integer i3 = 10;
            Integer i4 = 10;
            System.out.println(i3 == i4); // true

            // 超过-128~127范围的值，直接使用new方式创建
            Integer i5 = 128;
            Integer i6 = 128;
            System.out.println(i5 == i6); // false
        }
    }
}
