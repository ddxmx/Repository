package com.test.io.day17.stream.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符缓冲输出流
 * BufferedWriter内部使用初始长度为8192的char[]作为缓冲区
 * 读取时，从文件一次性读取缓冲区长度的数据，减少文件读取次数
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {
        // public BufferedWriter(Writer out)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hello.txt"))) {
            writer.write("你好，中国");
            writer.write(System.lineSeparator());
            writer.write("hello China");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
