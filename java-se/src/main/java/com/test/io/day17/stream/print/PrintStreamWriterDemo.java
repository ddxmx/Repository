package com.test.io.day17.stream.print;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 打印流
 * PrintStream，内部封装了byte操作
 * PrintWriter：内部封装了char操作，字符操作建议使用PrintWriter
 * PrintStream和PrintWriter都可以指定文件编码方式
 */
public class PrintStreamWriterDemo {
    public static void main(String[] args) throws Exception {
        PrintStream stream = new PrintStream("hello.txt", StandardCharsets.UTF_8.toString());
        stream.println("hello world");
        stream.print("你好，");
        stream.println("世界");
        stream.println("Hello java");
        stream.close();

        PrintWriter write = new PrintWriter("hello2.txt", StandardCharsets.UTF_8.toString());
        write.println("hello world");
        write.print("你好，");
        write.println("世界");
        write.println("Hello java");
        write.close();
    }
}
