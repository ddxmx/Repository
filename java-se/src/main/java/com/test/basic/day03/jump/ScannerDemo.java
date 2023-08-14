package com.test.basic.day03.jump;

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
        int[] inputs = new int[3];
        System.out.println("请输入三个数字，以空格分隔");

        // 判断输入是否正确
        Scanner scanner = new Scanner(System.in);

        // hasNext()和nextXXX()方法将阻塞程序，等待输入
        outer:
        while (true) {
            for (int i = 0; i < inputs.length; i++) {
                if (scanner.hasNextInt()) {
                    inputs[i] = scanner.nextInt();
                } else {
                    /*
                        next():只读取输入直到空格。next()在读取输入后将光标放在同一行中。
                        nextLine():读取输入，包括单词之间的空格和除回车以外的所有符号(即读到行尾)。读取输入后，nextLine()将光标定位在下一行。
                     */
                    System.out.println("输入的第" + (i + 1) + "个值为：" + scanner.next() + "，非数字，请重新输入三个数字");
                    // 重新读取三个数字，则需要丢弃当前整行输入的内容
                    scanner.nextLine();
                    inputs = new int[inputs.length];
                    continue outer;
                }
            }

            break;
        }

        int first = inputs[0];
        int second = inputs[1];
        int third = inputs[2];

        int min = Math.min(Math.min(first, second), third);
        System.out.println("最小值为：" + min);
    }
}
