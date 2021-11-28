# Linux

## 一、基础操作

### 1、退出命令行

exit、logout、ctrl + d

### 2、命令提示符由PS1变量控制

可以通过在/etc/profile中添加PS1变量定义来设置全局的命令提示符，/etc/bashrc文件中对PS1变量也进行了定义

export PS1='[\u@\H \w]\$ '

### 3、常用快捷键

ctrl + a	光标到行首

ctrl + e	光标到行尾

ctrl + u	删除行首到光标位置

ctrl + k	删除光标位置到行尾

ctrl + w	删除光标位置前的一个单词

ctrl + l	清屏

ctrl + z	暂停终端运行的程序

Esc + .	获取上一条命令最后的部分

### 4、man的用法

**man ls	man命令用于查询外置命令的帮助文档**

外置命令通常可以使用 --help的参数查看简略帮助信息，ls --help

ctrl + f 	往下翻一页

ctrl + b	往上翻一页

ctrl + d	往下翻半页

ctrl + u	往上翻半页

home	首页

end		末页

/			向下搜索

?			向上搜索

n(N)		按照搜索方向（反方向）查找下一个

q			退出

### 5、help命令

help命令用于查询内置命令的帮助信息

help cd

### 6、关机、重启

shutdown -r now	立即重启

shutdown -h now	立即关机

shutdown -h +1		1分钟后关机

shutdown -h 10:30	10:30关机

shutdown -c				取消关机计划

## 二、文件和目录

### 1、pwd

 -P	查看当前路径的物理路径，可以查看软链接的原始路径

**cd -的方式可以回到上次的路径，原因是环境变量中存在OLDPWD和PWD两个变量用于记录上次路径和当前路径。**

```shell
[root@promote.cache-dns.local ~]# ln -s /var/log log
[root@promote.cache-dns.local ~]# ll
total 4
lrwxrwxrwx. 1 root root    8 Sep 22 23:36 log -> /var/log
[root@promote.cache-dns.local ~/log]# pwd
/root/log
[root@promote.cache-dns.local ~/log]# pwd -P
/var/log
```

### 2、cd

cd ..	切换到父路径

cd -	切换到上次的路径

cd		等价于 cd ~	，切换到家路径

### 3、tree

-a	显示所有文件，包括隐藏文件

-f	显示全路径

-L level	遍历目录层级

-F	和ls的-F参数一致，标记文件类型

~~~shell
[scott@localhost.localdomain ~]$ tree -f
.
├── ./a
│   └── ./a/test1.txt
├── ./b
│   └── ./b/test2.txt
├── ./empty.txt
├── ./hello.txt
├── ./math.sh
└── ./test.sh

2 directories, 6 files
[scott@localhost.localdomain ~]$ tree a
a
└── test1.txt

0 directories, 1 fil
~~~

### 4、mkdir

mkdir -p a/b/c	递归创建多级目录

**{}的扩展**

```shell
[root@promote.cache-dns.local ~]# echo a{b,c}
ab ac
[root@promote.cache-dns.local ~]# echo a{,c}
a ac
[root@promote.cache-dns.local ~]# echo 2020-{1..12}-1
2020-1-1 2020-2-1 2020-3-1 2020-4-1 2020-5-1 2020-6-1 2020-7-1 2020-8-1 2020-9-1 2020-10-1 2020-11-1 2020-12-1
```

### 5、touch

作用：

* 创建一个空文件

- 刷新文件的时间戳

### 6、ls

-l	长格式显示文件及目录

-a	显示隐藏文件

-r	依相反次序排序

-i	显示文件或目录inode节点

-d	列出目录本身信息

-h	按照人类便于阅读的方式显示信息

-A	显示所有文件，包含隐藏文件，不包含. 和 ..

-R	递归列出子目录

--time=atime	显示访问时间替代默认的最后修改时间

--time=ctime	显示状态改变时间替代默认的最后修改时间

--full-time	显示完整的时间

-F	使用标记标识不同类型文件，/ 是目录，@ 是链接文件，* 是可执行文件

-t	根据修改时间排序

```shell
# 查看所有的别名
alias 
alias ll='ls -l --color=auto'
```

