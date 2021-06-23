 # day01

dir 【列出当前目录下的文件和子目录】

mkdir 目录名 【创建目录】

cd 目录名 【进入目录】

cd .. 【返回上级目录】

cd \ 【返回当前盘符根目录】

盘符:  【切换盘符】

cd . > 文件名 【创建空文件】

del 文件名 【删除文件】

rmdir /S /Q 目录名 【递归删除整个目录，包括目录本身】

del /S /Q 目录名 【递归删除目录中的文件，只删除文件，不删除任意目录】

where 命令  【查看命令所在路径】

exit 【退出dos命令行】

## 1、历史

sun(stanford university network) 斯坦福大学网络

Green项目（电子邮件控制家电产品）

James Gosling主导开发，考虑到C++的复杂性，在C++基础上开发了Oak，后更名为java

1995.5.23  发布java

1996  JDK 1.0

1998  JDK 1.2 ，Java -> Java2

2004  JDK 1.5 -> Java SE 5.0	里程碑版本

2014  JDK 8.0	5.0以来变化最大的版本

由于2000年的全球互联网低潮的影响，sun公司2009年被Oracle以74亿美元收购

Oracle公司为什么要收购Sun公司?

| 体系     | MicroSoft  | Oracle              |
| -------- | ---------- | ------------------- |
| 操作系统 | Windows    | Unix                |
| 数据库   | SQL Server | Oracle              |
| 中间件   | IIS        | WebLogic            |
| 编程语言 | .Net       | 收购Sun公司得到Java |

## 2、Java的主要特征

- 纯粹的面向对象
- 可移植性
- 自动的垃圾回收机制（有了自动垃圾回收机制，还是会存在内存泄漏和内存溢出的问题）
- 引用传递代替指针
- 多线程

java程序都运行在java虚拟机上，java程序开发都是面向虚拟机的开发

*.java文件，编译(javac.exe)   ->   *.class字节码文件(java.exe)  ->  在虚拟机上运行   

不同操作系统上可以运行同一个java字节码文件(class文件)，只要在不同操作系统上安装对应版本的JVM（Java虚拟机）即可。
java运行在JVM上，由不同版本的JVM来适应不同的操作系统。


## 3、Java开发方向

Java SE：桌面应用程序

Java EE：企业级开发，主流方向

Java ME：嵌入式和移动式开发，被Android取代

## 4、Java应用领域

企业级应用

Android平台

大数据平台

## 5、JDK和JRE

JDK：Java开发工具包，包含Java开发工具和JRE

JRE：Java运行时环境，包含JVM和核心类库

## 6、常用命令

javac.exe	编译命令

java.exe	解释命令

javadoc.exe 生成文档注释命令

native2ascii.exe    转义为unicode编码命令

## 7、环境变量

JAVA_HOME	java的安装路径

PATH    执行命令时，命令的搜索路径

配置java环境变量：
 - windows:    %JAVA_HOME%\bin; 
 - linux:  export PATH=$JAVA_HOME/bin:$PATH