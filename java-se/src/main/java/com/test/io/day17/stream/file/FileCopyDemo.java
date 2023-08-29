package com.test.io.day17.stream.file;

import java.io.*;

/**
 * 使用字节流复制文件
 * 采用边读边写的方式进行复制
 */
public class FileCopyDemo {
    public static void main(String[] args) throws Exception {
        File srcFile = new File("/Downloads/App/OS/CentOS-7-x86_64-Minimal-2003.iso");
        File destFile = new File(srcFile.getParent(), "CentOS.iso");

        if (destFile.exists()) {
            destFile.delete();
        }

        // 创建目标文件目录结构
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }

        long startTime = System.currentTimeMillis();

        try (FileInputStream in = new FileInputStream(srcFile);
             FileOutputStream out = new FileOutputStream(destFile)) {
            // 一次读取的大小，建议不要超过8kb
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("复制文件耗时：" + duration); // 复制文件耗时：4734
    }
}
