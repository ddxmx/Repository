package com.test.io.day17.stream.convert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 转换流，字节输出流->字符输出流
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        // public OutputStreamWriter(OutputStream out, String charsetName) throws UnsupportedEncodingException
        try (FileOutputStream out = new FileOutputStream("hello.txt");
             OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8.toString())) {

            writer.write("你好，世界" + System.lineSeparator());
            writer.write("hello world");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
