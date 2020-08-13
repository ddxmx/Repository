package com.test.day05;

/**
 * 1~100的质数
 * 2、3、5、7、11、13、17、19、23、29、31、37、41、43、47、53、59、61、67、71、73、79、83、89、97、
 */
public class PrimeNumberDemo {
    public static void main(String[] args) {
        //方式一
        for (int i = 2; i <= 100; i++) {
            boolean flag = true; //是否是质数
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    flag = false; //能被其他数整除，表示非质数
                    break;
                }
            }
            if (flag) { //只打印质数
                System.out.print(i + "、");
            }
        }

        System.out.println("\n*****************************");

        //方式二
        outer:
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            System.out.print(i + "、");
        }
    }
}
