package com.test.basic.day05;

/**
 * 不知道循环的次数，但是知道循环终止的条件，使用while循环
 * while循环控制变量，超过了while的范围，循环控制变量仍然可以使用
 * for循环和while循环可以相互转换
 * 循环结构在底层也是使用的有条件跳转和无条件跳转实现的，和if区别的是，if是向后跳转，而循环可以向前跳转
 */
public class WhileDemo {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("1+2+3+...+100=" + sum); // 1+2+3+...+100=5050

        while (true) {
            System.out.println("死循环");
        }
    }
}
