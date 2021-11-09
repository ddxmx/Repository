package com.test.io.day26;

import java.io.*;

/**
 * 使用字节流复制文件
 */
public class FileInputOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        File srcFile = new File("/Downloads/cn_windows_10_consumer_editions_version_20h2_updated_nov_2020_x64_dvd_07bf0300.iso");
        File destFile = new File("/windows_10.iso");

        if (!srcFile.exists()) {
            throw new FileNotFoundException("源文件不存在！");
        }

        long startTime = System.currentTimeMillis();

        try (FileInputStream in = new FileInputStream(srcFile);
             FileOutputStream out = new FileOutputStream(destFile)) {
            byte[] bytes = new byte[1024 * 8];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("复制文件耗时：" + duration); // 复制文件耗时：33160
    }
}
