package com.test.oop.day09;

/**
 * 命令行参数使用args数组接收
 * 命令行参数中存在空格，参数时使用双引号，如 java MainDemo "hello world" hello test
 */
public class MainDemo {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            /*
                第1个参数：hello world
                第2个参数：hello
                第3个参数：test
             */
            System.out.println("第" + (i + 1) + "个参数：" + args[i]);
        }
    }
}
