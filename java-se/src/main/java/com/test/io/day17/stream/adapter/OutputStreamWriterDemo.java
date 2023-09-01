package com.test.io.day17.stream.adapter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 转换流，字节输出流->字符输出流
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        // public OutputStreamWriter(OutputStream out)
        // public OutputStreamWriter(OutputStream out, String charsetName) throws UnsupportedEncodingException
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("hello.txt"))) {
            writer.write("你好，世界");
            writer.write(System.lineSeparator());
            writer.write("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
