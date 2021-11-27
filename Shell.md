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

2、more

3、less

4、head

5、tail

6、tailf

7、sort

8、uniq

9、wc

10、dos2unix

11、diff

12、vimdiff

13、tee

## 四、信息显示

1、uname

2、hostname

3、du

4、date

5、echo

6、watch

7、which

8、whereis

## 五、压缩

1、tar

2、gzip

3、zip

4、unzip

5、scp

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

# Shell

## 一、Shell入门

shell是一个命令解释器，存在于操作系统最外层，负责将用户的输入解释给操作系统。

### 1、查看用户当前shell类型

```shell
[scott@localhost.localdomain ~]$ echo $SHELL
/bin/bash
```

```shell
#whoami用于获取当前用户名
[scott@localhost.localdomain ~]$ cat /etc/passwd | grep $(whoami)
scott:x:1000:1000::/home/scott:/bin/bash
#$USER中保存当前用户名
[scott@localhost.localdomain ~]$ cat /etc/passwd | grep $USER
scott:x:1000:1000::/home/scott:/bin/bash
```

### 2、脚本开头

```shell
#!/bin/bash
```

### 3、脚本执行方式

命令执行时，会从PATH路径中查找。当前路径 . 未在PATH中配置，因此需要通过相对或绝对路径执行脚本。

```shell
#推荐方式（不需要赋执行权限）
sh test.sh
#脚本必须有执行权限，通过chmod u+x test.sh方式添加执行权限
./test.sh
```

### 4、显示消息

脚本中通过echo命令显示消息，当显示的消息中存在单引号或双引号时，可以使用另一种引号指定字符串范围。

~~~shell
[scott@localhost.localdomain ~]$ echo "I'm zhangsan"
I'm zhangsan
[scott@localhost.localdomain ~]$ echo 'I love "flows"'
I love "flows"
~~~

- -n：输出后不换行

~~~shell
[scott@localhost.localdomain ~]$ echo hello;echo world
hello
world
[scott@localhost.localdomain ~]$ echo -n hello;echo world
helloworld
~~~

- -e：解析转义字符

  \n：换行

  \t：制表符

~~~shell
[scott@localhost.localdomain ~]$ echo -e "hello\n\tworld"
hello
        world
~~~

### 5、退出脚本

默认情况下，shell脚本会以脚本中最后一个命令的退出状态码退出。

可以手动指定状态码退出，使用“exit 状态码”的形式。一般结合 if-then  语句一起使用。

### 6、脚本调试

- sh -n 脚本名

检查脚本语法错误，不执行

- sh -x  脚本名

调试方式，显示执行的每一条语句

### 7、后台运行脚本

脚本运行日志默认写到当前路径下的nohup.out文件中

&只是让脚本在后台运行，不会受到Ctrl+C的影响，但是用户退出时，脚本会停止执行。

~~~shell
#任务后台执行，1表示作业号，2594表示进程pid
[scott@localhost.localdomain ~]$ sleep 100 &
[1] 2594
[scott@localhost.localdomain ~]$ ps -f
UID         PID   PPID  C STIME TTY          TIME CMD
scott      2518   2517  0 23:19 pts/0    00:00:00 -bash
scott      2594   2518  0 23:35 pts/0    00:00:00 sleep 100
scott      2596   2518  0 23:35 pts/0    00:00:00 ps -f
#jobs -l可以显示后台作业任务信息
[scott@localhost.localdomain ~]$ jobs -l
[1]+  2594 Running                 sleep 100 &
#作业完成
[scott@localhost.localdomain ~]$
[1]+  Done                    sleep 100
~~~

nohup让脚本忽略SIGHUP的信号，退出也不会停止脚本执行。

~~~shell
nohup sh 脚本名 &
~~~

## 二、Shell变量

变量分为两种：环境变量（全局变量）、用户变量（局部变量）

环境变量：可以在创建的shell及子shell中使用，==环境变量使用大写表示==

用户变量：只能在shell脚本或shell函数中使用

### 1、环境变量

```shell
#获取环境变量命令
set：输出所有的变量，包括全局变量和局部变量
env：只显示全局变量
[scott@localhost.localdomain ~]$ name='jerry'
[scott@localhost.localdomain ~]$ set | grep name
name=jerry
[scott@localhost.localdomain ~]$ env | grep name
[scott@localhost.localdomain ~]$
```

常用的环境变量

~~~shell
#家目录
[scott@localhost.localdomain ~]$ echo $HOME
/home/scott
#主机名
[scott@localhost.localdomain ~]$ echo $HOSTNAME
localhost.localdomain
#退出超时时间，单位：秒
[scott@localhost.localdomain ~]$ echo $TMOUT

#用户uid
[scott@localhost.localdomain ~]$ echo $UID
1000
#用户名
[scott@localhost.localdomain ~]$ echo $USER
scott
~~~

#### （1）定义环境变量

- 临时配置方式：

```shell
#方式一
export 变量名=value
#方式二
变量名=value
export 变量名
```

- 永久配置方式：

~~~shell
#用户文件中配置
.bashrc（推荐）
.bash_profile
#全局配置文件
/etc/bashrc（推荐）
/etc/profile
/etc/profile.d（若要在登录后初始化或显示加载内容，把脚本文件放在该目录下）
~~~

#### （2）取消环境变量

使用unset取消全局和局部变量

~~~shell
[scott@localhost.localdomain ~]$ export name=zhangsan
[scott@localhost.localdomain ~]$ echo $name
zhangsan
[scott@localhost.localdomain ~]$ unset name
[scott@localhost.localdomain ~]$ echo $name

~~~

#### （3）环境变量初始化与文件生效顺序

```shell
#用户登录linux时(su - 用户名)，依次在以下文件中查找环境变量
/etc/profile
/etc/profile.d
$HOME/.bash_profile -> $HOME/.bashrc -> /etc/bashrc
#非登录方式（su 用户名 或 ssh连接）
$HOME/.bashrc -> /etc/bashrc
```