```shell
#inode节点编号 文件类型 权限 硬链接个数 文件或目录属主 文件或目录所属组 大小 最后修改时间 文件或目录名
[root@promote.cache-dns.local ~/abc]# ls -lhi
total 0
33574983 -rw-r--r--. 1 root root  0 Sep 23 19:42 aa
33575019 drwxr-xr-x. 2 root root 16 Sep 23 19:43 bb
```

### 7、cp

cp 源文件 目标文件

-r	递归复制

-a	复制时保留源文件属性，复制符号链接本身，递归复制

-t	cp 源文件 目标文件，-t参数可以替换参数位置	cp -t 目标文件 源文件

-i	覆盖文件前询问，root用户的cp命令是别名：alias cp='cp -i'

```shell
[root@promote.cache-dns.local ~/abc]# ll
total 0
-rw-r--r--. 1 root root  0 Sep 23 19:42 aa
-rw-r--r--. 1 root root  0 Sep 23 22:43 cc
[root@promote.cache-dns.local ~/abc]# cp aa cc
cp: overwrite ‘cc’? y
#使用\表示使用原始命令
[root@promote.cache-dns.local ~/abc]# \cp aa cc
```

cp路径中存在重复时，简化操作

```shell
[root@promote.cache-dns.local ~/abc]# cp /root/abc/aa /root/abc/cc
[root@promote.cache-dns.local ~/abc]# cp /root/abc/{aa,cc}
[root@promote.cache-dns.local ~/abc]# cp /root/abc/aa{,.bak}
[root@promote.cache-dns.local ~/abc]# ll
total 0
-rw-r--r--. 1 root root  0 Sep 23 19:42 aa
-rw-r--r--. 1 root root  0 Sep 23 22:47 aa.bak
-rw-r--r--. 1 root root  0 Sep 23 22:46 cc
```

### 8、mv

mv 源文件 目标路径（目录或文件） 

-f	目标文件存在，强制覆盖

-i 	覆盖文件前询问，root用户mv命令是别名：alias mv='mv -i'

-t	类似cp命令中的 -t 参数，调换参数位置

| 源文件             | 目标文件 | 结果                    |
| ------------------ | -------- | :---------------------- |
| 一个文件A          | 目录B    | A移动到目录B中          |
| 多个文件A1、A2、A3 | 目录B    | A1、A2、A3移动到目录B中 |
| 一个文件A          | 文件B    | A重命名为B              |
| 多个文件A1、A2、A3 | 文件B    | 命令错误                |
| 一个目录D          | 目录B    | D重命名为B              |
| 多个目录D1、D2、D3 | 目录B    | D1、D2、D3移动到目录B   |

### 9、rm

rm可以删除文件和目录，已经替代了删除空目录的命令 rmdir

-f	强制删除，不询问

-i	删除前询问，root用户rm命令是别名：alias rm='rm -i'

-r	递归删除

删除文件时不要携带 -r参数，很危险而且没有必要

### 10、ln

ln  -s 源文件 目标文件	创建软链接

ln   源文件 目标文件	创建硬链接

```shell
[root@promote.cache-dns.local ~/abc/bb]# ln cc c1
[root@promote.cache-dns.local ~/abc/bb]# ln -s cc c2
[root@promote.cache-dns.local ~/abc/bb]# ls -lhi
total 0
33575020 -rw-r--r--. 2 root root 0 Sep 23 22:42 c1
33575027 lrwxrwxrwx. 1 root root 2 Sep 23 23:09 c2 -> cc
33575020 -rw-r--r--. 2 root root 0 Sep 23 22:42 cc
```

硬链接的inode节点和源文件一致，表示指向同一块空间，硬链接只能作用在文件上，且不能跨分区。实际上是对源文件做了备份，会同步修改。只要硬链接的个数不为0，则源文件就不会被真正删除。

软连接的inode节点和源文件不同，类似于windows中的快捷方式，权限全部为rwx，并不是实际源文件的权限。软链接类似于一个文本文件，里面存放源文件路径。删除源文件将导致软链接无法正常使用。

