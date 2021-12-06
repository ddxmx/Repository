package com.test.basic.day03;

/**
 * 选择结构，只会执行其中一个分支
 * |- if(条件表达式){语句}
 * |- if(条件表达式){语句1} else{语句2}
 * |- if(条件表达式1){语句1} else if(条件表达式2){语句2} ... else{语句n}
 * 每一个else都隐含了之前的条件不满足
 * 选择结构在底层实际上通过CPU的条件跳转和无条件跳转指令实现
 */
public class IfElseDemo {
    public static void main(String[] args) {
        double balance = 10.5;
        // if(条件表达式){语句}
        if (balance < 19.9) {
            System.out.println("余额不足，无法购买");
        }

        int score = 50;
        // if(条件表达式){语句1} else{语句2}
        if (score >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("不及格，准备补考吧");
        }

        int age = 55;
        // if(条件表达式1){语句1} else if(条件表达式2){语句2} ... else{语句n}
        // 表示范围小的条件写在上面，表示范围大的条件写在下面
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
