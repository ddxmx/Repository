package com.test.io.day17;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * File类的使用
 */
public class FileDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 文件路径分隔符
        System.out.println(File.separator);
        // 系统换行符
        System.out.println(System.lineSeparator());

        // 相对路径，默认路径为user.dir，public File(String pathname)
        File file = new File("hello.txt");
        // 创建文件，public boolean createNewFile() throws IOException
        file.createNewFile();
        System.out.println(System.getProperty("user.dir")); // E:\IdeaProjects\java-basic

        // 在当前盘符的根目录下，绝对路径
        File file2 = new File(File.separator + "hello2.txt");
        file2.createNewFile();

        // 在a/b路径下，public File(String parent, String child)
        File file3 = new File("a" + File.separator + "b", "hello3.txt");
        /*
            第1次尝试创建a\b\world.txt
            第2次尝试创建a\b\world.txt
            创建a\b\world.txt成功
         */
        // 递归创建父路径，public boolean mkdirs()
        file3.getParentFile().mkdirs();
        // 先创建父路径，再创建文件
        file3.createNewFile();

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

        // 递归列出文件
        list(new File("/Downloads/App"));

        File file4 = new File(file3.getParent(), "hello4.txt");
        // 文件重命名，必须保证源文件存在，rename操作并不会改变原File对象
        // public boolean renameTo(File dest)
        file3.renameTo(file4);
        System.out.println(file3.getAbsolutePath()); // E:\IdeaProjects\java-basic\a\b\hello3.txt
        System.out.println(file3.exists()); // false
        System.out.println(file4.getAbsolutePath()); // E:\IdeaProjects\java-basic\a\b\hello4.txt

        // 文件创建需要时间
        TimeUnit.SECONDS.sleep(1);
        System.out.println(file4.exists()); // true
        System.out.println(file4.getPath()); // a\b\hello4.txt
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
    }

    /**
     * 递归列出目录和文件信息
     */
    public static void list(File file) {
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()) {
            // public File[] listFiles()
            File[] childFiles = file.listFiles();
            for (File child : childFiles) {
                list(child);
            }
        }
    }
}
