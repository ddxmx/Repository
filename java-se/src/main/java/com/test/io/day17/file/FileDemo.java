package com.test.io.day17.file;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * File类的使用
 */
public class FileDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("========================分隔符========================");
        // 文件路径分隔符
        System.out.println(File.separator); // \
        // 系统换行符
        System.out.println("【" + System.lineSeparator() + "】");

        System.out.println("========================File实例化========================");
        // 相对路径，相对user.dir，public File(String pathname)
        File file = new File("hello.txt");
        System.out.println(System.getProperty("user.dir")); // E:\IdeaProjects\java-basic
        System.out.println(file.getAbsolutePath()); // E:\IdeaProjects\java-basic\hello.txt

        // 在当前盘符的根目录下，绝对路径
        File file2 = new File(File.separator + "hello2.txt");
        System.out.println(file2.getAbsolutePath()); // E:\hello2.txt

        // 在a/b路径下，public File(String parent, String child)
        File file3 = new File("a" + File.separator + "b", "hello3.txt");
        // 递归创建父路径，public boolean mkdirs()
        file3.getParentFile().mkdirs();
        // 创建文件，public boolean createNewFile() throws IOException
        file3.createNewFile();

        System.out.println("========================File类常用方法========================");
        // 获取绝对路径，public String getAbsolutePath()
        System.out.println(file3.getAbsolutePath()); // E:\IdeaProjects\java-basic\a\b\hello3.txt

        // 获取抽象路径，会解析路径中的.和.. public String getCanonicalPath() throws IOException
        System.out.println(file3.getCanonicalPath()); // E:\IdeaProjects\java-basic\a\b\hello3.txt

        // 获取相对路径，public String getPath()
        System.out.println(file3.getPath()); // a\b\hello3.txt

        // 获取文件名，public String getName()
        System.out.println(file3.getName()); // hello3.txt

        // 获取父路径，public String getParent()
        System.out.println(file3.getParent()); // a\b

        // 获取文件大小，public long length()
        System.out.println(file3.length()); // 0

        // 获取上次修改时间，public long lastModified()
        System.out.println(file3.lastModified()); // 1624169829965

        // 文件重命名，必须保证源文件存在，rename操作并不会改变原File对象，public boolean renameTo(File dest)
        File file4 = new File(file3.getParent(), "hello3_backup.txt");
        file3.renameTo(file4);
        System.out.println(file3.getAbsolutePath()); // E:\IdeaProjects\java-basic\a\b\hello3.txt
        System.out.println(file3.exists()); // false
        System.out.println(file4.getAbsolutePath()); // E:\IdeaProjects\java-basic\a\b\hello3_backup.txt

        // 文件创建需要时间
        TimeUnit.SECONDS.sleep(1);
        System.out.println(file4.exists()); // true

        // 获取文件属性信息
        // public boolean isFile()
        System.out.println(file4.isFile()); // true
        // public boolean isDirectory()
        System.out.println(file4.isDirectory()); // false
        // public boolean canRead()
        System.out.println(file4.canRead()); // true
        // public boolean canWrite()
        System.out.println(file4.canWrite()); // true
        // public boolean isHidden()
        System.out.println(file4.isHidden()); // false

        // 删除文件
        file4.delete();

        System.out.println("========================递归指定目录下的文件========================");
        dir(new File("/Downloads/App"));
    }

    /**
     * 递归列出目录和文件信息
     */
    public static void dir(File file) {
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
        }

        if (file.isDirectory()) {
            // public File[] listFiles()
            File[] childFiles = file.listFiles();
            for (File child : childFiles) {
                dir(child);
            }
        }
    }
}
