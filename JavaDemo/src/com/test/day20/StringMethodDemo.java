package com.test.day20;

/**
 * String的常用方法
 */
public class StringMethodDemo {
    public static void main(String[] args) {
        String s1 = "helloWorld";
        System.out.println(s1.length()); //10

        //索引从0开始
        System.out.println(s1.charAt(4)); //o

        System.out.println(s1.isEmpty()); //false
        System.out.println("".isEmpty()); //true

        String s2 = "helloWorld";
        System.out.println(s2.toUpperCase()); //HELLOWORLD
        System.out.println(s2); //helloWorld
        System.out.println(s2.toLowerCase()); //helloworld

        String s3 = " hello world ";
        System.out.println("[" + s3.trim() + "]"); //[hello world]
        System.out.println("[" + s3 + "]"); //[ hello world ]

        String s4 = "HelloWorld";
        System.out.println(s1.equals(s4)); //false
        System.out.println(s1.equalsIgnoreCase(s4)); //true

        System.out.println("hello".concat("world")); //helloworld

        //字符串排序依赖此方法
        System.out.println("helloworld".compareTo("abc")); //7
        System.out.println("helloWorld".compareTo("helloworld")); //-32
        System.out.println("helloWorld".compareTo("helloWorld")); //0

        System.out.println("helloworld".substring(5)); //world
        System.out.println("helloworld".substring(0,5)); //hello
    }
}
