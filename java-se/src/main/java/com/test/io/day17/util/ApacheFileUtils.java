package com.test.io.day17.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Apache的FileUtils类扩展了java.io.File类的能力
 */
public class ApacheFileUtils {
    public static void main(String[] args) throws IOException {
        File src = new File("hello.txt");
        File dest = new File("hello_bak.txt");
        File dirSrc = new File("test");
        File dirDest = new File("test_bak");

        System.out.println("=========================复制文件夹=========================");
        // 复制文件夹，直接覆盖，目标文件夹不存在时会自动创建
        FileUtils.copyDirectory(dirSrc, dirDest);

        // 复制文件夹，指定复制的文件类型
        FileUtils.copyDirectory(dirSrc, dirDest, new SuffixFileFilter(".txt"));

        // 以子目录的形式将文件夹复制到到另一个文件夹下
        FileUtils.copyDirectoryToDirectory(dirSrc, dirDest);

        System.out.println("=========================复制文件=========================");
        // 复制文件
        FileUtils.copyFile(src, dest);

        // 将文件拷贝到某个目录下
        FileUtils.copyFileToDirectory(src, dirSrc);

        System.out.println("=========================将字符串写入文件=========================");
        // 将字符串内容写到文件中
        // public static void writeStringToFile(final File file, final String data, final Charset charset, final boolean append)
        FileUtils.writeStringToFile(src, "hello", StandardCharsets.UTF_8);

        // 将字符序列内容直接写到文件中
        // public static void write(final File file, final CharSequence data, final Charset charset, final boolean append)
        FileUtils.write(src, new StringBuffer("hello"), StandardCharsets.UTF_8);

        System.out.println("=========================将字节数组写入文件=========================");
        // 将字节数组内容写到文件中
        // public static void writeByteArrayToFile(final File file, final byte[] data, final boolean append)
        FileUtils.writeByteArrayToFile(src, "hello".getBytes());

        System.out.println("=========================把集合元素内容写入文件=========================");
        // 将容器中的元素的toString方法返回的内容依次写入文件中，换行符默认为系统换行符
        // public static void writeLines(final File file, final Collection<?> lines, final boolean append)
        FileUtils.writeLines(src, Arrays.asList("hello", "world"));

        // public static void writeLines(final File file, final Collection<?> lines, final String lineEnding, final boolean append)
        FileUtils.writeLines(src, Arrays.asList("hello", "world"), " ");

        System.out.println("=========================读取文件=========================");
        // 把文件读取到字节数组
        byte[] bytes = FileUtils.readFileToByteArray(src);

        // 把文件读取成字符串
        String str = FileUtils.readFileToString(src, StandardCharsets.UTF_8);

        // 把文件读取成字符串集合
        List<String> list = FileUtils.readLines(src, StandardCharsets.UTF_8);

        System.out.println("=========================文件移动=========================");
        // 移动目录
        FileUtils.moveDirectory(dirSrc, dirDest);

        // 移动目录，目标目录不存在则创建
        FileUtils.moveDirectoryToDirectory(dirSrc, dirDest, true);

        // 移动文件
        FileUtils.moveFile(src, dest);

        // 移动文件到目录，目录不存在则创建
        FileUtils.moveFileToDirectory(src, dirSrc, true);

        // 移动文件或目录到指定目录，目标目录不存在则创建
        FileUtils.moveToDirectory(dirSrc, dirDest, true);

        System.out.println("=========================创建文件夹=========================");
        // 创建文件夹(可创建多级)
        FileUtils.forceMkdir(dirSrc);

        // 创建文件的父级目录
        FileUtils.forceMkdirParent(dirSrc);

        System.out.println("=========================清空和删除文件夹=========================");
        // 清空目录，但不删除目录
        FileUtils.cleanDirectory(dirSrc);

        // 删除目录及目录下所有文件
        FileUtils.deleteDirectory(dirSrc);

        // 删除文件，无法删除时会抛出异常
        FileUtils.forceDelete(src);

        // 删除文件，无法删除时不会抛出异常
        FileUtils.deleteQuietly(src);

        System.out.println("=========================其他=========================");
        // 获取用户目录
        FileUtils.getUserDirectory();

        // 创建文件或更新文件时间
        FileUtils.touch(src);

        // 比较两个文件内容是否相同
        FileUtils.contentEquals(src, dest);

        // 递归列出目录下的文件
        FileUtils.listFiles(dirSrc, new String[]{".txt"}, true);
        FileUtils.listFilesAndDirs(dirSrc, null, null);

        // 每100毫秒检查1次文件是否创建成功，最长检查60秒
        FileUtils.waitFor(src, 60);
    }
}
