# Linux

## 第一章

### 1、退出命令行

exit、logout、ctrl + d

### 2、获取当前登录用户

whoami

### 3、获取主机名称

hostname

### 4、命令提示符由PS1变量控制

可以通过在/etc/profile中添加PS1变量定义来设置全局的命令提示符，/etc/bashrc文件中对PS1变量也进行了定义

export PS1='[\u@\H \w]\$ '

### 5、常用快捷键

ctrl + a	光标到行首

ctrl + e	光标到行尾

ctrl + u	删除行首到光标位置

ctrl + k	删除光标位置到行尾

ctrl + w	删除光标位置前的一个单词

ctrl + l	清屏

ctrl + z	暂停终端运行的程序

Esc + .	获取上一条命令最后的部分

### 6、man的用法

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

### 7、help命令

help命令用于查询内置命令的帮助信息

**help cd**

### 8、关机、重启

shutdown -r now	立即重启

shutdown -h now	立即关机

shutdown -h +1		1分钟后关机

shutdown -h 10:30	10:30关机

shutdown -c				取消关机计划

## 第二章

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

### 3、mkdir

mkdir -p a/b/c	递归创建多级目录

**{}的使用**

```shell
[root@promote.cache-dns.local ~]# echo a{b,c}
ab ac
[root@promote.cache-dns.local ~]# echo a{,c}
a ac
[root@promote.cache-dns.local ~]# echo 2020-{1..12}-1
2020-1-1 2020-2-1 2020-3-1 2020-4-1 2020-5-1 2020-6-1 2020-7-1 2020-8-1 2020-9-1 2020-10-1 2020-11-1 2020-12-1
```

### 4、touch

作用：

* 创建一个空文件

- 刷新文件的时间戳

### 5、ls

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

-F	使用标记标识不同类型文件，/ 是目录，@ 是链接文件

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

### 6、cp

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

### 7、mv

mv 源文件 目标路径（目录或文件） 

-f	目标文件存在，强制覆盖

-i 	覆盖文件前询问，root用户mv命令是别名：alias mv='mv -i'

-t	类似cp命令中的 -t 参数，调换参数位置

| 源文件             | 目标文件 | 结果                    |
| ------------------ | -------- | :---------------------- |
| 一个文件A          | 目录B    | A移动到目录B中          |
| 多个文件A1、A2、A3 | 目录B    | A1、A2、A3移动到目录B中 |
| 一个文件A          | 文件B    | A重命名为B              |
| 多个文件A1、A2、A3 | 文件B    | ==命令错误==            |
| 一个目录D          | 目录B    | D重命名为B              |
| 多个目录D1、D2、D3 | 目录B    | D1、D2、D3移动到目录B   |

### 8、rm

rm可以删除文件和目录，已经替代了删除空目录的命令 rmdir

-f	强制删除，不询问

-i	删除前询问，root用户rm命令是别名：alias rm='rm -i'

-r	递归删除

删除文件时不要携带 -r参数，很危险而且没有必要

### 9、ln

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

==硬链接的inode节点和源文件一致，表示指向同一块空间，硬链接只能作用在文件上，且不能跨分区。实际上是对源文件做了备份，会同步修改。只要硬链接的个数不为0，则源文件就不会被真正删除。==

==软连接的inode节点和源文件不同，类似于windows中的快捷方式，权限全部为rwx，并不是实际源文件的权限。软链接类似于一个文本文件，里面存放源文件路径。删除源文件将导致软链接无法正常使用。==

==删除软链接可以使用"rm -rf 软链接名"的方式，但是要注意软链接名后不可以有"/"，存在"/"将导致软链接中的文件被全部删除==

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

[root@promote.cache-dns.local ~/service]# ll
total 0
lrwxrwxrwx. 1 root root 8 Sep 23 23:33 version -> version2
drwxr-xr-x. 2 root root 6 Sep 23 23:29 version1
drwxr-xr-x. 2 root root 6 Sep 23 23:32 version2
```

业务通过version路径访问，此时存在新版本version2时，只需要删除原软链接，创建一个名为verison指向version2的软链接即可。

### 10、readlink

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

### 11、find





