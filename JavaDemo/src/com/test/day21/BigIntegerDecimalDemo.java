package com.test.day21;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger和BigDecimal
 */
public class BigIntegerDecimalDemo {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("11111111111111111111111111111");
        System.out.println(bigInteger); //11111111111111111111111111111

        //四舍五入
        BigDecimal bigDecimal = new BigDecimal("2.5678");
        System.out.println(bigDecimal.doubleValue()); //2.5678
        BigDecimal result = bigDecimal.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result.doubleValue()); //2.57
    }
}
