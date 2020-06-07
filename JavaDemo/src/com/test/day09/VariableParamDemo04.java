package com.test.day09;

class VariableParam {
    public void show(int a) {
        System.out.println("int");
    }

    public void show(String str) {
        System.out.println("string");
    }

    public void show(String... str) {
        if (str.length == 0) {
            System.out.println("size=0");
            return;
        }

        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + "，");
        }
        System.out.println();
    }

//    public void show(String[] str){ // 编译错误，和可变参数的方法定义重复
//    }

    public void show(int a, String... str) {
        System.out.println("int,String...");
    }
}

/**
 * 可变参数
 * 调用方法时，方法的参数被封装为一个数组传入
 * 一个方法的可变参数只能有1个，并且可变参数需要放到方法参数列表的末尾
 */
public class VariableParamDemo04 {
    public static void main(String[] args) {
        VariableParam obj = new VariableParam();
        obj.show(1); // int
        obj.show("hello"); // string
        obj.show("hello", "world"); // hello，world，
        obj.show(); // size=0
        obj.show(new String[0]); // size=0
        obj.show(new String[]{"java", "python"}); // java，python，
        obj.show(1, "abc", "hello"); // int,String...
    }
}
