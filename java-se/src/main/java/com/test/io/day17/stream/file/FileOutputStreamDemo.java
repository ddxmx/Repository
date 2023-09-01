package com.test.io.day17.stream.file;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流
 * 输出的文件不存在时，会自动创建
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        // public FileOutputStream(String name) throws FileNotFoundException
        // public FileOutputStream(String name, boolean append) throws FileNotFoundException
        // public FileOutputStream(File file) throws FileNotFoundException
        // public FileOutputStream(File file, boolean append) throws FileNotFoundException，是否追加写
        try (FileOutputStream out = new FileOutputStream("hello.txt")) { // 文件不存在会自动创建
            // public void write(int b) throws IOException
            // public void write(byte b[]) throws IOException
            out.write("你好，中国".getBytes());
            out.write(System.lineSeparator().getBytes()); // 打印换行符
            out.write("hello China".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
