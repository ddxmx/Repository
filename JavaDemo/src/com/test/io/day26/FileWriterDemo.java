package com.test.io.day26;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流
 * 文本输出时，建议使用字符输出流，防止中文写入乱码的问题
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        //文件不存在会自动创建
        File file = new File("hello.txt");

        FileWriter writer = null;
        try {
            //写文件直接覆盖
            writer = new FileWriter(file);
            //writer = new FileWriter(file,true); //写文件追加

            writer.write("hello world\n");
            writer.write("你好，中国\n");
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
        }

    }
}
