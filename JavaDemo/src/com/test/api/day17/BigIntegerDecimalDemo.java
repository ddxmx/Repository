package com.test.api.day17;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger和BigDecimal
 */
public class BigIntegerDecimalDemo {
    public static void main(String[] args) {
        // 将字符串转换为BigInteger类型
        BigInteger bigInteger = new BigInteger("123456789012345678901234567890");
        System.out.println(bigInteger); // 123456789012345678901234567890

        BigInteger b1 = new BigInteger("30");
        BigInteger b2 = new BigInteger("4");
        System.out.println(b1.add(b2)); // 34
        System.out.println(b1.subtract(b2)); // 26
        System.out.println(b1.multiply(b2)); // 120
        System.out.println(b1.divide(b2)); // 7

        // 浮点数运算存在误差
        System.out.println(0.1 * 0.1); // 0.010000000000000002

        // 使用BigDecimal完成精确小数运算
        BigDecimal decimal = new BigDecimal("0.1");
        BigDecimal value = decimal.multiply(decimal);
        System.out.println(value.doubleValue()); // 0.01

        // 四舍五入
        BigDecimal bigDecimal = new BigDecimal("2.5678");
        System.out.println(bigDecimal.doubleValue()); // 2.5678
        BigDecimal result = bigDecimal.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result.doubleValue()); // 2.57
    }
}
