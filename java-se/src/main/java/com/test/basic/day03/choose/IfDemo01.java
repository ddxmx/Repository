package com.test.basic.day03.choose;

/**
 * if语句
 * 选择结构，只会执行其中一个分支
 * (1) if(条件表达式){语句}
 * (2) if(条件表达式){语句1} else{语句2}
 * (3) if(条件表达式1){语句1} else if(条件表达式2){语句2} ... else{语句n}
 * 每一个else都隐含了之前的条件不满足
 */
public class IfDemo01 {
    public static void main(String[] args) {
        // if(条件表达式){语句}
        double balance = 10.5;
        if (balance < 19.9) {
            System.out.println("余额不足，无法购买");
        }

        // if(条件表达式){语句1} else{语句2}
        int score = 50;
        if (score >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("不及格，准备补考吧");
        }

        // if(条件表达式1){语句1} else if(条件表达式2){语句2} ... else{语句n}
        // 表示范围小的条件写在上面，表示范围大的条件写在下面
        int age = 55;
        if (age >= 84) {
            System.out.println("长寿");
        } else if (age >= 60) {
            System.out.println("老年");
        } else if (age >= 45) {
            System.out.println("中年");
        } else if (age >= 18) {
            System.out.println("青年");
        } else {
            System.out.println("未成年");
        }
    }
}
