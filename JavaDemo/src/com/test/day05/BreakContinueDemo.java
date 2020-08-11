package com.test.day05;

/**
 * 场景：
 * break
 * switch语句：用于结束switch语句
 * 循环：用于终止所在循环
 *
 * continue
 * 循环：用于结束当次所在循环
 *
 * break或continue范围后不能有语句，语句无法被执行到
 */
public class BreakContinueDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                break;
                //System.out.println("hello");  //编译错误，无法被执行到
            }
            System.out.println(i);
        }

        System.out.println("****************************");

        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }
    }
}
