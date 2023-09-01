package com.test.io.day17.stream.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流
 * 文本文件输出时，建议使用字符输出流，防止中文写入乱码的问题
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        // public FileWriter(String fileName) throws IOException
        // public FileWriter(String fileName, boolean append) throws IOException
        // public FileWriter(File file) throws IOException
        // public FileWriter(File file, boolean append) throws IOException，是否追加写
        try (FileWriter writer = new FileWriter("hello.txt")) { // 文件不存在会自动创建
            // public void write(int c) throws IOException，写单个字符
            // public void write(char cbuf[]) throws IOException，写字符数组
            // public void write(String str) throws IOException，写字符串
            writer.write("你好，中国");
            writer.write(System.lineSeparator());
            writer.write("hello China");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