### 2、用户变量

用户变量只在当前shell中有效。

#### （1）定义本地变量

==赋值=之所以两边没有空格，因为需要和命令区分。当=两边允许有空格时，无法判断=前的值是变量还是命令==

普通变量一般有三种写法：
变量名=value
变量名='value'
变量名="value"

~~~shell
[scott@localhost.localdomain ~]$ name=zhangsan
#双引号会解析 $ ` \
[scott@localhost.localdomain ~]$ echo "I am $name"
I am zhangsan
#单引号不会解析 $ ` \ 原样输出
[scott@localhost.localdomain ~]$ echo 'I am $name'
I am $name
#将变量值中存在空格等字符时，必须使用双引号
[scott@localhost.localdomain ~]$ name=zhang san
-bash: san: command not found
[scott@localhost.localdomain ~]$ name="zhang san"
[scott@localhost.localdomain ~]$ echo "I am $name"
I am zhang san
#当需要输出$ ` \时，可以使用单引号，或者使用双引号+转义符
[scott@localhost.localdomain ~]$ echo "The cost of the item is \$15"
The cost of the item is $15
~~~

#### （2）命令的结果赋值变量

==命令替换会创建一个子shell来运行对应的命令==

~~~shell
#方式一
变量名=`命令`
#方式二（推荐）
变量名=$(命令)
~~~

#### （3）变量表示

~~~shell
#方式一
echo $name
#方式二，当变量后连接其他字符时，必须使用${}表示边界
echo ${name}
~~~

#### （4）readonly

- readonly命令可以查看所有的只读变量

~~~shell
[scott@localhost.localdomain ~]$ readonly
declare -r BASHOPTS="checkwinsize:cmdhist:expand_aliases:extquote:force_fignore:histappend:hostcomplete:interactive_comments:login_shell:progcomp:promptvars:sourcepath"
declare -ir BASHPID
declare -ar BASH_VERSINFO='([0]="4" [1]="2" [2]="46" [3]="2" [4]="release" [5]="x86_64-redhat-linux-gnu")'
declare -ir EUID="1000"
declare -ir PPID="3845"
declare -r SHELLOPTS="braceexpand:emacs:hashall:histexpand:history:interactive-comments:monitor"
declare -ir UID="1000"
declare -r name="zhangsan"
~~~

- readonly定义的变量无法被修改

~~~shell
[scott@localhost.localdomain ~]$ readonly name=zhangsan
[scott@localhost.localdomain ~]$ echo $name
zhangsan
[scott@localhost.localdomain ~]$ name=lisi
-bash: name: readonly variable
#unset无法删除变量
[scott@localhost.localdomain ~]$ unset name
-bash: unset: name: cannot unset: readonly variable
~~~

### 3、特殊变量

#### （1）$0、$n、$#、$*、$@、$?、$$

| 位置变量 | 作用                                                         |
| -------- | ------------------------------------------------------------ |
| $0       | 获取shell脚本文件名，"./脚本名" 时为 ./脚本名，"sh 脚本名" 时为 脚本名 |
| $n       | 获取shell脚本的第n个参数，n大于9时，需要使用如 ${10}的方式   |
| $#       | 获取shell脚本参数个数                                        |
| $*       | 获取shell脚本所有传参，不加双引号和$@相同，加双引号"$*"，将所有参数作为单个字符串 |
| $@       | 获取shell脚本所有传参，不加双引号和$*相同，加双引号"$@"，每个参数作为独立的字符串。<br />不加双引号时，参数中包含双引号的参数会被拆分为多个参数。<br />如遍历参数，执行sh test.sh "a b" 1 2，将分别打印 a、b、1、2，所以使用时一定要加上双引号 |

#### （2）dirname（获取脚本路径）

~~~shell
[scott@localhost.localdomain ~]$ cat test.sh
#!/bin/bash
echo $(dirname $0)
[scott@localhost.localdomain ~]$ sh test.sh
.
[scott@localhost.localdomain ~]$ ./test.sh
.
[scott@localhost.localdomain ~]$ /home/scott/test.sh
/home/scott
~~~

#### （3）basename（获取脚本名称）

~~~shell
[scott@localhost.localdomain ~]$ cat test.sh
#!/bin/bash
echo $(basename $0)
[scott@localhost.localdomain ~]$ sh test.sh
test.sh
[scott@localhost.localdomain ~]$ ./test.sh
test.sh
[scott@localhost.localdomain ~]$ /home/scott/test.sh
test.sh
~~~

| 位置变量 | 作用                                               |
| -------- | -------------------------------------------------- |
| $?       | 上个命令的执行状态返回值（0表示成功，非0表示失败） |
| $$       | 获取当前执行的shell脚本进程号                      |

~~~shell
#!/bin/bash
pid_file="test.pid"
#启动进程前，结束上一次进程
if [ -f "$pid_file" ]
then
  kill -9 $(cat test.pid) &> /dev/null
  rm -f "$pid_file"
fi

#重写pid文件
echo $$ > "$pid_file"

#每秒获取当前时间
while true
do
  echo $(date +%F' '%r)
  sleep 1
done
~~~

### 4、Bash内置变量命令

#### （1）eval

执行eval语句时，shell读入参数，并将它们组合成一个新的命令并执行

  ~~~shell
  [scott@localhost.localdomain ~]$ eval $(echo date)
  Mon Nov 15 00:26:54 CST 2021
  ~~~

#### （2）shift 

每使用一次shift语句，所有位置参数向左移动一个位置，并使 $# 减1，直到为0。

shift  n：一次可以移除多个参数

~~~shell
[scott@localhost.localdomain ~]$ cat test.sh
#!/bin/bash
echo "$@"
shift
echo "====================="
echo "$@"
[scott@localhost.localdomain ~]$ sh test.sh a b c d
a b c d
=====================
b c d
~~~

