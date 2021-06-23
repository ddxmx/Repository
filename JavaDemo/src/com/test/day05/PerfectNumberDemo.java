package com.test.day05;

/**
 * 输出100000内的所有完数
 * 完数，一个数等于除自身外其他约数之和
 * 例如：6=1+2+3，28=1+2+4+7+14
 * 6	28	496	8128
 */
public class PerfectNumberDemo {
    public static void main(String[] args) {
        int limit = 10_0000;
        //方式一
        {
            long startTime = System.currentTimeMillis();
            for (int i = 1; i <= limit; i++) {
                long result = 0;
                for (int j = 1; j < i; j++) { //完数不包含自身
                    //约数
                    if (i % j == 0) {
                        result += j;
                    }
                }

                if (result == i) {
                    System.out.print(i + "\t");
                }
            }
            System.out.println();
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "毫秒"); //耗时：13778毫秒
        }

        //方式二
        {
            long startTime = System.currentTimeMillis();
            for (int i = 1; i <= limit; i++) {
                long result = 0;
                //查公约数的时，只需要判断到开方即可
                double maxDivisor = Math.sqrt(i);
                for (int j = 1; j <= maxDivisor; j++) {
                    //j是i的约数，同时不等于i
                    if (i % j == 0 && i != j) {
                        result += j;
                        //能整除时，除数和商都是约数，如果除数和商相同时，只能累计一次
                        //同时商不能等于i(除数为1时，商为i)
                        int quotient = i / j;
                        if (j != quotient && i != quotient) {
                            result += quotient;
                        }
                    }
                }

                if (result == i) {
                    System.out.print(i + "\t");
                }
            }
            System.out.println();
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "毫秒"); //耗时：78毫秒
        }
    }
}
