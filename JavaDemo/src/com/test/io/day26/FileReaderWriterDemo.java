package com.test.io.day26;

import java.io.*;

/**
 * 使用字符流复制文件
 * 字符输入输出流只能复制纯文本文件
 * 不能复制非纯文本文件，因为在读的时候会将字节转换为字符,在转换过程中,可能找不到对应的字符,就会用?代替
 */
public class FileReaderWriterDemo {
    public static void main(String[] args) {
        File srcFile = new File("hello.txt");
        File destFile = new File("/hello.txt");

        if (!srcFile.exists()) {
            System.out.println("源文件不存在，程序退出！");
            System.exit(1);
        }

        FileReader reader = null;
        FileWriter writer = null;

        //一边读一边写的方式
        try {
            reader = new FileReader(srcFile);
            writer = new FileWriter(destFile);

            char[] chars = new char[1024];
            int len = 0;
            //每读取一个数组长度，就进行写一次
            while ((len = reader.read(chars)) != -1) {
                writer.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
