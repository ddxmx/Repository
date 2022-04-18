package com.test.basic.day03;

import java.util.Scanner;

/**
 * 从键盘获取三个数字，找出最小的数
 * Scanner类用于从键盘获取输入值，常用方法如：next()、nextInt()、nextDouble() 、nextLine()、next(String pattern)
 * Scanner在要求用户输入的时候，其实是在内存中创建了一段空间用于用户输入，我们输入的内容就会存入该段内存。
 * 如果输入的是非数字，当我们用nextInt()调用时，就不能调用出来，因为它不是int类型，这时就会报输入不匹配错误。
 * 可是问题就在这儿，我们用nextInt()调用没把该段内存中的东西取出来，它就会一直占用这段内存，导致我们二次输入时，就不会再要求用户输入了，他会继续试图调用该段内存数值。
 * 解决办法就是我们清空该段内存，或者把该段内存中的数值取出，所以在catch块中调用next();就可以解决。
 */
public class ScannerDemo {
    public static void main(String[] args) {
        int[] numbers = new int[3];
        System.out.println("请输入三个数字，以空格分隔");
        // 判断输入是否正确
        Scanner scanner = new Scanner(System.in);

        outer:
        while (true) {
            for (int i = 0; i < numbers.length; i++) {
                if (scanner.hasNextInt()) {
                    numbers[i] = scanner.nextInt();
                } else {
                    System.out.println("输入的第" + (i + 1) + "个值为：" + scanner.next() + "，非数字，请重新输入三个数字");
                    scanner.nextLine();
                    continue outer;
                }
            }

            break;
        }

        int first = numbers[0];
        int second = numbers[1];
        int third = numbers[2];

        int min = Math.min(Math.min(first, second), third);
        System.out.println("最小值为：" + min);
    }
}
