package com.test.io.day17.stream.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流
 * 文本文件输出时，建议使用字符输出流，防止中文写入乱码的问题
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        // 文件不存在会自动创建
        File file = new File("hello.txt");

        // public FileWriter(File file) throws IOException
        // public FileWriter(File file, boolean append) throws IOException，是否追加写
        try (FileWriter writer = new FileWriter(file)) {
            // public void write(String str) throws IOException
            writer.write("你好，中国" + System.lineSeparator());
            writer.write("hello China");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
