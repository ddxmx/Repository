package com.test.exception.day16;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * throws的使用场景：当前方法中无法处理或不知道如何处理，需要返回给调用者处理
 * 2）throws
 * 一旦方法抛出异常，在异常代码处生成一个异常类对象，对象满足throws声明的异常类型，则会抛出。异常后的代码不再执行
 */
public class ThrowsDemo {
    public static void main(String[] args) {
        // 调用的方法存在异常，调用者需要处理，使用try-catch或继续抛出
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 由于调用处捕获了抛出的异常，因此程序不会被中断，继续执行
        System.out.println("hello world");
    }

    /**
     * 方法不处理异常，交给调用者处理
     */
    public static void load() throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream("test.txt");
        } finally {
            if (null != in) {
                in.close();
            }
        }
    }
}
