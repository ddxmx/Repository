package com.test.day05;

/**
 * 1~100的质数
 * 2、3、5、7、11、13、17、19、23、29、31、37、41、43、47、53、59、61、67、71、73、79、83、89、97、
 */
public class PrimeNumberDemo05 {
    public static void main(String[] args) {
        outer:
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            System.out.print(i + "、");
        }
    }
}
