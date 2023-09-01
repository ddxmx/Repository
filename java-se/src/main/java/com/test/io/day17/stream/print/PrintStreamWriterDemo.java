package com.test.io.day17.stream.print;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 打印流
 * PrintStream，最终转换为BufferedWriter处理
 * PrintWriter：最终转换为BufferedWriter处理
 * PrintStream和PrintWriter都可以指定文件编码方式
 */
public class PrintStreamWriterDemo {
    public static void main(String[] args) throws Exception {
        // 只要流操作涉及字符的写入，都涉及编码问题，都需要指定编码
        // public PrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException
        try (PrintStream stream = new PrintStream("hello.txt", StandardCharsets.UTF_8.toString())) {
            stream.println("hello world");
            stream.print("你好，");
            stream.println("世界");
            stream.println("Hello java");
        }

        // public PrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException
        try (PrintWriter write = new PrintWriter("hello2.txt", StandardCharsets.UTF_8.toString())) {
            write.println("hello world");
            write.print("你好，");
            write.println("世界");
            write.println("Hello java");
        }
    }
}