#### （3）read

read -p 提示信息 -t 超时时间 多个变量名

~~~shell
[scott@localhost.localdomain ~]# read -p "请输入2个数字：" -t 10 num1 num2
请输入2个数字：1 2
[scott@localhost.localdomain ~]# echo $num1
1
[scott@localhost.localdomain ~]# echo $num2
2
~~~

-s 参数可以隐藏输入的内容

~~~shell
[scott@localhost.localdomain ~]$ cat test.sh
#!/bin/bash
read -s -p "Enter your password:" passwd
echo
echo "your password is:$passwd"
#运行
[scott@localhost.localdomain ~]$ sh test.sh
Enter your password:
your password is:123123
~~~

==read读取文件，管道造成的陷阱==

~~~shell
#!/bin/bash
file=hello.txt
count=0
#管道使得while语句在子shell中执行，子shell是无法访问父shell中变量，导致无法修改变量
cat $file | while read line
do
  echo $line
  count=$[count+1]
done
echo "There are $count lines in $file"

[scott@localhost.localdomain ~]$ sh test.sh
hello
hello world
hello linux
hello shell
There are 0 lines in hello.txt
~~~

可以使用重定向，从文件读取

~~~shell
#!/bin/bash
file=hello.txt
count=0
while read line
do
  echo $line
  count=$[count+1]
done < $file
echo "There are $count lines in $file"

[scott@localhost.localdomain ~]$ sh test.sh
hello
hello world
hello linux
hello shell
There are 4 lines in hello.txt
~~~

### 5、shell子串

==字串操作并不会修改原字符串内容==