删除软链接可以使用"rm -rf 软链接名"的方式，但是要注意软链接名后不可以有"/"，存在"/"将导致软链接中的文件被全部删除

每个目录都有一个硬链接 . 和上一层目录的硬链接 .. (系统存在对目录创建的硬链接，只是不允许用户创建)

```shell
drwxr-xr-x. 2 root root    6 Sep 23 23:24 test
```

创建一个目录后，发现硬链接的个数为2，实际上为 源目录 和 表示当前目录的 。

在父目录下创建一个子目录，父目录的硬链接个数+1（实际上因为子目录中有表示父目录的硬链接 ..），但是创建文件不会导致父目录硬链接 + 1

软链接在实际使用中，用于指向不同的版本。当版本更新时，只需要创建指向最新版本的软链接即可，并不需要修改业务的访问路径。

```shell
[root@promote.cache-dns.local ~/service]# ll
total 0
lrwxrwxrwx. 1 root root 8 Sep 23 23:29 version -> version1
drwxr-xr-x. 2 root root 6 Sep 23 23:29 version1
drwxr-xr-x. 2 root root 6 Sep 23 23:29 version2
```

业务通过version路径访问，此时存在新版本version2时，只需要删除原软链接，创建一个名为verison指向version2的软链接即可。

~~~shell
[root@promote.cache-dns.local ~/service]# ll
total 0
lrwxrwxrwx. 1 root root 8 Sep 23 23:33 version -> version2
drwxr-xr-x. 2 root root 6 Sep 23 23:29 version1
drwxr-xr-x. 2 root root 6 Sep 23 23:32 version2
~~~

### 11、readlink

获取当前软链接对应的文件，如果存在多层软链接，只能当前软链接的目标。

-f	获取软链接的最终指向目标，结果为绝对路径

~~~shell
[root@localhost.localdomain ~/link]# ll
total 4
-rw-r--r--. 1 root root 6 Sep 23  2020 a
lrwxrwxrwx. 1 root root 1 Sep 23  2020 b -> a
lrwxrwxrwx. 1 root root 1 Sep 23  2020 c -> b
[root@localhost.localdomain ~/link]# readlink c
b
[root@localhost.localdomain ~/link]# readlink -f c
/root/link/a
~~~

### 12、find

语法：find [路径] [选项] [参数] [操作]

| 选项       | 含义                          |
| :--------- | ----------------------------- |
| -regextype | posix-extended                |
| -maxdepth  | 查找的目录深度，当前目录为1级 |

| 参数    | 含义                                                         |
| ------- | ------------------------------------------------------------ |
| -mtime  | 按照文件修改时间查找文件。<br />-n 表示距离n天以内<br />+n 表示距离n天之前<br />n 表示距离n天 |
| -name   | 按照文件名查找，支持 *、?、[ ] 通配符                        |
| -iname  | 同-name，不区分大小写                                        |
| -regex  | 按照正则表达式查找                                           |
| -iregex | 同-regex，不区分大小写                                       |
| -type   | 查找文件类型： f (普通文件)、d (目录)                        |

| 操作    | 含义                                       |
| ------- | ------------------------------------------ |
| -delete | 将查找的文件删除                           |
| -exec   | 对匹配的文件执行该参数给出的命令           |
| -ok     | 同-exec，每个命令执行前需确认              |
| -prune  | 于 参数 -path $(pattern)一起使用，忽略目录 |
| !       | 取反                                       |
| -a      | 取交集                                     |
| -o      | 取并集                                     |

