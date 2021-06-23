package com.test.day05;

/**
 * 1~100000的质数
 * 2、3、5、7、11、13、17、19、23、29、31、37、41、43、47、53、59、61、67、71、73、79、83、89、97、
 */
public class PrimeNumberDemo {
    public static void main(String[] args) {
        int limit = 10_0000;
        //方式一
        {
            long startTime = System.currentTimeMillis();
            for (int i = 2; i <= limit; i++) {
                boolean flag = true; //是否是质数
                /*
                    一个数可以被除尽，则 i = a * b
                     只需要判断a是否可以被除尽即可，a在开方i的时候达到最大值
                 */
                for (int j = 2; j < i; j++) { //只能被1和其本身整除的数就是质数
                    if (i % j == 0) {
                        flag = false; //能被其他数整除，表示非质数
                        break;
                    }
                }

                if (flag) { //只打印质数
                    System.out.print(i + "、");
                }
            }
            System.out.println();
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "毫秒"); //耗时：1093毫秒
        }


        //方式二
        {
            long startTime = System.currentTimeMillis();
            outer:
            for (int i = 2; i <= limit; i++) {
                //如果能够被整除，则除数和商分别在(0,Math.sqrt(i)]和[Math.sqrt(i),i)区间内
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        continue outer;
                    }
                }
                System.out.print(i + "、");
            }
            System.out.println();
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "毫秒"); //耗时：47毫秒
        }
    }
}
