package com.test.io.day17.bytes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流
 * 输出的文件不存在时，会自动创建
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("hello.txt");

        /*
            文件不能被创建时，将抛出异常
            public FileOutputStream(File file) throws FileNotFoundException
            public FileOutputStream(File file, boolean append) throws FileNotFoundException
         */
        try (FileOutputStream out = new FileOutputStream(file)) {
            // public void write(byte b[]) throws IOException
            out.write(("你好，中国" + System.lineSeparator()).getBytes());
            out.write("hello China".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
