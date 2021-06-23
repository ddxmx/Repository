package com.test.day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * throws的使用场景：当前方法中无法处理或不知道如何处理，需要返回给调用者处理，调用者此时需要进行异常处理
 * <p>
 * 2）throws
 * 一旦方法抛出异常，在异常代码处生成一个异常类对象，对象满足throws后异常类型，则会抛出。异常后的代码不再执行。
 */
public class ThrowsDemo {
    public static void main(String[] args) {
        //调用的方法存在异常，调用者需要处理，使用try-catch捕获，或者继续抛出
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法不处理异常，交给调用者处理
     *
     * @throws IOException
     */
    public static void test() throws IOException {
        File file = new File("test.txt");
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
        } finally {
            if (null != in) {
                in.close();
            }
        }
    }
}
