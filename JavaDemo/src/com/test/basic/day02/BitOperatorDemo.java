package com.test.basic.day02;

/**
 * 位运算符
 * << >> >>> & | ^ ~
 * & 乘法，| 加法，^ 不进位的加法
 * 位运算不会改变原操作数
 */
public class BitOperatorDemo {
    public static void main(String[] args) {
        System.out.println("========&、|、^、~操作========");
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
        // 取反同一个数两次，等于本身
        System.out.println(~~num1); // 3

        int num3 = 10; // 0000 1010
        // 3的补码形式 0000 0011
        System.out.println(3 ^ num3); // 9
        // 异或同一个数两次，等于本身
        System.out.println(3 ^ num3 ^ num3); // 3

        // 使用异或交换两个变量的值
        int x = 10;
        int y = 20;
        x = x ^ y;
        y = x ^ y; // 等价于：x ^ y ^ y = x
        x = x ^ y; // 等价于：x ^ y ^ x = y
        System.out.println("x=" + x + ",y=" + y); // x=20,y=10

        System.out.println("========<<、>>、>>>操作========");
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

        // 无符号右移操作，操作数为正数，/ 2^n
        int a5 = 9;
        System.out.println(a5 >>> 2); // 2
        // 负数无符号右移，高位补0
        int a6 = -9;
        System.out.println(a6 >>> 2); // 1073741821

        /*
            获取一个数补码后N位的方式
            如：获取int类型数20的补码形式后4位：0001 0100
         */
        // 获取后N位就使用N位全为1的二进制进行 按位&运算
        int value = 0b1111 & 20;
        System.out.println(value);  // 4
        // 正数两者表示形式基本一致
        System.out.println(Integer.toBinaryString(value)); // 100
        System.out.println(Integer.toString(value, 2)); // 100
    }
}
