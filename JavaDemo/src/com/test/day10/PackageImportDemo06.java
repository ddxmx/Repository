package com.test.day10;

import java.util.Date;
import static java.lang.Math.*;

/**
 * package语句在java文件第一行
 * 一个"."表示一层目录结构
 * 同一个包下不能存在同名java类
 *
 * import可以导入指定包下的类 import 包.类名称，导入后可以直接使用类名称，而不需要使用 包.类名称
 * import 包.*，表示导入包下的所有类，实际只有需要使用的类才被导入
 * 引入了不同包的同名类时，使用时需要明确使用 包.类名称
 * 可以使用 import static 包.类名称.方法(或通配符*) 来导入类中成员，使用是可以直接使用方法名称，前提导入的成员是static修饰的
 *
 */
public class PackageImportDemo06 {
    public static void main(String[] args) {
        Date date = new Date();
        java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis()); // 同名类需要使用完整的 包.类名称
        System.out.println(date); // Sat May 09 06:59:58 CST 2020
        System.out.println(date2); // 2020-05-09
        System.out.println(random()); //使用静态导入的Math类中的方法，0.6301675859182945
    }
}
