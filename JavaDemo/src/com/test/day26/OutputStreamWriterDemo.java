package com.test.day26;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 转换流，字节流->字符流
 * OutputStreamWriter：字节输出流转换为字符输出流
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("hello.txt"), "utf-8")) {
            writer.write("hello java\n");
            writer.write("你好，世界\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
