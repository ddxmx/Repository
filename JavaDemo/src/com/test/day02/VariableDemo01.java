package com.test.day02;

/**
 * 变量就是内存中的一块存储区域
 * Java中的变量先声明再使用
 * 变量分为成员变量和局部变量：成员变量有系统默认值，局部变量没有系统默认值，需要手动赋值
 * 局部变量存储在栈内存中，超过作用域变量就被销毁了
 */
public class VariableDemo01 {
    public static void main(String[] args) {
        int num1 = 10;
        System.out.println(num1);

        //不推荐分开写
        int num2;
        num2 = 20;
        System.out.println(num2);

        byte b1 = 10;
        System.out.println(b1);

        //整型默认类型int，已经超过int表示范围
        //_可以分隔数字，JDK1.7新特性
        long var1 = 30_0000_0000L;
        System.out.println(var1); //3000000000

        double d1 = 0.1;
        //二进制无法精确表示小数
        System.out.println(d1 * d1); //0.010000000000000002

        // 浮点型默认类型double
        float f1 = 0.1f;
        System.out.println(f1);

        // java使用unicode字符集，前128个字符和ascii字符集一致
        // 实际开发中使用的是UTF-8，变长的Unicode编码实现
        // 0 - 48，A - 65，a - 97
        char c1 = 'a';
        System.out.println(c1);

//        char c2 = '';  //错误方式，单引号中必须要有值，如果是空应该用转义字符

        char c3 = '\u0041';
        System.out.println(c3); // A

        char c4 = '中';
        System.out.println(c4);

        char c5 = '\\';
        System.out.println(c5); // \

        // 布尔类型只能使用true、false赋值，不能使用0、1赋值
        boolean flag = true;
        if(flag){
            System.out.println("条件满足");
        }

        int i6 = 10;
        //编译不通过，虽然字符串和数字可以连接，但是两者没有任何关联，无法直接转换
        //直接转换的情况就两种：7种基本数据类型间数值转换；引用类型间存在父子关系的
//        String str = i6;

        System.out.println("Hello，\"Java\""); // Hello，"Java"
    }
}
