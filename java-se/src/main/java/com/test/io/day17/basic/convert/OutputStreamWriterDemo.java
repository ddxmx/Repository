package com.test.io.day17.basic.convert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 转换流，字节流->字符流
 * OutputStreamWriter：字节输出流转换为字符输出流
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        // public OutputStreamWriter(OutputStream out, String charsetName) throws UnsupportedEncodingException
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("hello.txt"),
                StandardCharsets.UTF_8.toString())) {
            writer.write("你好，世界" + System.lineSeparator());
            writer.write("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
