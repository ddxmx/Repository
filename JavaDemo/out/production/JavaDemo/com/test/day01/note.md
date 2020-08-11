# day01

## 1、历史

sun(stanford university network) 斯坦福大学网络

James Gosling主导开发，C++基础上开发

Oak -> Java

1995.5.23  发布java

1996  JDK 1.0

1998  JDK 1.2 ，Java -> Java2

2004  JDK 1.5 -> Java SE 5.0	里程碑的版本

2014  JDK 8.0	5.0以来变化最大的版本

sun公司2009年被Oracle以74亿美元收购

## 2、Java发展方向

Java SE：桌面应用程序

Java EE：企业级开发

Java ME：嵌入式和移动式开发

## 3、Java开发方向

企业级应用

Android平台应用

大数据平台应用

## 4、Java主要特点

面向对象：封装、继承、多态

健壮性：引用代替指针，垃圾回收

跨平台性：
不同操作系统上都可以运行同一个java字节码文件，在不同操作系统上安装对应版本的JVM（Java虚拟机）。
java运行在JVM上，由JVM来适应不同的操作系统。

## 5、JDK和JRE

JDK：Java开发工具包，包含Java开发工具和JRE

JRE：Java运行时环境，包含核心类库和JVM

## 6、常用命令

java.exe	解释命令

javac.exe	编译命令

javadoc.exe 生成文档注释命令

native2ascii.exe    转义为unicode命令

## 7、环境变量

JAVA_HOME	java的安装路径

PATH（命令行执行时命令的搜索路径）
	
windows:    %JAVA_HOME%\bin; 

linux:  PATH=$JAVA_HOME/bin:$PATH

## 8、编译过程

*.java文件  ->  (javac.exe 编译)   *.class文件(字节码文件)  ->  (java.exe 执行)   

一般除了使用jar包中的类，不要配置classpath环境变量