~~~shell
#根据名称查找
[scott@localhost.localdomain ~]$ find . -name "*.sh"
./math.sh
./test.sh
#反向查找
[scott@localhost.localdomain ~]$ find . ! -name "*.sh" -type f
./.bash_logout
./.bash_history
./.lesshst
./.bash_profile
./empty.txt
./hello.txt
./.bashrc
#正则查找，文件名长度5位，log类型的文件
[root@localhost.localdomain ~]# find / -regextype posix-extended -regex ".*/[a-z]{5}\.log"
/var/log/tuned/tuned.log
/var/log/audit/audit.log
/var/log/anaconda/ifcfg.log
/usr/local/nginx/logs/error.log
/usr/local/mysql/data/error.log
#多条件查找
[scott@localhost.localdomain ~]$ find . -name "*.sh" -o -name "*.txt"
./empty.txt
./hello.txt
./math.sh
./test.s
[scott@localhost.localdomain ~]$ find . -name "*.txt"
./empty.txt
./hello.txt
./a/test1.txt
./b/test2.txt
#查找文件忽略单个文件夹
[scott@localhost.localdomain ~]$ find . -path "./a" -prune -o -name "*.txt" -print
./empty.txt
./hello.txt
./b/test2.txt
#查找文件忽略多个文件夹
[scott@localhost.localdomain ~]$ find . \( -path "./a" -o -path "./b" \) -prune -o -name "*.txt" -print
./empty.txt
./hello.txt
#-exec，{}替代find查找的内容，\; 终止-exec的参数
[scott@localhost.localdomain ~]$ find . -name "*txt" -exec ls -l {} \;
-rw-rw-r--. 1 scott scott 0 Nov 24 20:57 ./empty.txt
-rw-rw-r--. 1 scott scott 42 Nov 24 21:42 ./hello.txt
-rw-rw-r--. 1 scott scott 0 Nov 27 17:23 ./a/test1.txt
-rw-rw-r--. 1 scott scott 0 Nov 27 17:23 ./b/test2.txt
~~~

### 13、xargs

命令的参数来源分为两种：命令行参数、标准输入

管道“|” 用来将前一个命令的标准输出传递到下一个命令的标准输入。

xargs 将前一个命令的标准输出传递给下一个命令，作为它的参数。

~~~shell
#cat的输入
[scott@localhost.localdomain ~]$ echo "hello.txt" | cat
hello.txt
#cat命令的参数
[scott@localhost.localdomain ~]$ echo "hello.txt" | xargs cat
hello
hello world
hello linux
hello shell
~~~

### 14、md5sum

计算和校验文件的md5值

~~~shell
[scott@localhost.localdomain ~]$ md5sum hello.txt
abe28d6fff21cc3cdbd57077922792f1  hello.txt
[scott@localhost.localdomain ~]$ md5sum <(cat hello.txt)
abe28d6fff21cc3cdbd57077922792f1  /dev/fd/63
~~~

### 15、chown

修改文件或目录的所有者和所属组

-R 递归修改

~~~shell
[root@localhost.localdomain /home/scott]# ll
total 12
drwxrwxr-x. 2 scott scott 23 Nov 27 17:24 a
#同时修改所有者和所属组
[root@localhost.localdomain /home/scott]# chown -R root:root a
[root@localhost.localdomain /home/scott]# ll
total 12
drwxrwxr-x. 2 root  root  23 Nov 27 17:24 a
#只修改所属组
[root@localhost.localdomain /home/scott]# chown -R :scott a
[root@localhost.localdomain /home/scott]# ll
total 12
drwxrwxr-x. 2 root  scott 23 Nov 27 17:24 a
#只修改所有者
[root@localhost.localdomain /home/scott]# chown -R scott a
[root@localhost.localdomain /home/scott]# ll
total 12
drwxrwxr-x. 2 scott scott 23 Nov 27 17:24 a
~~~

### 16、chmod

修改文件或目录的权限

-R 递归修改

| 用户类型               | 权限标记             | 操作字符      |
| ---------------------- | -------------------- | ------------- |
| u（所有者）            | 读（r、4）           | 新增权限（+） |
| g（所属组）            | 写（w、2）           | 删除权限（-） |
| o（其他用户）          | 执行（x、1）         | 设置权限（=） |
| a（所有，u、g、o总和） | 没有任何权限（-、0） |               |

| 权限符号 | 文件     | 目录                                   |
| -------- | -------- | -------------------------------------- |
| 可读 r   | 读取文件 | 浏览目录下的文件和子目录               |
| 可写 w   | 修改文件 | 在目录下新增、重命名、删除文件和子目录 |
| 可执行 x | 执行文件 | 进入目录                               |

