package com.test.api.day15.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger和BigDecimal
 * BigDecimal可以精确进行浮点数计算
 * 调用BigDecimal的doubleValue()方法，结果过大时将会使用科学计数法表示
 */
public class BigIntegerDecimalDemo {
    public static void main(String[] args) {
        System.out.println("========================BigInteger========================");
        // 将字符串转换为BigInteger类型
        BigInteger bigInteger = new BigInteger("123456789012345678901234567890");
        System.out.println(bigInteger); // 123456789012345678901234567890

        BigInteger b1 = new BigInteger("1234567890");
        BigInteger b2 = new BigInteger("987654321");
        // 加
        System.out.println(b1.add(b2)); // 2222222211
        // 减
        System.out.println(b1.subtract(b2)); // 246913569
        // 乘
        System.out.println(b1.multiply(b2)); // 1219326311126352690
        // 除
        System.out.println(b1.divide(b2)); // 1
        BigInteger[] divideAndRemainder = b1.divideAndRemainder(b2);
        System.out.println(divideAndRemainder[0]); // 1，商
        System.out.println(divideAndRemainder[1]); // 246913569，余数

        System.out.println("========================BigDecimal========================");
        // 浮点数运算存在误差
        System.out.println(0.1 * 0.1); // 0.010000000000000002

        // 使用BigDecimal完成精确小数运算
        BigDecimal decimal = new BigDecimal("0.1");
        // public BigDecimal multiply(BigDecimal multiplicand)
        BigDecimal value = decimal.multiply(decimal);
        System.out.println(value.doubleValue()); // 0.01

        // 四舍五入
        BigDecimal bigDecimal = new BigDecimal("2.5678");
        System.out.println(bigDecimal.doubleValue()); // 2.5678
        // public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
        BigDecimal result = bigDecimal.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result.doubleValue()); // 2.57

        // 小数比较
        BigDecimal decimal1 = new BigDecimal("12345678901234567890");
        BigDecimal decimal2 = new BigDecimal("12345678901234567891");
        System.out.println(decimal1.doubleValue()); // 1.2345678901234567E19
        System.out.println(decimal2.doubleValue()); // 1.2345678901234567E19
        // 不推荐以下方式比较数值，转换为double类型将导致精度丢失
        System.out.println(decimal1.doubleValue() == decimal2.doubleValue()); // true
        // 推荐以下方法比较数值
        System.out.println(decimal1.compareTo(decimal2) == 0); // false
    }
}
