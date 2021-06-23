package com.test.day04;

import java.util.Scanner;

/**
 * 从键盘获取三个数字，并排序
 * Scanner类用于从键盘获取输入值
 * next()、nextInt()、nextDouble() 、nextLine()、next(String pattern)
 * <p>
 * Scanner在要求用户输入的时候，其实是在内存中创建了一段空间用于用户输入，我们输入的字母就会存入该段内存。
 * 如果输入的是非数字，当我们用sc.nextInt()调用时，就不能调用出来，因为它不是我们要调用的int类型，这时就会报输入不匹配错误。
 * 可是问题就在这儿，我们用sc.nextInt()调用没把该段内存中的东西提出来，他就会一直占用这段内存，导致我们二次输入时，就不会再要求用户输入了，他会继续试图调用该段内存数值。
 * 解决办法就是我们清空该段内存，或者把该段内存中的数值取出,所以在catch块中使用 sc.next(); 就可以解决。
 */
public class ScannerDemo {
    public static void main(String[] args) {
        int[] array = new int[3];
        System.out.println("请输入三个数字，以空格分隔");
        Scanner scanner = new Scanner(System.in);
        //判断是否需要进行比较
        for (int i = 0; i < array.length; i++) {
            if (scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
            } else {
                System.out.println("输入的第" + (i + 1) + "个值为：" + scanner.next() + "，非数字");
                //0表示正常退出，非0表示异常退出
                System.exit(1);
            }
        }

        int first = array[0];
        int second = array[1];
        int third = array[2];

        int tempMax = Math.max(first, second);
        int tempMin = Math.min(first, second);
        if (third > tempMax) {
            System.out.println(third + ">" + tempMax + ">" + tempMin);
        } else {
            if (third > tempMin) {
                System.out.println(tempMax + ">" + third + ">" + tempMin);
            } else {
                System.out.println(tempMax + ">" + tempMin + ">" + third);
            }
        }
    }
}
