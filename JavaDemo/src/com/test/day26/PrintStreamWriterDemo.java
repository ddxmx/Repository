package com.test.day26;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 打印流
 * PrintStream，内部封装了byte操作
 * PrintWriter：内部封装了char操作，是对PrintStream的优化，增加了输出文件字符编码的设置，建议使用PrintWriter代替PrintStream
 */
public class PrintStreamWriterDemo {
    public static void main(String[] args) throws Exception {
        PrintStream stream = new PrintStream(new FileOutputStream("hello.txt"));
        stream.println("hello world");
        stream.print("你好，");
        stream.println("世界");
        stream.println("Hello java");
        stream.close();

        PrintWriter write = new PrintWriter(new File("hello.txt"), "gbk");
        write.println("hello world");
        write.print("你好，");
        write.println("世界");
        write.println("Hello java");
        write.close();
    }
}
