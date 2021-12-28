package com.test.api.day14;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

/**
 * String类的使用
 */
public class StringDemo {
    public static void main(String[] args) {
        String str1 = "hello"; // 字面量直接入池
        String str2 = "hello"; // 直接使用常量池中的对象
        System.out.println(str1 == str2); // true

        String str3 = str2;
        // 字符串的值一旦创建不可修改，只是修改了引用指向的堆内存地址
        str3 += " world";
        System.out.println(str3); // hello world
        System.out.println(str2); // hello

        // 空字符串
        System.out.println("[" + new String() + "]"); // []
        System.out.println("[" + "" + "]"); // []

        String str4 = "abc";
        // 在堆空间中开辟新空间
        String str5 = new String(str4);
        System.out.println(str4 == str5); // false

        Person p1 = new Person("Tom", 20);
        Person p2 = new Person("Tom", 20);
        Person p3 = new Person(new String("Tom"), 20);
        System.out.println(p1 == p2); // false
        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true，字符串直接赋值的方式，数据入常量池
        System.out.println(p1.name == p3.name); // false

        // 修改了p1的name属性指向的堆内存空间
        p1.name = "Jerry";
        System.out.println(p1.name); // Jerry
        System.out.println(p2.name); // Tom

        /*
            面试题
            使用String s = new String("abc");的方式创建对象，在内存中创建了几个对象？
            两个：一个是堆空间中new出来的abc对象，另一个是常量池中的abc对象。
         */

        System.out.println("========字符串==比较========");
        {
            String s1 = "hello";
            String s2 = "world";
            String s3 = "helloworld";
            String s4 = "hello" + "world";
            String s5 = s1 + "world";
            String s6 = s1 + s2;
            // intern()方法将对象保存在常量池中，并返回常量池的引用
            String s7 = s6.intern();
            // final值在编译期就可以确定，保存在常量池中
            final String s8 = "hello";
            String s9 = s8 + "world";

            // 字符串使用常量拼接，结果保存在常量池中；使用变量进行连接时，不会使用常量池，直接在堆内存中开辟空间
            // 都在常量池中保存
            System.out.println(s3 == s4); // true
            // s5使用变量拼接，保存在堆内存
            System.out.println(s3 == s5); // false
            // s6使用变量拼接，保存在堆内存
            System.out.println(s3 == s6); // false
            // s5和s6开辟的不同的堆内存
            System.out.println(s5 == s6); // false
            // intern()方法导致结果放入常量池中再引用，常量池中已经存在，直接引用常量池中对象
            System.out.println(s3 == s7); // true
            // 常量拼接，在常量池中保存
            System.out.println(s3 == s9); // true
        }
    }
}