| ID   | 表达式                   | 说明                                      |
| ---- | ------------------------ | ----------------------------------------- |
| 1    | ${param}                 | 返回$param的内容                          |
| 2    | ${#param}                | 返回$param的长度                          |
| 3    | ${param:offset}          | 返回offset开始的param的字串               |
| 4    | ${param:offset:length}   | 返回offset开始，长度为length的param的字串 |
| 5    | ${param#world}           | 从param开头开始删除最短匹配的world字串    |
| 6    | ${param##world}          | 从param开头开始删除最长匹配的world字串    |
| 7    | ${param%world}           | 从param结尾开始删除最短匹配的world字串    |
| 8    | ${param%%world}          | 从param结尾开始删除最长匹配的world字串    |
| 9    | ${param/pattern/string}  | 使用string代替第一个匹配的pattern         |
| 10   | ${param//pattern/string} | 使用string代替所有匹配的pattern           |

~~~shell
[scott@localhost.localdomain ~]# info="helloworld"
#返回变量
[scott@localhost.localdomain ~]# echo $info
helloworld
#返回变量长度
[scott@localhost.localdomain ~]# echo ${#info}
10

#截取字串
[scott@localhost.localdomain ~]# echo ${info:5}
world
[scott@localhost.localdomain ~]# echo ${info:0:5}
hello
[scott@localhost.localdomain ~]# info="123abc123def"
[scott@localhost.localdomain ~]# echo ${info#123}
abc123def
#删除字串操作，必须以删除的字串开头或结尾，否则不能正常删除
[scott@localhost.localdomain ~]# echo ${info%123}
123abc123def
[scott@localhost.localdomain ~]# echo ${info%def}
123abc123
[scott@localhost.localdomain ~]# echo ${info#1*3}
abc123def
[scott@localhost.localdomain ~]# echo ${info##1*3}
def

#字符串替换操作
[scott@localhost.localdomain ~]# echo ${info/123/|}
|abc123def
[scott@localhost.localdomain ~]# echo ${info//123/|}
|abc|def
~~~

### 6、分隔符IFS

~~~shell
#设置分隔符前使用变量保存原分隔符
IFS.OLD=$IFS
#设置新分隔符
IFS=$'\n'
#在代码中使用新的IFS值
#使用完成后，恢复原分隔符
IFS=$IFS.OLD

#将IFS的值设为冒号
IFS=:
#如果要指定多个IFS字符，只要将它们在赋值行串起来就行
#这个赋值会将换行符、冒号、分号和双引号作为字段分隔符
IFS=$'\n':;"
~~~

## 三、数组

### 1、数组的定义

~~~shell
 #直接定义
[scott@localhost.localdomain ~]$ names=(tom jack zhangsan lisi)
[scott@localhost.localdomain ~]$ echo ${names[@]}
tom jack zhangsan lisi
[scott@localhost.localdomain ~]$ echo ${#names[@]}
4
 #带下标定义，下标可以不连续
[scott@localhost.localdomain ~]$ values[0]=100
[scott@localhost.localdomain ~]$ values[2]=200
[scott@localhost.localdomain ~]$ echo ${values[@]}
100 200
[scott@localhost.localdomain ~]$ echo ${#values[@]}
2
~~~

### 2、数组操作

#### （1）取值

~~~shell
#数组取值
[scott@localhost.localdomain ~]$ echo ${names[2]}
zhangsan
#获得数组中所有值，以空格隔开，可以在数组中遍历
[scott@localhost.localdomain ~]$ echo ${names[@]}
tom jack zhangsan lisi
#获取的是一整个字符串
[scott@localhost.localdomain ~]$ echo ${names[*]}
tom jack zhangsan lisi
#${数组名}等价于${数组名[0]}
[scott@localhost.localdomain ~]$ echo ${names}
tom
~~~

#### （2）赋值

~~~shell
[scott@localhost.localdomain ~]$ names[1]="jerry"
[scott@localhost.localdomain ~]$ echo ${names[1]}
jerry
~~~

#### （3）长度

~~~shell
[scott@localhost.localdomain ~]$ echo ${#names[@]}
4
[scott@localhost.localdomain ~]$ echo ${#names[*]}
4
~~~

#### （4）删除

~~~shell
[scott@localhost.localdomain ~]$ echo ${names[@]}
tom jerry zhangsan lisi
#删除单个数组元素
[scott@localhost.localdomain ~]$ unset names[1]
[scott@localhost.localdomain ~]$ echo ${names[@]}
tom zhangsan lisi
#删除整个数组
[scott@localhost.localdomain ~]$ unset names
[scott@localhost.localdomain ~]$ echo ${names[@]}

~~~

#### （5）遍历

- for循环，根据元素遍历

~~~shell
#!/bin/bash
names=(tom jack zhangsan lisi)
for name in ${names[@]}
do
  echo $name
done

[scott@localhost.localdomain ~]$ sh test.sh
tom
jack
zhangsan
lisi
~~~

- for循环，根据索引遍历，==使用${!数组名[@]}获取数组所有下标==

~~~shell
#!/bin/bash
names=(tom jack zhangsan lisi)
for i in ${!names[@]}
do
  echo ${names[$i]}
done

[scott@localhost.localdomain ~]$ sh test.sh
tom
jack
zhangsan
lisi
~~~

- while循环，根据索引遍历

~~~shell
#!/bin/bash
names=(tom jack zhangsan lisi)
i=0
while [ $i -lt ${#names[@]} ]
do
  echo ${names[$i]}
  i=$[i+1]
done

[scott@localhost.localdomain ~]$ sh test.sh
tom
jack
zhangsan
lisi
~~~

## 四、运算符

==支持算术运算符号：$(( ))、$[ ]、let、expr==

==支持条件判断符号：[ ]、test、[[]]、(( ))，条件判断常用在if、while语句中，也常用在cmd1 && cmd2 || cmd3格式的命令行中。==

### 1、(( ))

(( ))允许使用高级数学表达式。进行数值运算和数值比较，只能操作整数

命令执行时不需要加$，输出时需要加$

如果表达式的结果为0，那么返回的退出状态码为1，或者 是"假"；而一个非零值的表达式所返回的退出状态码将为0，或者是"true"

- ((i=i+1))：先运算后赋值，将 i+1 的值赋值给 i

- i=$((i+1))：i+1的值计算后，赋值给 i

- ((8>7 && 5==5))：用于条件判断，结果为1，表示true

- echo $((2+1))：输出计算的结果

- ((a++))：返回后自增

- ((--a))：自减后返回


~~~shell
#!/bin/bash
if (( $1 > 10 ))
then
  echo "match"
else
  echo "not match"
fi
~~~

### 2、[ ]

（1）$[ ]用于数学运算

支持传入变量，只支持整数运算

~~~shell
[scott@localhost.localdomain ~]$ echo $[1+2]
3
[scott@localhost.localdomain ~]$ echo $[1 + 2]
3
[scott@localhost.localdomain ~]$ echo $[ 1 + 2 ]
3
[scott@localhost.localdomain ~]$ value=10
#支持变量，直接使用变量名
[scott@localhost.localdomain ~]$ echo $[value+1]
11
[scott@localhost.localdomain ~]$ num=$[10*10]
[scott@localhost.localdomain ~]$ echo $num
100
#不支持小数运算
[scott@localhost.localdomain ~]$ echo $[1.1+1]
-bash: 1.1+1: syntax error: invalid arithmetic operator (error token is ".1+1")
~~~

（2）[ ] 为test的另一种形式，bash的内置命令

[ ]中括号内左侧和右侧必须存在空格

大于号和小于号必须要转义，否则会被解释为重定向

==除了赋值不允许有空格，其他场景都要使用空格分隔==

~~~shell
[scott@localhost.localdomain ~]$ num1=10
[scott@localhost.localdomain ~]$ num2=20
[scott@localhost.localdomain ~]$ if [ $num1 == $num2 ];then echo "match";else echo "not match";fi
not match
[scott@localhost.localdomain ~]$ if [ $num1 != $num2 ];then echo "match";else echo "not match";fi
match
#运算符两边要使用空格分隔
[scott@localhost.localdomain ~]$ if [ $num1!=$num2 ];then echo "match";else echo "not match";fi
match
#数字比较推荐使用-gt、-lt等运算符
[scott@localhost.localdomain ~]$ if [ $num1 \> $num2 ];then echo "match";else echo "not match";fi
not match
[scott@localhost.localdomain ~]$ if [ $num1 \< $num2 ];then echo "match";else echo "not match";fi
match
~~~

### 3、let

let用于数学运算

~~~shell
[scott@localhost.localdomain ~]$ num=10
[scott@localhost.localdomain ~]$ let num=num+1
[scott@localhost.localdomain ~]$ echo $num
11
~~~

### 4、expr

expr用于数学运算

~~~shell
[scott@localhost.localdomain ~]$ expr 1 + 2
3
[scott@localhost.localdomain ~]$ echo $(expr 1 + 2)
3
[scott@localhost.localdomain ~]$ value=$(expr 1 + 2)
[scott@localhost.localdomain ~]$ echo $value
3
[scott@localhost.localdomain ~]$ expr 10 / 3
3
[scott@localhost.localdomain ~]$ expr 10 % 3
1
~~~

### 5、[[ ]]

(1)[[ ]]是[ ]的增强，并不是一个命令

[[ ]]中不再需要对大于号和小于号进行转义

~~~shell
[scott@localhost.localdomain ~]$ num1=10
[scott@localhost.localdomain ~]$ num2=20
[scott@localhost.localdomain ~]$ if [[ $num1 < $num2 ]];then echo "match";else echo "not match";fi
match
[scott@localhost.localdomain ~]$ if [[ $num1 > $num2 ]];then echo "match";else echo "not match";fi
not match
~~~

(2)支持字符串的模式匹配

正则匹配：[[ hello =~ [a-z]{5} ]]

~~~shell
[scott@localhost.localdomain ~]$ [[ "hello" =~ [a-z]{5} ]] && echo "match" || echo "not match"
match
[scott@localhost.localdomain ~]$ [[ "hello" =~ [abc]{5} ]] && echo "match" || echo "not match"
not match
# =~ 正则匹配，是部分匹配，而不是完整匹配
[scott@localhost.localdomain ~]$  [[ "hello123" =~ [a-z]{5} ]] && echo "match" || echo "not match"
match
[scott@localhost.localdomain ~]$ [[ "hello" =~ * ]] && echo "match" || echo "not match"
not match
[scott@localhost.localdomain ~]$ [[ "hello" =~ .* ]] && echo "match" || echo "not match"
match
~~~

shell中模式匹配只支持三个字符：*（任意多个字符）、?（单个字符）、[ ]（匹配包含的任意一个字符）

模式匹配：[[ hello == hell? ]]

~~~shell
[scott@localhost.localdomain ~]$ [[ "hello" == hell? ]] && echo "match" || echo "not match"
match
#模式匹配不能加双引号
[scott@localhost.localdomain ~]$ [[ "hello" == "hell?" ]] && echo "match" || echo "not match"
not match
[scott@localhost.localdomain ~]$ [[ "helloworld" == hell? ]] && echo "match" || echo "not match"
not match
[scott@localhost.localdomain ~]$ [[ "helloworld" == hell* ]] && echo "match" || echo "not match"
match
[scott@localhost.localdomain ~]$ [[ "hello" == hell[abc] ]] && echo "match" || echo "not match"
not match
[scott@localhost.localdomain ~]$ [[ "hello" == hell[opq] ]] && echo "match" || echo "not match"
match
~~~

### 6、数值比较

| 比较    | 描述       |
| ------- | ---------- |
| a -eq b | a等于b     |
| a -ne b | a不等于b   |
| a -gt b | a大于b     |
| a -ge b | a大于等于b |
| a -lt b | a小于b     |
| a -le b | a小于等于b |

### 7、字符串比较

| 比较   | 描述                    |
| ------ | ----------------------- |
| a == b | 字符串相等，也可以使用= |
| a != b | 字符串不等              |
| -n a   | 字符串长度非0           |
| -z a   | 字符串长度为0           |

### 8、文件比较

| 比较    | 描述               |
| ------- | ------------------ |
| -d file | file是否是一个目录 |
| -f file | file是否是一个文件 |
| -e file | file是否存在       |
| -r file | file是否可读       |
| -w file | file是否可写       |
| -x file | file是否可执行     |
| -s file | file是否有内容     |

~~~shell
[scott@localhost.localdomain ~]$ ll
total 8
-rw-rw-r--. 1 scott scott  0 Nov 24 20:57 empty.txt
-rw-rw-r--. 1 scott scott  5 Nov 23 23:24 test.pid
[scott@localhost.localdomain ~]$ [ -s empty.txt ] && echo yes || echo no
no
[scott@localhost.localdomain ~]$ [ -s test.sh ] && echo yes || echo no
yes
~~~

### 9、逻辑运算

==&&和||只能在[[ ]]中使用==

| 符号             | 作用                                   |
| ---------------- | -------------------------------------- |
| 命令1 ; 命令2    | 命令1和命令2顺序执行，之间没有逻辑关系 |
| 命令1 && 命令2   | 命令1执行成功($?=0)，命令2才会执行     |
| 命令1 \|\| 命令2 | 命令1执行失败($?!=0)，命令2才会执行    |

### 10、布尔运算符

假定变量 a 为 10，变量 b 为 20

==-a和-o只能在[ ]和test中使用==

| 符号 | 描述                                                         |
| ---- | ------------------------------------------------------------ |
| !    | 非运算，表达式为 true 则返回 false，否则返回 true。[ ! false ] 返回 true。 |
| -o   | 或运算，有一个表达式为 true 则返回 true。[ $a -lt 20 -o $b -gt 100 ] 返回 true。 |
| -a   | 与运算，两个表达式都为 true 才返回 true。[ $a -lt 20 -a $b -gt 100 ] 返回 false。 |

## 五、结构化命令

==在Shell脚本中，所有条件判断(比如if语句、while语句)都以0退出状态码表示True，以非0退出状态码为False。==

### 1、if-then

if 后的命令退出状态码为0时，执行then的语句

~~~markdown
if command
then
  commands
fi
~~~

~~~shell
#!/bin/bash
if pwd
then
  echo "match"
fi
~~~

### 2、if-then-else

if 后的命令退出状态码为0时，执行then的语句；否则执行else的语句。

~~~markdown
if command
then
  commands
else
  commands
fi
~~~

~~~shell
#!/bin/bash
#判断参数是否是数字
expr "$1" + 0 &> /dev/null
if [ $? -ne 0 ]
then
  echo "参数非数字，程序退出"
  exit 1
fi

if [ "$1" -ge 60 ]
then
  echo "pass"
else
  echo "not pass"
fi

#执行
[scott@localhost.localdomain ~]$ sh test.sh
参数非数字，程序退出
[scott@localhost.localdomain ~]$ sh test.sh 1
not pass
[scott@localhost.localdomain ~]$ sh test.sh 70
pass
~~~

### 3、if-then-elif-then-fi

~~~shell
if command
then
  commands
elif command2
then
  commands
...
fi
~~~

~~~shell
#!/bin/bash
if [ $# -eq 0 ]
then
  echo "请传入年龄，类型：整数"
  exit 1
fi

age=$1

if [ $age -gt 84 ]
then
  echo "高寿"
elif [ $age -gt 60 ]
then
  echo “老年”
elif [ $age -gt 35 ]
then
  echo "中年"
elif [ $age -ge 18 ]
then
  echo "青年"
else
  echo "未成年"
fi
~~~

### 4、test

~~~markdown
if test condition
then
  commands
fi
~~~

~~~shell
#!/bin/bash
value=$1
if test "X$value" = "Xhello"
then
  echo "match"
else
  echo "not match"
fi
~~~

### 5、case

~~~markdown
case variable in
pattern1 | pattern2) commands1;;
pattern3) commands2;;
*) default commands;;
esac
~~~

~~~shell
#!/bin/bash
value=$1
case $value in
1)
  echo 1;;
2)
  echo 2;;
3|4)
  echo "3 or 4";;
*)
 echo "not in 1、2、3、4";;
esac
~~~

### 6、for

~~~shell
for var in list
do
  command
done
~~~

~~~shell
#遍历参数
#!/bin/bash
for i in "$@"
do
  echo $i
done

[scott@localhost.localdomain ~]$ sh test.sh tom "zhang san" jerry
tom
zhang san
jerry
~~~

~~~shell
#遍历变量中空格分隔的值
#!/bin/bash
list="a b c d e"

for i in $list
do
  echo $i
done
echo

[scott@localhost.localdomain ~]$ sh test.sh
a
b
c
d
e
~~~

~~~shell
#读取文件内容
#!/bin/bash
#修改分割符
IFS=$'\n'
for i in $(cat hello.txt)
do
  echo $i
done

[scott@localhost.localdomain ~]$ cat hello.txt
hello
hello world
hello linux
hello shell
[scott@localhost.localdomain ~]$
[scott@localhost.localdomain ~]$ sh test.sh
hello
hello world
hello linux
hello shell
~~~

~~~shell
#遍历目录下的文件
#!/bin/bash
for file in /root/* /var/log/*log
do
  echo $file
done

[root@localhost.localdomain ~]# sh test.sh
/root/anaconda-ks.cfg
/root/test.sh
/var/log/boot.log
/var/log/lastlog
/var/log/maillog
/var/log/tallylog
/var/log/yum.log
~~~

**C语言风格的for循环**

~~~shell
#!/bin/bash
sum=0
for ((i=1;i<=100;i++))
do
  sum=$((sum+i))
done
echo $sum

[root@localhost.localdomain ~]# sh test.sh
5050
~~~

### 6、while

~~~markdown
while tes command
do
  commands
done
~~~

~~~shell
#!/bin/bash
sum=0
index=1
while [ $index -le 100 ]
do
# 等价于 sum=$[sum+index] 或 sum=$(expr $sum + $index)
  sum=$((sum+index))
  index=$((index+1))
done
echo $sum
~~~

### 7、until

~~~markdown
until test command
do 
  commands
done
~~~

~~~shell
#!/bin/bash
sum=0
index=1
until [ $index -gt 100 ]
do
  sum=$((sum+index))
  index=$((index+1))
done
echo $sum
~~~

### 8、break、continue

~~~shell
#!/bin/bash
sum=0
i=1
while [ $i -le 100 ]
do
  if [ $i -eq 50 ]
  then
    i=$((i+1))
#   break
    continue
  fi
  sum=$((sum+i))
  i=$((i+1))
done
echo $sum
~~~

## 六、函数

### 1、函数定义

~~~shell
#函数名和 { 之间至少要有一个空格
#方式一：使用function关键字，函数名后没有小括号（推荐方式）
function name {
  commands
}

#方式二：函数名后使用小括号，表示一个函数
name() {
  commands
}
~~~

~~~shell
#!/bin/bash
function test {
  echo "shell"
  echo "function"
}


echo 1
test
echo 2

#运行
[scott@localhost.localdomain ~]$ sh test.sh
1
shell
function
2
~~~

### 2、返回值

#### （1）默认返回

默认使用函数中最后一条命令的结果作为函数的退出状态码

~~~shell
[scott@localhost.localdomain ~]$ sh test.sh
shell
function
0
[scott@localhost.localdomain ~]$ sh test.sh
shell
function
test.sh: line 5: cd: /abc: No such file or directory
1
~~~

#### （2）return返回

使用return返回，退出状态码的范围 0 ~ 255

~~~shell
#!/bin/bash
function test {
  value=$(date +%s)
  if (( $value % 2 == 0 ))
  then
    return 0
  else
    return 1
  fi
}


test
echo $?
~~~

#### （3）函数输出赋值

**将函数处理的结果赋值给变量保存**

~~~shell
#!/bin/bash
function test {
  num=1
  sum=0
  while [[ $num -le 100 ]]
  do
    sum=$((num + sum))
    num=$((num + 1))
  done
  echo $sum
}

value=$(test)
echo
echo $value

#运行
[scott@localhost.localdomain ~]$ sh test.sh

5050
~~~

### 3、传参

- 函数使用时，直接传参

~~~shell
#!/bin/bash
function test {
  # 判断参数个数
  if [[ $# -lt 2 ]]
  then
    echo "参数不足2个"
    return 1
  fi
  # $1 和 $2 表示函数接收的第一个参数和第二个参数
  echo $(($1 + $2))
}

test 1 2

#运行
[scott@localhost.localdomain ~]$ sh test.sh
3
~~~

在函数调用时，将脚本的参数传入函数中

~~~shell
#!/bin/bash
function test {
  # 检查函数的参数个数
  if [[ $# -lt 2 ]]
  then
    echo "参数不足2个"
    return 1
  fi

  echo $(($1 + $2))
}

function check {
  # 检查脚本执行的参数个数
  if [[ $# -lt 2 ]]
    then
      echo "脚本参数不足2个"
      exit
  fi
}

check "$@"
test $1 $2
~~~

### 4、函数中变量

函数中定义的变量默认是全局的，函数外也可以使用

~~~shell
#!/bin/bash
function test {
  value=100
}

test
echo $value

#运行
[scott@localhost.localdomain ~]$ sh test.sh
100
~~~

使用local可以将函数内定义的变量声明为局部变量，只能在函数内使用

~~~shell
#!/bin/bash
function test {
  #声明局部变量
  local value=100
}

test
#局部变量在函数外无法被获取
echo $value

#运行
[scott@localhost.localdomain ~]$ sh test.sh

[scott@localhost.localdomain ~]$
~~~

### 5、数组与函数

==函数传参，建议参数使用双引号括起来，防止参数中存在空格，导致认为多个参数==

#### （1）传参数组

~~~shell
#!/bin/bash
function test {
  echo "param size:$#"
  #函数内使用变量接收数组
  #$@必须使用双引号括起来，防止将存在空格的参数认为多个参数
  local array=("$@")
  for i in "${array[@]}"
  do
    echo $i
  done
}

arr=(1 2 "3 4" 5)
#函数传参数组必须使用${arr[@]，使用$arr只会传递数组中第一个元素
#函数传参数组实际上分为多个参数传递
test "${arr[@]}"

#运行
[scott@localhost.localdomain ~]$ sh test.sh
param size:4
1
2
3 4
5
~~~

#### （2）返回数组

==函数返回字符串，通过echo命令返回，导致返回字符串中存在空格被消除，造成结果异常==

==返回数组时，实际上推荐使用全局变量返回==

~~~shell
#!/bin/bash
function test {
  local array=(11 "22 33" 44 55)
  #数组传递，必须通过遍历的方式，直接传递（result=${array[@]}）将导致引号的丢失
  for i in "${!array[@]}"
  do
    result[$i]=${array[$i]}
  done
}

test

echo "result size:${#result[@]}"
for i in "${result[@]}"
do
  echo $i
done

#运行
[scott@localhost.localdomain ~]$ sh test.sh
result size:4
11
22 33
44
55
~~~

### 6、递归函数

~~~shell
#!/bin/bash
function test {
  if [ $1 -eq 1 ]
  then
    echo 1
  else
    # $1+(test $1-1)
    local num=$(($1 - 1))
    #函数输出赋值
    local value=$(test $num)
    echo $(($1 + value))
  fi
}

test 100

#运行
[scott@localhost.localdomain ~]$ sh test.sh
5050
~~~

### 7、脚本相互调用

使用source命令不开启子shell

==使用 “ . ./math.sh ”的方式，脚本必须有执行权限==

~~~shell
# math.sh
#!/bin/bash

function add {
  local value=$[ $1 + $2 ]
  echo $value
}
~~~

~~~shell
# test.sh
#!/bin/bash
. ./math.sh

num=$(add 10 20)
echo "num is $num"
~~~

~~~shell
#运行
[scott@localhost.localdomain ~]$ sh test.sh
num is 30
~~~

### 8、命令行上定义函数

#### （1）临时定义

函数名不能和已有命令重复，否则将覆盖已有命令

- 单行定义，每个语句后都需要使用分号

~~~shell
[scott@localhost.localdomain ~]$ function add { local value=$[ $1 + $2 ] ; echo $value ; }
[scott@localhost.localdomain ~]$ add 1 2
3
~~~

- 多行定义

~~~shell
[scott@localhost.localdomain ~]$ function sub {
> local value=$[ $1 - $2 ]
> echo $value
> }
[scott@localhost.localdomain ~]$ sub 100 10
90
~~~

#### （2）永久定义

在 .bashrc 文件中定义函数或者引入库函数

- 定义函数

  在.bashrc中定义函数和在普通sh文件中定义函数一样

- 引入库文件

  在.bashrc中直接引入库文件 . /home/scott/math.sh

~~~shell
[root@localhost.localdomain ~]# su - scott
Last login: Thu Nov 25 02:52:00 CST 2021 on pts/0
[scott@localhost.localdomain ~]$ add 10 20
30
~~~

## 七、重定向

在Linux系统中，每个程序默认都会打开三个文件描述符(file descriptor,fd)：

fd=0：标准输入，标准输入是/dev/stdin文件
fd=1：标准输出，标准输出是/dev/stdout文件
fd=2：标准错误，标准错误是/dev/stderr文件

### 1、输入重定向

| 语法               | 功能                                               |
| ------------------ | -------------------------------------------------- |
| 命令 < 文件1       | 命令把文件1的内容作为标准输入设备                  |
| 命令 << 标识符     | 命令从标准输入中读入内容，直到遇到“标识符”为止     |
| 命令< 文件1 >文件2 | 命令把文件1的内容作为标准输入，把文件2作为标准输出 |
| 命令 <<< 字符串    | 命令将字符串的内容作为标准输入                     |

~~~shell
# <
[scott@localhost.localdomain ~]# cat hello.txt
abc
[scott@localhost.localdomain ~]# cat < hello.txt
abc
# <<，支持变量和命令解析
[scott@localhost.localdomain ~]$ value=1
[scott@localhost.localdomain ~]$ cat << EOF
> 10
> $value
> 11
> EOF
10
1
11
# 标记符使用引号，则不解析变量和命令
[scott@localhost.localdomain ~]$ cat << "EOF"
10
$value
11
EOF
10
$value
11
# < >
[scott@localhost.localdomain ~]# cat < hello.txt > world.txt
[scott@localhost.localdomain ~]# cat hello.txt
abc
[scott@localhost.localdomain ~]# cat world.txt
abc
# <<<
[scott@localhost.localdomain ~]$ grep -o '[0-9]*' <<< abc123cde
123
#以上命令等价管道方式
[scott@localhost.localdomain ~]$ echo abc123cde | grep -o '[0-9]*'
123
[scott@localhost.localdomain ~]$ cat <<< abc123cde
abc123cde
~~~

### 2、输出重定向

| 符号                   | 作用                                          |
| ---------------------- | --------------------------------------------- |
| 命令 > 文件            | 覆盖方式，命令正确结果输出到文件              |
| 命令 >> 文件           | 追加方式，命令正确结果输出到文件              |
| 命令 2> 文件           | 覆盖方式，命令错误结果输出到文件              |
| 命令 2>> 文件          | 追加方式，命令错误结果输出到文件              |
| 命令 > 文件 2>&1       | 覆盖方式，命令正确和错误结果i输出到同一个文件 |
| 命令 >> 文件 2>&1      | 追加方式，命令正确和错误结果i输出到同一个文件 |
| 命令 &> 文件           | 覆盖方式，命令正确和错误结果i输出到同一个文件 |
| 命令 &>> 文件          | 追加方式，命令正确和错误结果输出到同一个文件  |
| 命令 >> 文件1 2>>文件2 | 追加方式，命令正确和错误结果输出到不同文件    |

### 3、/dev/null

输出到 /dev/null 的内容将全部丢弃，不需要显示输出时，可以重定向到该文件

### 4、tee

从标准输入读取，输出到多个文件中

~~~shell
#输出到标准设备，并写入多个文件后，过滤
[scott@localhost.localdomain ~]$ echo "hello world" | tee a.txt b.txt | grep hello
hello world
[scott@localhost.localdomain ~]$ cat a.txt
hello world
[scott@localhost.localdomain ~]$ cat b.txt
hello world
~~~

### 5、进程替换

进程替换和命令替换非常相似。命令替换是把一个命令的输出结果赋值给另一个变量，而进程替换则是把一个命令的输出结果传递给另一个（组）命令。

==其实，每个进程替换都是一个虚拟文件，只不过这个文件的内容是由cmd命令产生的(<(cmd))或被cmd命令读取的(>(cmd))。==

commands 是一组命令列表，多个命令之间以分号`;`分隔。<`或`>与圆括号之间是没有空格的。

| 符号        | 作用                                                       |
| ----------- | ---------------------------------------------------------- |
| <(commands) | 它借助于输入重定向，可以将它的输出结果作为另一个命令的输入 |
| >(commands) | 它借助于输出重定向，可以接受另一个命令的标准输出结果       |

~~~shell
# 先执行ls命令，结果写入临时文件，作为cat命令的参数
[scott@localhost.localdomain ~]$ cat <(ls)
empty.txt
hello.txt
math.sh
test.pid
test.sh
# 先执行ls命令，结果写入临时文件，作为wc -l的参数
[scott@localhost.localdomain ~]$ ls > >(wc -l)
5
[scott@localhost.localdomain ~]$ ls > >(cat)
empty.txt
hello.txt
math.sh
test.pid
test.sh
~~~

### 6、其他

~~~shell
#清空文件
> 文件名
~~~

~~~shell
#对文件和标准输出进行操作，-表示标准输出
[scott@localhost.localdomain ~]$ echo myshell | grep "shell" hello.txt -
hello.txt:hello shell
(standard input):myshell
~~~

## 八、子Shell

### 1、创建子shell

- 小括号分组 (...)
- 命令替换 `...` 和 $(...)
- 进程替换 <() 和 >()
- 管道 ... | ...
- 后台命令 ... &

真正的子 Shell 可以访问其父 Shell 的任何变量，在Bash中打开另一个Bash，重新打开的那个Bash并不属于子Shell

- SHLVL 是记录多个 Bash 进程实例嵌套深度的累加器

- BASH_SUBSHELL 是记录一个 Bash 进程实例中多个子 Shell（subshell）嵌套深度的累加器。

~~~shell
#每创建一个bash进程，SHLVL变量就累加
[scott@localhost.localdomain ~]$ echo $SHLVL  $BASH_SUBSHELL
1 0
[scott@localhost.localdomain ~]$ bash
[scott@localhost.localdomain ~]$ echo $SHLVL  $BASH_SUBSHELL
2 0
[scott@localhost.localdomain ~]$ bash
[scott@localhost.localdomain ~]$ echo $SHLVL  $BASH_SUBSHELL
3 0
#每创建一个子shell，BASH_SUBSHELL变量就累加
[scott@localhost.localdomain ~]$ echo $SHLVL  $BASH_SUBSHELL
3 0
[scott@localhost.localdomain ~]$ (echo $SHLVL  $BASH_SUBSHELL)
3 1
[scott@localhost.localdomain ~]$ ( (echo $SHLVL  $BASH_SUBSHELL) )
3 2
~~~

### 2、不创建子shell

- { }不会创建子shell

~~~shell
# 大括号组合的多个命令是在当前Shell中执行
# 大括号语法特殊，要求：
#   1.开闭括号旁边都有空白，否则语法解析错误(解析成大括号扩展)
#   2.写在同一行时，每个cmd后都要加分号结尾
#   3.多个命令可分行书写，不要求分号结尾
{ cmd1;cmd2;cmd3; }
{
  cmd1
  cmd2
  cmd3
}
~~~

- source不会创建子shell

## 九、正则表达式

### 1、扩展正则

扩展正则不再需要转义基础正则中指定的字符。支持扩展正则的命令：grep -E、sed -r、awk

| 基础正则BRE | 扩展正则ERE |
| ----------- | ----------- |
| \?          | ?           |
| \\+         | +           |
| \\{\\}      | {}          |
| \\(\\)      | ()          |

### 2、分组捕获

基础正则中，使用括号可以对匹配内容进行分组并暂时保存，分组后会有分组编号，可以使用反斜线加编号\N的方式反向引用这些分组。

~~~shell
#匹配两个连续相同的字母
[scott@localhost.localdomain ~]$ echo "aabcddefg" | grep -E "(.)\1"
aabcddefg
[scott@localhost.localdomain ~]$ echo "aabcddefg" | grep -o -E "(.)\1"
aa
dd
~~~

## 十、Shell技巧

### 1、生成随机数

~~~shell
# 8位字母数字特殊字符组成的随机数
tr -cd '0-9a-zA-Z~!@#$%^&*_\-+=?' < /dev/urandom | head -c 8
~~~
