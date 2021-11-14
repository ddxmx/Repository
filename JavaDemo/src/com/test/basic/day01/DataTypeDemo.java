package com.test.basic.day01;

/**
 * 变量本质就是一个内存地址，变量的修改实际上是对地址指向的内存的修改（基本数据类型）或对地址的修改（引用数据类型）
 * Java中的变量先声明再使用，格式：数据类型 变量名 = 值;
 * 变量分为成员变量和局部变量：
 * - 局部变量没有系统默认值，使用前必须手动赋值；成员变量有系统默认值
 * - 局部变量存储在栈内存中，超过作用域，变量就被销毁了；成员变量存储在堆内存中，随着对象的消失而消失
 * - 局部变量的定义位置：方法或构造器中的参数、方法中定义的变量、代码块中定义的变量；成员变量直接定义在类中
 */
public class DataTypeDemo {
    public static void main(String[] args) {
        // ==========整型==========
        // 声明变量并赋值
        int num1 = 10;
        // 修改变量的值，变量必须已经声明过
        num1 = 15;
        System.out.println(num1); // 15

        // 声明变量和赋值分开写，不推荐
        int num2;
        num2 = 20;
        System.out.println(num2); // 20

        int num3;
        // 编译报错，变量num3使用前未赋值
        // System.out.println(num3);

        // 编译报错，变量num1不能重复定义
        // int num1 = 20;

        int numA = 10;
        int numB = 4;
        // int类型 / int类型 == int类型，小数位直接舍弃
        System.out.println(numA / numB); // 2

        // int类型常量10在byte表示范围内，可以直接赋值，不需要强制转换
        byte b1 = 10;
        System.out.println(b1); // 10

        int num4 = 10;
        // byte b2 = num4; // 编译失败，int类型变量值即使在byte类型表示范围内，也无法直接赋值，需要强制转换

        // 整型默认类型int，当数值常量超过int类型表示范围时，常量必须以l或L结尾来表示长整型
        long var1 = 30_0000_0000L; // _可以分隔数字，JDK1.7新特性
        System.out.println(var1); // 3000000000

        // ==========浮点型==========
        double d1 = 0.1;
        // 二进制无法精确表示小数
        System.out.println(d1 * d1); // 0.010000000000000002
        System.out.println(d1 + d1); // 0.2，结果看起来是精确的，但是实际上只是计算的结果趋近于0.2，直接使用0.2进行表示

        // 浮点型默认类型double，定义float类型数值以f或F结尾
        float f1 = 0.1f;
        System.out.println(f1); // 0.1

        // ==========字符型==========
        // java使用unicode字符集，前128个字符和ASCII字符集一致
        // 实际开发中使用的是UTF-8，变长的Unicode编码实现
        // 0 - 48，A - 65，a - 97
        char c1 = 'a';
        System.out.println(c1); // a
        // char类型可以和整数直接进行数值运算，使用的是字符编码
        System.out.println(c1 + 10); // 107

        // 错误，char类型必须包含一个字符
        // char c2 = '';

        // 使用四位16进制表示字符
        char c3 = '\u0041';
        System.out.println(c3); // A

        char c4 = '中';
        System.out.println(c4); // 中

        // 转义字符：\\（反斜杠）、\t（制表符）、\'（单引号）、\"（双引号）、\n（换行符）
        char c5 = '\\';
        System.out.println(c5); // \

        // 使用数字给char类型赋值，表示的是char的Unicode编码
        char c6 = 98;
        System.out.println(c6); // b

        // ==========布尔型==========
        // 布尔类型只能使用true、false赋值，不能使用0、1赋值（C语言可以使用0表示false，非0表示true）
        boolean flag = true;
        if (flag) {
            System.out.println("条件满足");
        }
    }
}