~~~shell
#当前文件权限664
[scott@localhost.localdomain ~/a]$ ll
total 0
-rw-rw-r--. 1 scott scott 0 Nov 27 17:23 test1.txt
#使用权限数字方式修改权限
[scott@localhost.localdomain ~/a]$ chmod 777 test1.txt
[scott@localhost.localdomain ~/a]$ ll
total 0
-rwxrwxrwx. 1 scott scott 0 Nov 27 17:23 test1.txt
#使用权限字符方式修改权限
[scott@localhost.localdomain ~/a]$ chmod g-x test1.txt
[scott@localhost.localdomain ~/a]$ ll
total 0
-rwxrw-rwx. 1 scott scott 0 Nov 27 17:23 test1.txt
[scott@localhost.localdomain ~/a]$ chmod o=r test1.txt
[scott@localhost.localdomain ~/a]$ ll
total 0
-rwxrw-r--. 1 scott scott 0 Nov 27 17:23 test1.txt
~~~

## 三、文件过滤和文件处理

### 1、cat

- 查看文件	cat file

- 多个文件合并为一个	cat file1 file2 > file3

- 交互式编辑

  cat > file << EOF

  ...

  EOF

-n	输出显示行号

-b	同-n，不显示空行行号

-A	显示windows、结尾、tab标记

### 2、more

和man命令操作基本一致

交互式命令：

=	显示当前行号

v	调用vi编辑器

### 3、less

-I	搜索时忽略大小写

-N	输出时显示行号

交互式命令：

v	调用vi编辑器

### 4、head

-n	显示前几行，默认显示前10行

-c	显示前几个字节

~~~shell
#head可以同时显示多个文件
[scott@localhost.localdomain ~]$ head *.txt
==> empty.txt <==

==> hello.txt <==
hello
hello world
hello linux
hello   shell
~~~

### 5、tail

-n	显示后几行，默认显示后10行

-f	监视文件变化（基本等同于tailf命令），文件不存在则报错退出

-F	监视文件变化，文件不存在报错，但不会退出，会不断尝试打开

### 6、sort

-b	忽略开头空格

-n	按照数值大小排序

-r	倒叙

-u	去重

-t	指定分隔符

-k	按指定区间排序

~~~shell
[scott@localhost.localdomain ~]$ cat ip.txt
192.168.1.1
10.10.10.10
168.2.11.22
3.55.32.4
10.23.188.4
#默认ascii码升序
[scott@localhost.localdomain ~]$ sort ip.txt
10.10.10.10
10.23.188.4
168.2.11.22
192.168.1.1
3.55.32.4
#按数字排序
[scott@localhost.localdomain ~]$ sort -n ip.txt
3.55.32.4
10.10.10.10
10.23.188.4
168.2.11.22
192.168.1.1
#.分隔，第3列按数字排序
[scott@localhost.localdomain ~]$ sort -n -t . -k 3 ip.txt
192.168.1.1
10.10.10.10
168.2.11.22
3.55.32.4
10.23.188.4
~~~

### 7、uniq

uniq默认只对邻行去重，因此先sort再去重

-c	去重后计算每行出现次数

-d	显示重复的行

~~~shell
#去重
[scott@localhost.localdomain ~]$ sort hello.txt | uniq
hello
hello linux
hello shell
hello world
#只显示重复的行
[scott@localhost.localdomain ~]$ sort hello.txt | uniq -d
hello
hello world
#去重，显示每行出现次数
[scott@localhost.localdomain ~]$ sort hello.txt | uniq -c
      2 hello
      1 hello linux
      1 hello shell
      2 hello world
~~~

### 8、wc

-l	统计行数

~~~shell
[scott@localhost.localdomain ~]$ cat hello.txt
hello
hello world
hello
hello linux
hello shell
hello world
[scott@localhost.localdomain ~]$ cat hello.txt | wc -l
6
~~~

### 9、dos2unix

windows下换行\r\n，unix下换行\n

dos2unix 文件名

### 10、diff

比较文件不同

-y	并排方式显示

-c	上下方式显示

