package com.test.oop.day14;

/**
 * 命令行参数使用args数组接收
 * 命令行参数中存在空格，参数使用双引号，如"hello world"
 */
public class MainDemo {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }

        System.out.println("总和：" + sum);
    }
}
