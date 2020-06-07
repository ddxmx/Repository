package com.test.day03;

/**
 * if(条件表达式){语句}
 * if(条件表达式){语句1} else{语句2}
 * if(条件表达式1){语句1} else if(条件表达式2){语句2} ... else{语句n}
 */
public class IfElseDemo08 {
    public static void main(String[] args) {
        String str = "hello";
        if ("hello".equals(str)) {
            System.out.println("字符串为hello");
        }
        System.out.println("*****************************");

        int score = 50; //不及格，准备补考
        if (score >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("不及格，准备补考");
        }
        System.out.println("*****************************");

        int age = 55; //中年
        //表示范围小的条件写在上面，表示范围大的条件写在下面
        if (age >= 84) {
            System.out.println("长寿");
        } else if (age >= 60) {
            System.out.println("老年");
        } else if (age >= 45) {
            System.out.println("中年");
        } else if (age >= 18) {
            System.out.println("成年人");
        } else {
            System.out.println("未成年");
        }

    }
}
