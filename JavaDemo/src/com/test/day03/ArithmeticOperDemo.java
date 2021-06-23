package com.test.day03;

/**
 * 算术运算符(+、-、*、/、%)
 * 在二元运算符中优先级最高
 */
public class ArithmeticOperDemo {
    public static void main(String[] args) {
        //除法
        System.out.println(14 / 4); //3
        System.out.println(14 / 4 * 4); //12
        System.out.println((double) 14 / 4); //3.5

        //取模
        System.out.println(13 % 5); //3
        System.out.println(-13 % 5); //-3
        System.out.println(13 % -5); //3
        System.out.println(-13 % -5); //-3

        //前自增，先将a1自增1，再返回a1的值
        int a1 = 10;
        int b1 = ++a1;
        System.out.printf("a1=%s,b1=%s\n", a1, b1); //a1=11,b1=11

        //后自减，先返回a2的值，再将a2自减1
        int a2 = 10;
        int b2 = a2--;
        System.out.printf("a2=%s,b2=%s\n", a2, b2); //a2=9,b2=10

        //打印三位数的各个位置上的数字
        int value = 573; // 5 * 100 + 7 * 10 + 3
        int bai = value / 100;
        int shi = value % 100 / 10;
        int ge = value % 10;
        System.out.println("百位数：" + bai);
        System.out.println("十位数：" + shi);
        System.out.println("个位数：" + ge);
    }
}
