package com.test.oop.day09.api;

/**
 * 包装类
 * java提供了八种基本数据类型的包装类，使得基本数据类型具有类的特征
 * Byte、Short、Integer、Long、Float、Double、Character、Boolean
 * 其中Byte、Short、Integer、Long、Float、Double都是抽象类Number的子类
 */
public class WrapperDemo {
    public static void main(String[] args) {
        System.out.println("========基本数据类型和包装类转换========");
        {
            // 基本数据类型转换为包装类：包装类.valueOf(xxx)方法
            Integer i1 = Integer.valueOf(10);
            // 包装类转换为基本数据类型，包装类.xxxValue()方法
            int num1 = i1.intValue();
            System.out.println(num1); // 10

            // 编译通过，运行错误，java.lang.NumberFormatException: For input string: "abc"
            // Integer i2 = Integer.valueOf("abc");

            // 数值字符串转换成包装类
            Integer i3 = Integer.valueOf("123");
            System.out.println(i3.intValue()); // 123

            Float f1 = Float.valueOf(12.5f);
            System.out.println(f1.floatValue()); // 12.5

            Boolean b1 = Boolean.valueOf(true);
            System.out.println(b1.booleanValue()); // true

            // 参数不为true/false时，直接转换为false处理
            Boolean b2 = Boolean.valueOf("hello");
            System.out.println(b2.booleanValue()); // false
        }

        System.out.println("========基本数据类型和String类型转换========");
        {
            // 基本数据类型转换为String，调用String的valueOf(xxx)方法
            String s1 = String.valueOf(100);
            System.out.println(s1); // 100

            Boolean b1 = Boolean.valueOf("hello");
            // String的valueOf(xxx)方法传参是对象时，会调用对象的toString()方法
            String s2 = String.valueOf(b1);
            System.out.println(s2); // false

            // String转换为基本数据类型，调用包装类的parseXxx(xxx)方法
            int i3 = Integer.parseInt("123");
            System.out.println(i3); // 123

            // 编译通过，运行错误，java.lang.NumberFormatException: For input string: "abc"
            // int i4 = Integer.parseInt("abc");

            // 字符串转换成boolean类型，传参不区分大小写
            boolean b4 = Boolean.parseBoolean("True");
            System.out.println(b4); // true
        }

        System.out.println("========Character类的使用========");
        {
            System.out.println("---------------判断数字-----------------");
            System.out.println(Character.isDigit('a')); // false
            System.out.println(Character.isDigit('1')); // true

            System.out.println("---------------判断字母-----------------");
            System.out.println(Character.isLetter('a')); // true
            System.out.println(Character.isLetter('1')); // false
            // 使用isLetter()，中文也会认为是字母，因此不能使用该方法
            System.out.println(Character.isLetter('中')); // true

            // 判断字母推荐使用以下方式
            System.out.println(Character.isLowerCase('a') || Character.isUpperCase('a')); // true
            System.out.println(Character.isLowerCase('A') || Character.isUpperCase('A')); // true
            System.out.println(Character.isLowerCase('中') || Character.isUpperCase('中')); // false

            System.out.println("----------------判断空白符----------------");
            System.out.println(Character.isWhitespace(' ')); // true
            System.out.println(Character.isWhitespace('\t')); // true
            System.out.println(Character.isWhitespace('\n')); // true
            System.out.println(Character.isWhitespace('\r')); // true
            System.out.println(Character.isWhitespace('a')); // false
        }

        System.out.println("========自动装箱和自动拆箱========");
        {
            // 自动装箱，基本数据类型直接使用包装类接收
            Integer i1 = 20;
            // 自动拆箱，包装类直接使用基本数据类型接收
            int num2 = i1;
            System.out.println(num2); // 20

            // 包装类可以和基本数据类型直接进行运算，运算过程中进行了自动拆箱
            System.out.println(i1 + 1); // 21
            System.out.println(i1 == 20); // true

            // 自动装箱后，基本数据类型可以直接使用Object接收，int -> integer(自动装箱) -> Object(向上转型)
            Object obj = num2;
            System.out.println(obj.toString()); // 20，说明最终调用的不是Object的toString()方法，而是Integer的toString()方法
        }

        System.out.println("========Integer对象会缓存-128~127的实例========");
        {
            // new表示每次都进行堆内存空间创建
            Integer i1 = new Integer(100);
            Integer i2 = new Integer(100);
            System.out.println(i1 == i2); // false

            // Integer中缓存了-128~127的实例
            // 直接赋值的方式
            Integer i3 = 10;
            Integer i4 = 10;
            System.out.println(i3 == i4); // true

            // 调用valueOf()方法的方式
            Integer i5 = Integer.valueOf(10);
            Integer i6 = Integer.valueOf("10");
            System.out.println(i5 == i6); // true

            // 超过-128~127范围的值，内部直接使用new方式创建实例
            Integer i7 = 128;
            Integer i8 = 128;
            System.out.println(i7 == i8); // false
        }

        System.out.println("========Character对象会缓存0~127的实例========");
        {
            // Character中缓存了0~127的字符
            Character c1 = 127;
            Character c2 = 127;
            System.out.println(c1 == c2); // true

            Character c3 = 128;
            Character c4 = 128;
            System.out.println(c3 == c4); // false
        }
    }
}
