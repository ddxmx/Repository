package com.test.basic.day03;

/**
 * 交换两个变量中保存的值
 */
public class SwapVarDemo {
    public static void main(String[] args) {
        // 方式一，推荐，适用于各种数据类型，结构清晰，易于阅读
        {
            int a = 10;
            int b = 20;

            int temp = a;
            a = b;
            b = temp;
            System.out.println("a=" + a + ",b=" + b); // a=20,b=10
        }

        // 方式二，只适用于数值，过程中不生成新的变量，可能会超过数据类型范围
        {
            int a = 10;
            int b = 20;

            a = a + b;
            b = a - b;
            a = a - b;
            System.out.println("a=" + a + ",b=" + b); // a=20,b=10
        }

        // 方式三，只适用于数值，但不会超过数据类型范围
        {
            int a = 10;
            int b = 20;

            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            System.out.println("a=" + a + ",b=" + b); // a=20,b=10
        }
    }
}