~~~shell
[scott@localhost.localdomain ~]$ diff hello.txt hello2.txt
4c4
< hello linux
---
> test
6d5
< hello world
[scott@localhost.localdomain ~]$ diff -y hello.txt hello2.txt
hello                                                           hello
hello world                                                     hello world
hello                                                           hello
hello linux                                                   | test
hello shell                                                     hello shell
hello world                                                   <
[scott@localhost.localdomain ~]$ diff -c hello.txt hello2.txt
*** hello.txt   2021-11-27 23:18:20.794565720 +0800
--- hello2.txt  2021-11-27 23:36:46.174522415 +0800
***************
*** 1,6 ****
  hello
  hello world
  hello
! hello linux
  hello shell
- hello world
--- 1,5 ----
  hello
  hello world
  hello
! test
  hello shell
~~~

### 11、tee

-a	追加

~~~shell
[scott@localhost.localdomain ~]$ ls | tee list.sh
empty.txt
hello.txt
math.sh
test.sh
[scott@localhost.localdomain ~]$ cat list.sh
empty.txt
hello.txt
math.sh
test.sh
#追加
[scott@localhost.localdomain ~]$ echo yes | tee -a list.sh
yes
[scott@localhost.localdomain ~]$ cat list.sh
empty.txt
hello.txt
math.sh
test.sh
yes
~~~

## 四、信息显示

### 1、uname

显示系统相关信息

uname -a	显示系统所有信息

### 2、hostname

~~~shell
#显示主机名
[root@localhost.localdomain ~]# hostname
localhost.localdomain
#临时设置主机名
[root@localhost.localdomain ~]# hostname test
[root@localhost.localdomain ~]# hostname
test
#显示IP
[root@localhost.localdomain ~]# hostname -I
192.168.232.129
~~~

永久修改主机名的方式（修改后需要重启）：修改 /etc/hostname

### 3、du

-a	显示所有文件大小

-h	合适的单位显示文件大小

-s	显示文件总大小

~~~shell
[root@192.168.232.129 ~]# du -a
4       ./.bash_logout
4       ./.bash_profile
4       ./.cshrc
4       ./.tcshrc
4       ./anaconda-ks.cfg
16      ./.bash_history
4       ./.lesshst
4       ./.mysql_history
4       ./.bashrc
4       ./test.sh
52      .
[root@192.168.232.129 ~]# du -sh
52K
~~~

### 4、date

-d ”时间字符串“	显示距离字符串表示的时间

-s	设置系统时间，格式 ”yyyy-MM-dd HH:mm:ss“

-u	显示或设置UTC时间

format日志格式：

%F	完整日期格式，等价”%Y-%m-%d“

%T	时间，等价"%H:%M%S"

%z	时区

%s	1970年到现在秒数

%n	换行

%t	制表符

~~~shell
[root@192.168.232.129 ~]# date
Sun Nov 28 12:39:53 CST 2021
[root@192.168.232.129 ~]# date -s "2021-11-28 12:39:00"
Sun Nov 28 12:39:00 CST 2021
[root@192.168.232.129 ~]# date
Sun Nov 28 12:39:02 CST 2021
[root@192.168.232.129 ~]# date +%F
2021-11-28
[root@192.168.232.129 ~]# date +%T
12:39:18
[root@192.168.232.129 ~]# date +"%Y %m %d"
2021 11 28
[root@192.168.232.129 ~]# date +"%H %M %S"
12 40 05
[root@192.168.232.129 ~]# date
Sun Nov 28 12:40:10 CST 2021
[root@192.168.232.129 ~]# date +%s
1638074425
~~~

- +表示未来，-表示过去
- hour表示时间，min表示分
- year表示年，month表示月，day表示日

~~~shell
[root@192.168.232.129 ~]# date +"%F %T"
2021-11-28 12:49:23
[root@192.168.232.129 ~]# date +"%F %T" -d "10min"
2021-11-28 12:59:27
[root@192.168.232.129 ~]# date +"%F %T" -d "-10min"
2021-11-28 12:39:31
[root@192.168.232.129 ~]# date +"%F %T" -d "12hour"
2021-11-29 00:49:59
[root@192.168.232.129 ~]# date +"%F %T" -d "-12hour"
2021-11-28 00:50:05
[root@192.168.232.129 ~]# date +"%F %T" -d "1day"
2021-11-29 12:50:20
[root@192.168.232.129 ~]# date +"%F %T" -d "-1day"
2021-11-27 12:50:17
~~~

