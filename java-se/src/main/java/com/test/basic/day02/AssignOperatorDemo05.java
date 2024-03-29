package com.test.basic.day02;

/**
 * 赋值运算符(赋值：= 等于：==)
 * 在二元运算符中，赋值运算符优先级最低
 * 对于基本数据类型来说，赋值操作实际是拷贝了一份变量保存的值后再进行赋值操作，因此原数据修改并不会影响赋值后的变量
 */
public class AssignOperatorDemo05 {
    public static void main(String[] args) {
        int i1 = 10;
        int i2 = i1;
        System.out.println(i2); // 10
        // 修改i1的值不会影响i2
        i1 = 15;
        System.out.println("i1=" + i1 + ",i2=" + i2); // i1=15,i2=10

        int i3, i4;
        // 支持连续赋值
        i3 = i4 = 20;
        System.out.println("i3=" + i3 + ",i4=" + i4); // i3=20,i4=20

        short s1 = 10;
        // 等价于 s1 = (short)(s1 + 1)
        s1 += 1;
        System.out.println(s1); // 11

        // 使用如 += 的赋值运算符，当操作数类型不一致时，将自动进行类型转换
        int num = 10;
        num += 3.5;
        System.out.println(num); // 13

        // +1的不同实现方式
        int i5 = 5;
        // 方式一
        i5++;
        System.out.println(i5); // 6
        // 方式二
        i5 = i5 + 1;
        System.out.println(i5); // 7
        // 方式三
        i5 += 1;
        System.out.println(i5); // 8

        // 开发中要避免写复杂的表达式，表达式要清晰简单
        int value = 10;
        value += (value++) + (++value); // value = value + (value++) + (++value) = 10 + 10 + 12
        System.out.println(value); // 32
    }
}
