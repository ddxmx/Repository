package com.test.io.day26;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * File类的使用
 */
public class FileDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 和module同级，相对路径
        File file = new File("hello.txt");
        // 创建文件
        file.createNewFile();

        // 在当前盘符的根目录下，绝对路径
        File file2 = new File(File.separator + "world.txt");
        file2.createNewFile();

        // 在a/b/world.txt路径下
        File file3 = new File("a" + File.separator + "b", "world.txt");
        /*
            第1次尝试创建a\b\world.txt
            第2次尝试创建a\b\world.txt
            创建a\b\world.txt成功
         */
        // 递归创建父路径
        file3.getParentFile().mkdirs();
        long maxCreateTimeOut = 3000;
        for (int i = 0; i < maxCreateTimeOut / 100; i++) {
            System.out.println("第" + (i + 1) + "次尝试创建" + file3.getPath());
            if (file3.exists()) {
                if (i != 0) {
                    System.out.println("创建" + file3.getPath() + "成功");
                }
                break;
            } else {
                file3.createNewFile();
            }
        }

        // 获取绝对路径
        System.out.println(file3.getAbsolutePath()); // e:\IdeaProjects\java-basic\a\b\world.txt

        // 获取抽象路径，会解析路径中的.和..
        System.out.println(file3.getCanonicalPath()); // e:\IdeaProjects\java-basic\a\b\world.txt

        // 获取相对路径
        System.out.println(file3.getPath()); // a\b\world.txt

        // 获取文件名
        System.out.println(file3.getName()); // world.txt

        // 获取父路径
        System.out.println(file3.getParent()); // a\b

        // 获取文件大小
        System.out.println(file3.length()); // 0

        // 获取上次修改时间
        System.out.println(file3.lastModified()); // 1624169829965

        // 递归列出文件
        list(new File("/IdeaProjects"));

        // 文件重命名，必须保证源文件存在，rename操作并不会改变原File对象
        File file4 = new File(file3.getParent(), "world2.txt");
        file3.renameTo(file4);
        System.out.println(file3.getAbsolutePath()); // E:\IdeaProjects\java-basic\a\b\world.txt
        System.out.println(file4.getAbsolutePath()); // E:\IdeaProjects\java-basic\a\b\world2.txt

        // 文件创建需要时间
        TimeUnit.SECONDS.sleep(2);
        System.out.println(file4.exists()); // true
        System.out.println(file4.getPath()); // a\b\world2.txt
        System.out.println(file4.isFile()); // true
        System.out.println(file4.isDirectory()); // false
        System.out.println(file4.canRead()); // true
        System.out.println(file4.canWrite()); // true
        System.out.println(file4.isHidden()); // false

        // 删除文件
        file4.delete();
    }

    public static void list(File file) {
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            for (File child : childFiles) {
                list(child);
            }
        }
    }
}
