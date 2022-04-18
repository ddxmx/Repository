package com.test.basic.day03.loop;

/**
 * 如果明确的知道循环的次数，使用for循环
 * 循环四个组成部分：
 * 1、初始化语句（for循环的循环控制变量超过for循环的范围就不能再使用）
 * 2、循环条件判断
 * 3、执行循环体
 * 4、修改循环控制变量
 * 执行顺序：1、2、3、4、2、3、4、2、3、4...2
 */
public class ForDemo {
    public static void main(String[] args) {
        // 计算1到100的和
        {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            System.out.println("1+2+3+...+100=" + sum);  // 1+2+3+...+100=5050
        }

        // 计算1到100的偶数个数与总和
        {
            int sum = 0;
            int count = 0;
            for (int i = 1; i <= 100; i++) {
                // 偶数
                if (i % 2 == 0) {
                    count++;
                    sum += i;
                }
            }
            System.out.println("1~100的偶数个数为：" + count); // 1~100的偶数个数为：50
            System.out.println("1~100的偶数总和为：" + sum); // 1~100的偶数总和为：2550
        }

        /*
            for循环中每个部分都可以有多个表达式，表达式之间使用,分隔
            运行结果：
            i = 0,j = 5
            i = 1,j = 4
            i = 2,j = 3
         */
        for (int i = 0, j = 5; i < 3 && j > 0; i++, j--) {
            System.out.println("i = " + i + ",j = " + j);
        }

        for (; ; ) {
            System.out.println("死循环");
        }
    }
}
