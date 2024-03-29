package com.test.basic.day02;

/**
 * 位运算符
 * << >> >>> & | ^ ~
 * &：乘法，|：加法，^：不进位的加法
 * 位运算不会改变原操作数
 */
public class BitOperatorDemo06 {
    public static void main(String[] args) {
        System.out.println("========================&、|、^、~操作========================");
        int num1 = 3; // 0000 0011
        int num2 = 2; // 0000 0010
        System.out.println(num1 & num2); // 0000 0010 = 2
        System.out.println(num1 | num2); // 0000 0011 = 3
        System.out.println(num1 ^ num2); // 0000 0001 = 1
        /*
            00000000_00000000_00000000_00000011 num1的补码
            11111111_11111111_11111111_11111100 ~num1的补码
            10000000_00000000_00000000_00000100 ~num1的原码
         */
        System.out.println(~num1); // -4
        // 取反同一个数两次，等于本身
        System.out.println(~~num1); // 3
        // 异或同一个数两次，等于本身
        System.out.println(10 ^ num1 ^ num1); // 10

        // 使用异或交换两个变量的值
        int x = 10;
        int y = 20;
        x = x ^ y;
        y = x ^ y; // 等价于：x ^ y ^ y = x
        x = x ^ y; // 等价于：x ^ y ^ x = y
        System.out.println("x=" + x + ",y=" + y); // x=20,y=10

        System.out.println("========================<<、>>、>>>操作========================");
        // 左移操作，* 2^n
        int a1 = 3;
        System.out.println(a1 << 2); // 3*(2^2)=12
        // 位运算不会改变原操作数
        System.out.println("a1=" + a1); // a1=3
        int a2 = -3;
        System.out.println(a2 << 2); // -12

        // 右移操作，操作数为正数，/ 2^n
        int a3 = 9;
        System.out.println(a3 >> 2); // 9/(2^2)=2

        // 右移操作，操作数为负数
        int a4 = -9;
        // 十进制转换为二进制补码形式
        System.out.println(Integer.toBinaryString(a4)); // 11111111_11111111_11111111_11110111
        // 十进制转换为二进制表示形式
        System.out.println(Integer.toString(a4, 2)); // -1001
        /*
            11111111_11111111_11111111_11110111（-9补码）
            11111111_11111111_11111111_11111101 (-9>>2后补码，右移高位补符号位)
            10000000_00000000_00000000_00000011 (-9>>2后原码)
        */
        System.out.println(a4 >> 2); // -3

        // 当int类型左移/右移位数大于等于32位操作时，会先取模后再进行左移/右移操作，long对应64位取模
        System.out.println(a4 >> 34); // -3

        // 无符号右移操作，操作数为正数，/ 2^n
        int a5 = 9;
        System.out.println(a5 >>> 2); // 2
        // 负数无符号右移，高位补0
        int a6 = -9;
        System.out.println(a6 >>> 2); // 1073741821

        System.out.println("========================位运算的常见操作========================");
        /*
            获取一个数补码后N位的方式
            如：获取int类型数20的补码形式后4位：0001 0100
         */
        // 获取后N位就使用N位全为1的二进制进行按位&运算
        int value = 0b1111 & 20;
        System.out.println(value); // 4

        /*
            Integer.toBinaryString(value)和Integer.toString(value, 2)的区别
            value值为正数，表示结果一致
            value值为负数，toBinaryString使用补码表示，toString直接在对应正数前添加负号"-"表示
         */
        System.out.println(Integer.toBinaryString(4)); // 100
        System.out.println(Integer.toString(4, 2)); // 100
        System.out.println(Integer.toBinaryString(-4)); // 11111111111111111111111111111100
        System.out.println(Integer.toString(-4, 2)); // -100
    }
}
