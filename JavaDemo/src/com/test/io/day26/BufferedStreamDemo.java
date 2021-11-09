package com.test.io.day26;

import java.io.*;

/**
 * 缓冲流，对输入输出流进行了封装，提高流的读写速度，因为减少了文件的读取次数，减少了io操作文件的次数。
 * 举个例子，copyFile的操作中，我们的写法是，在while中，读一次byte[]，立即写入到文件中。
 * 但是用BufferedInputStream，就可以将多次读取到的数据，先放进缓冲中，也就是内存中，当缓冲达到设置的大小时，就会写入到文件一次。
 * 这样就减少了写入文件的次数，提高了速度。
 * 如果使用缓冲流，没有close，有可能造成部分数据的丢失
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader：增加了readLine方法，可以整行读取
 * BufferedWriter
 */
public class BufferedStreamDemo {
    public static void main(String[] args) {
        File srcFile = new File("/Downloads/cn_windows_10_consumer_editions_version_20h2_updated_nov_2020_x64_dvd_07bf0300.iso");
        File destFile = new File("/windows_10.iso");

        if (srcFile.exists()) {
            if (destFile.exists()) {
                destFile.delete();
            }

            long startTime = System.currentTimeMillis();

            // 关闭外层流时，会自动关闭内层流
            /*
                BufferedInputStream缓冲区默认大小8192;
                可以使用public BufferedInputStream(InputStream in, int size)手动指定缓冲区大小
             */
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFile));
                 BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destFile))) {
                // 这边并不是定义缓冲区的大小，这个是一次从输入流中读取的最大大小
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = in.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            long duration = System.currentTimeMillis() - startTime;
            System.out.println("复制文件耗时：" + duration); // 复制文件耗时：34007
        }
    }
}