### 5、echo

-n：输出后不换行

-e：解析转义字符

~~~shell
[scott@localhost.localdomain ~]$ echo hello;echo world
hello
world
[scott@localhost.localdomain ~]$ echo -n hello;echo world
helloworld
# \n：换行
# \t：制表符
# \\：\
# \"："
# \'：'
[scott@localhost.localdomain ~]$ echo -e "hello\n\tworld"
hello
        world
~~~

### 6、which

显示命令全路径

~~~shell
[scott@192.168.232.129 ~]$ which date
/bin/date
~~~

## 五、压缩

### 1、tar

-z	gzip压缩或解压

-c	创建tar包

-v	显示执行过程

-f	指定压缩包名字

-t	不解压查看tar包

-x	解压tar包

-C	指定解压路径

~~~shell
#压缩
[scott@192.168.232.129 ~]$ tar -cvf hello.tar hello.txt hello2.txt
hello.txt
hello2.txt
#查看解压包
[scott@192.168.232.129 ~]$ tar -tvf hello.tar
-rw-rw-r-- scott/scott      60 2021-11-27 23:18 hello.txt
-rw-rw-r-- scott/scott      41 2021-11-27 23:36 hello2.txt
#解压
[scott@192.168.232.129 ~]$ tar -xvf hello.tar
hello.txt
hello2.txt
#解压时指定路径
[scott@192.168.232.129 ~]$ tar -xvf hello.tar -C hello
hello.txt
hello2.txt
#gzip压缩和解压
[scott@192.168.232.129 ~]$ tar -zcvf hello.tar.gz hello
hello/
hello/hello.txt
hello/hello2.txt
[scott@192.168.232.129 ~]$ tar -zxvf hello.tar.gz
hello/
hello/hello.txt
hello/hello2.tx
~~~

### 2、zip

-r	将目录下的文件和子文件一起压缩

-x	压缩文件时排除文件

~~~shell
[root@192.168.232.129 /home]# zip -r scott.zip scott/
updating: scott/ (stored 0%)
  adding: scott/a/ (stored 0%)
  adding: scott/a/test1.txt (stored 0%)
  adding: scott/b/ (stored 0%)
  adding: scott/b/test2.txt (stored 0%)
  adding: scott/hello.txt (deflated 48%)
  adding: scott/hello2.txt (deflated 29%)
#排除文件
[root@192.168.232.129 /home]# zip -r scott.zip scott -x scott/hello2.txt
updating: scott/a/ (stored 0%)
updating: scott/a/test1.txt (stored 0%)
updating: scott/b/ (stored 0%)
updating: scott/b/test2.txt (stored 0%)
updating: scott/hello.txt (deflated 48%)
~~~

### 3、unzip

-l	只显示，不解压

-d	指定解压目录

-o	解压时直接覆盖，不提示

~~~shell
[scott@192.168.232.129 ~]$ unzip -d abc a.zip
Archive:  a.zip
   creating: abc/a/
 extracting: abc/a/test1.txt
~~~

### 4、scp

主机之间复制

-p	传输保留文件属性

-r	递归复制整个目录

~~~shell
#将当前主机的文件传输到指定ip
scp -r 目录 用户名@ip:远端保存路径
#将远端主机的文件传输到当前ip
scp -r 用户名@ip:远端保存路径 本地目录
~~~

## 六、用户管理

1、useradd

2、userdel

3、groupadd

4、groupdel

5、passwd

6、chage

7、su

8、sudo

9、id

10、w

11、who

12、users

13、whoami

14、last

15、lastlog

## 七、磁盘和文件系统

1、fdisk

2、dd

3、mount

4、umount

5、df

6、du

## 八、进程

1、ps

2、pstree

3、kill

4、killall

5、pkill

6、top

7、nohup

## 九、网络

1、ifconfig

2、netstat

3、ss

4、ping

5、wget

6、nmap

7、tcpdump

## 十、系统管理

1、lsof

2、free

3、iftop

4、vmstat

5、mpstat

6、iostat

7、iotop

8、sar

9、chkconfig

10、ethtool
