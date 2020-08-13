package com.test.day04;

import java.util.Scanner;

/**
 * Scanner类用于从键盘获取输入值
 * next()、nextInt()、nextDouble() 、nextLine()、next(String pattern)
 * <p>
 * 扩展：
 * Scanner在要求用户输入的时候，其实是在内存中创建了一段空间用于用户输入，我们输入的字母就会存入该段内存。
 * 如果输入的是非数字，当我们用sc.nextInt()调用时，就不能调用出来，因为它不是我们要调用的int类型，这时就会报输入不匹配错误。
 * 可是问题就在这儿，我们用sc.nextInt()调用没把该段内存中的东西提出来，他就会一直占用这段内存，导致我们二次输入时，就不会再要求用户输入了，他会继续试图调用该段内存数值。
 * 所以解决办法就是我们清空该段内存，或者把该段内存中的数值取出。
 * 所以我们在catch块中使用 sc.next(); 就可以解决。
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //设置读取数据来源为键盘

        System.out.println("请输入你的兴趣");
        String hobbies = scanner.nextLine(); //读取整行，不将空格作为读取分隔符
        System.out.println("你的兴趣为：" + hobbies);

        System.out.println("请输入你的成绩");
        if (scanner.hasNextInt()) { //判断读取的内容是否是整数
            int value = scanner.nextInt();
            if (value < 0 || value > 100) {
                System.out.println("成绩输入错误");
            } else if (value == 100) {
                System.out.println("奖励一辆汽车");
            } else if (value >= 90) {
                System.out.println("奖励一个手机");
            } else if (value >= 60) {
                System.out.println("奖励一个平板");
            } else {
                System.out.println("不及格，什么也没有");
            }
        } else {
            System.out.println("成绩必须为整数");
        }
    }
}
