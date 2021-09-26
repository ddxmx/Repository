package com.test.basic.day03;

/**
 * 位运算符
 * << >> >>> & | ^ ! ~
 * & 乘法，| 加法，^ 不进位的加法
 * 位运算不会改变原操作数
 */
public class BitOperatorDemo {
    public static void main(String[] args) {
        int num1 = 3; // 0000 0011
        int num2 = 2; // 0000 0010
        System.out.println(num1 & num2); // 0000 0010 = 2
        System.out.println(num1 | num2); // 0000 0011 = 3
        System.out.println(num1 ^ num2); // 0000 0001 = 1
        /*
            11111111_11111111_11111111_11111100 ~num1的补码
            10000000_00000000_00000000_00000100 ~num1的原码
         */
        System.out.println(~num1); // -4

        int num3 = 10; // 0000 1010
        /*
            0011
            1010
            ------------
            1001
         */
        System.out.println(3 ^ num3); // 9
        System.out.println(3 ^ num3 ^ num3); // 3，异或同一个数2次，等于本身

        /*
            00000000_00000000_00000000_00001010 num3补码
            11111111_11111111_11111111_11110101 ~num3的补码
            10000000_00000000_00000000_00001011 ~num3的原码
         */
        System.out.println(~num3); // -11
        /*
            10000000_00000000_00000000_00001011 -11原码
            11111111_11111111_11111111_11110101 -11补码
            00000000_00000000_00000000_00001010 ~-11的补码
         */
        System.out.println(~-11); // 10
        System.out.println(~(~num3)); // 10，取反2次等于本身

        /*
          左移和右移操作，不改变符号位的情况下，实际上等价于 * 2^n 或 / 2^n
        */
        int a1 = 3;
        // 左移操作等价于 * 2^n
        System.out.println(a1 << 2); // 3*(2^2)=12
        System.out.println("a1=" + a1); // a1=3
        int a2 = -3;
        System.out.println(a2 << 2); // -12

        int a3 = 9;
        // 右移操作，操作数为正数，/ 2^n
        System.out.println(a3 >> 2); // 9/(2^2)=2

        int a4 = -9;
        // 十进制转换为二进制补码形式
        System.out.println(Integer.toBinaryString(a4)); // 11111111_11111111_11111111_11110111
        // 十进制转换为二进制表示形式
        System.out.println(Integer.toString(a4, 2)); // -1001
        /*
            10 00000000 00000000 00000000 001001（-9原码）
            11 11111111_11111111_11111111_110111（-9补码）
            11111111_11111111_11111111_11111101 (-9>>2后补码)
            10000000_00000000_00000000_00000011 (-9>>2后原码)
        */
        System.out.println(a4 >> 2); // -3

        int a5 = 9;
        // 无符号右移操作，操作数为正数，/ 2^n
        System.out.println(a5 >>> 2); // 2
        int a6 = -9;
        System.out.println(a6 >>> 2); // 1073741821，负数无符号右移，高位补0

        /*
            获取一个数补码后N位的方式
            如：获取int类型数20的补码形式后4位：0001 0100
         */
        int value = 0b1111 & 20; // 获取后N位就使用N位全为1的二进制进行 按位 & 运算
        System.out.println(value);  // 4

        // 获取0~255范围内任意一个数字的十六进制补码表示
        System.out.println("**************************************");
        int number = 141;
        // 调用系统API方式获取
        System.out.println("调用Java API方式：" + Integer.toHexString(number)); // 调用Java API方式：8d

        /*
            不使用系统提供的API，自己实现方式
            数字表示为十六进制，先转换为二进制，然后四位变一位
         */
        // 取出二进制数字的低四位
        int lowerDecimal = number & 0b1111;
        String lowerHexString = lowerDecimal >= 10 ? String.valueOf((char) (lowerDecimal - 10 + 'a')) : String.valueOf(lowerDecimal);
        System.out.println("lowerHexString:" + lowerHexString); // lowerHexString:d
        // 右移四位后，高四位变成低四位
        int higherDecimal = number >>> 4 & 0b1111;
        String higherHexString = higherDecimal >= 10 ? String.valueOf((char) (higherDecimal - 10 + 'a')) : String.valueOf(higherDecimal);
        System.out.println("higherHexString:" + higherHexString); // higherHexString:8
        // 高四位和低四位连接
        System.out.println(higherHexString + lowerHexString); // 8d
    }
}
