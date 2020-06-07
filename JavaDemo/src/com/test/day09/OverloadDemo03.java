package com.test.day09;

class Overload {
    public void test(int a, int b) {
        System.out.println("int,int");
    }

    public void test(int a, int b, int c) {
        System.out.println("int,int,int");
    }

    public void test(int a, String b) {
        System.out.println("int,String");
    }

    public void test(String a, int b) {
        System.out.println("String,int");
    }

    public String test(String a, String b) { // 也是重载，和返回值无关，只要满足参数个数或类型不同
        return "String,String";
    }

//    public void test(int num1, int num2) { //编译报错，形参名称不同，不是重载
//        System.out.println("int,int");
//    }
}

/**
 * 方法重载
 * 方法名称相同，参数的类型或个数不同；参数类型相同，顺序不同也是重载 test(int a,String b)、test(String b,int a)
 * 方法重载和返回值类型无关，但是建议返回值类型统一
 */
public class OverloadDemo03 {
    public static void main(String[] args) {
        Overload overload = new Overload();
        overload.test(1, 2); // int,int
        overload.test(1, 2, 3); // int,int,int
        overload.test(1, "abc"); // int,String
        overload.test("abc", 1); // String,int
        System.out.println(overload.test("abc", "hello")); // String,String
    }
}
