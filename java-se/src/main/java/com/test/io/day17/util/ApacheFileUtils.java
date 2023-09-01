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
        File srcFile = new File("hello.txt");
        File destFile = new File("hello_bak.txt");
        File srcDir = new File("test");
        File destDir = new File("test_bak");

        System.out.println("=========================复制文件=========================");
        // 复制文件
        FileUtils.copyFile(srcFile, destFile);

        // 复制文件到目录下
        FileUtils.copyFileToDirectory(srcFile, srcDir);

        System.out.println("=========================复制文件夹=========================");
        // 复制文件夹，直接覆盖，目标文件夹不存在时会自动创建
        FileUtils.copyDirectory(srcDir, destDir);

        // 复制文件夹，指定复制的文件类型
        FileUtils.copyDirectory(srcDir, destDir, new SuffixFileFilter(".txt"));

        // 复制文件夹到另一个文件夹下
        FileUtils.copyDirectoryToDirectory(srcDir, destDir);

        System.out.println("=========================将字符串写入文件=========================");
        // 将字符串写到文件中
        FileUtils.writeStringToFile(srcFile, "hello", StandardCharsets.UTF_8);

        // 将字符序列直接写到文件中
        FileUtils.write(srcFile, new StringBuffer("hello"), StandardCharsets.UTF_8);

        System.out.println("=========================将字节数组写入文件=========================");
        // 将字节数组写到文件中
        FileUtils.writeByteArrayToFile(srcFile, "hello".getBytes());

        System.out.println("=========================把集合元素内容写入文件=========================");
        // 将容器中的元素的toString方法返回的内容依次写入文件中，分隔符默认为系统换行符
        FileUtils.writeLines(srcFile, Arrays.asList("hello", "world"));

        // 将容器中的元素的toString方法返回的内容依次写入文件中，指定分隔符
        FileUtils.writeLines(srcFile, Arrays.asList("hello", "world"), " ");

        System.out.println("=========================读取文件内容=========================");
        // 把文件读取到字节数组
        byte[] bytes = FileUtils.readFileToByteArray(srcFile);

        // 把文件读取到字符串
        String str = FileUtils.readFileToString(srcFile, StandardCharsets.UTF_8);

        // 把文件读取到List集合
        List<String> list = FileUtils.readLines(srcFile, StandardCharsets.UTF_8);

        System.out.println("=========================文件移动=========================");
        // 移动目录
        FileUtils.moveDirectory(srcDir, destDir);

        // 移动目录到另一个目录下，目标目录不存在则创建
        FileUtils.moveDirectoryToDirectory(srcDir, destDir, true);

        // 移动文件
        FileUtils.moveFile(srcFile, destFile);

        // 移动文件到目录下，目录不存在则创建
        FileUtils.moveFileToDirectory(srcFile, srcDir, true);

        // 移动文件或目录到指定目录，目标目录不存在则创建
        FileUtils.moveToDirectory(srcDir, destDir, true);

        System.out.println("=========================创建文件夹=========================");
        // 创建文件夹(可创建多级)
        FileUtils.forceMkdir(srcDir);

        // 创建文件的父级目录
        FileUtils.forceMkdirParent(srcDir);

        System.out.println("=========================清空和删除文件=========================");
        // 清空目录，但不删除目录
        FileUtils.cleanDirectory(srcDir);

        // 删除目录及目录下所有文件
        FileUtils.deleteDirectory(srcDir);

        // 删除文件，无法删除时会抛出异常
        FileUtils.forceDelete(srcFile);

        // 删除文件，无法删除时不会抛出异常
        FileUtils.deleteQuietly(srcFile);

        System.out.println("=========================其他=========================");
        // 获取用户家目录
        FileUtils.getUserDirectory();

        // 创建文件或更新文件时间
        FileUtils.touch(srcFile);

        // 比较两个文件内容是否相同
        FileUtils.contentEquals(srcFile, destFile);

        // 递归列出目录下的文件
        // 只列出文件
        FileUtils.listFiles(srcDir, new String[]{".txt"}, true);
        // 列出文件和目录
        FileUtils.listFilesAndDirs(srcDir, null, null);

        // 每100毫秒检查1次文件是否创建成功，最长检查60秒
        FileUtils.waitFor(srcFile, 60);
    }
}
