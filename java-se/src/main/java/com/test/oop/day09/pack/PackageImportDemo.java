package com.test.oop.day09.pack;

import com.test.oop.day09.pack.subpackage.SubClass;

import java.util.Date;

import static java.lang.Math.PI;
import static java.lang.Math.random;

/**
 * 常见包
 * |- java.lang----包含java语言的核心类，如String、Math、Integer、System、Thread等。
 * |- java.lang.reflect----包含java反射机制的类。
 * |- java.util----包含一些实用工具类，如定义系统特性、 集合框架类、 日期时间类。
 * |- java.text----包含了一些格式化相关的类。
 * |- java.io ----包含能提供多种输入/输出功能的类。
 * |- java.sql----包含了java进行JDBC数据库编程的相关类和接口。
 * |- java.net----包含执行与网络相关的操作的类和接口。
 */
public class PackageImportDemo {
    public static void main(String[] args) {
        // 因为已经导入了包，使用的时不再需要指定包名，直接使用类名称即可
        Date date = new Date();

        // 如果没有导入包名，则需要使用"包.类名称"的形式
        int[] array = new int[]{1, 2, 3};
        System.out.println(java.util.Arrays.toString(array)); // [1, 2, 3]

        // java.lang包默认自动导入，使用时无需手动导入包
        String str2 = "hello";

        // 当前包下的类，使用时也无需手动导入
        PackageClass packageClass = new PackageClass();

        // 当前包下的子包的类，使用时需要手动导入
        SubClass subClass = new SubClass();

        // 如果一个类中需要使用不同包中的同名类，需要使用完整的"包.类名称"
        // 和已导入的java.util.Date类同名
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

        /*
            静态导入，import static语句写到属性或方法一层（实际开发中并不推荐使用，不利于阅读）
            静态导入类中的所有方法和属性：import static java.lang.Math.*;
            静态导入类中指定的方法或属性：import static java.lang.Math.属性名或方法名;
         */
        System.out.println(PI); // 3.141592653589793
        System.out.println(random()); // 0.3514306449816549
    }
}
