# Shell

## 一、Shell入门

shell是一个命令解释器，存在于操作系统最外层，负责将用于的输入解释给操作系统。

### 1、查看用户当前shell类型

```shell
[scott@localhost.localdomain ~]$ echo $SHELL
/bin/bash
```

```shell
[scott@localhost.localdomain ~]$ cat /etc/passwd | grep $(whoami)
scott:x:1000:1000::/home/scott:/bin/bash
```

### 2、脚本开头

```shell
#!/bin/bash
```

### 3、脚本执行方式

```shell
#脚本推荐执行方式
sh test.sh
#脚本必须有执行权限，通过chmod u+x test.sh方式添加执行权限
./test.sh
```

## 二、Shell变量

### 1、环境变量

变量分为两种：环境变量（全局变量）、普通变量（局部变量）

环境变量：可以在创建的shell及子shell中使用，==环境变量都是使用大写==

普通变量：只能在shell脚本或shell函数中使用

~~~shell
全局配置文件： /etc/profile 或 /etc/bashrc
用户配置文件：.bash_profile 或 .bashrc
.bash_profile文件中的变量在用户登录模式（su - xxx）下生效
.bashrc文件中的变量在用户登录模式和用户非登录模式（su xxx或ssh登录）下都生效
~~~

```shell
#env环境变量
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
```

```shell
#获取环境变量命令
set：输出所有的变量，包括全局变量和局部变量
env：只显示全局变量
[scott@localhost.localdomain ~]$ name='jerry'
[scott@localhost.localdomain ~]$
[scott@localhost.localdomain ~]$ set | grep name
name=jerry
[scott@localhost.localdomain ~]$ env | grep name
[scott@localhost.localdomain ~]$
```

#### （1）定义环境变量

临时配置方式：

```shell
#方式一
export 变量名=value
#方式二
变量名=value
export 变量名
```

永久配置方式：

~~~shell
#用户文件中配置
.bashrc（推荐）
.bash_profile
#全局配置文件
/etc/bashrc（推荐）
/etc/profile
/etc/profile.d（若要在登录后初始化或显示加载内容，把脚本文件放在该目录下）
~~~

#### （2）登录提示

- 在 /etc/motd 中配置
- 在 /etc/profile.d/ 下增加脚本

#### （3）取消环境变量

使用unset取消全局和局部变量

~~~shell
[scott@localhost.localdomain ~]$ export name=zhangsan
[scott@localhost.localdomain ~]$ echo $name
zhangsan
[scott@localhost.localdomain ~]$ unset name
[scott@localhost.localdomain ~]$ echo $name

[scott@localhost.localdomain ~]$
~~~

#### （4）环境变量初始化与文件生效顺序

```shell
#用户登录linux时(su - 用户名)，依次在以下文件中查找环境变量
/etc/profile
/etc/profile.d
$HOME/.bash_profile -> $HOME/.bashrc -> /etc/bashrc
#非登录方式（su 用户名或ssh连接）
 $HOME/.bashrc -> /etc/bashrc
```

### 2、普通变量

普通变量只在当前shell中有效。

### （1）定义本地变量

~~~shell
#普通变量一般有三种写法
变量名=value
变量名='value'
变量名="value"
a=192.168.1.2
#a=192.168.1.2-192.168.1.2，$a被解析成192.168.1.2
a=192.168.1.2-$a
#b=192.168.1.2-$a，单引号不解析变量、命令，原样输出，所见即所得
b='192.168.1.2-$a'
#c=192.168.1.2-192.168.1.2-192.168.1.2，双引号解析变量和命令，解析后再输出
c="192.168.1.2-$a"
echo "a=$a"
echo "b=$b"
echo "c=${c}"
~~~

### （2）将命令的结果作为变量内容赋值的方法

~~~shell
#方式一
变量名=`ls`
#方式二（推荐）
变量名=$(ls)
~~~

### （3）变量表示

~~~shell
#方式一
echo $name
#方式二，当变量后连接其他字符时，必须使用${}表示
echo ${name}
~~~

### 3、特殊变量

| 位置变量 | 作用                                                         |
| -------- | ------------------------------------------------------------ |
| $0       | 获取shell脚本文件名，"./脚本名" 时为 ./脚本名，"sh 脚本名" 时为 脚本名 |
| $n       | 获取shell脚本的第n个参数，n大于9时，需要使用如 ${10}的方式   |
| $#       | 获取shell脚本参数个数                                        |
| $*       | 获取shell脚本所有传参，不加双引号和$@相同，加双引号"$*"，将所有参数作为单个字符串 |
| $@       | 获取shell脚本所有传参，不加双引号，参数中包含双引号的参数也会被拆分为多个参数，加双引号"$@"，每个参数作为独立的字符串。<br />如sh test.sh "a b" 1 2，将分别打印 a、b、1、2，所以使用时一定要加上双引号 |

- dirname（获取脚本路径）

  ~~~shell
  [scott@localhost.localdomain ~]$ cat test.sh
  #!/bin/bash
  echo $(dirname $0)
  [scott@localhost.localdomain ~]$ ./test.sh
  .
  [scott@localhost.localdomain ~]$ /home/scott/test.sh
  /home/scott
  [scott@localhost.localdomain ~]$ sh test.sh
  .
  ~~~

- basename（获取脚本名称）

  ~~~shell
  [scott@localhost.localdomain ~]$ cat test.sh
  #!/bin/bash
  echo $(basename $0)
  [scott@localhost.localdomain ~]$ ./test.sh
  test.sh
  [scott@localhost.localdomain ~]$ /home/scott/test.sh
  test.sh
  [scott@localhost.localdomain ~]$ sh test.sh
  test.sh
  ~~~

| 位置变量 | 作用                                               |
| -------- | -------------------------------------------------- |
| $?       | 上个命令的执行状态返回值（0表示成功，非0表示失败） |
| $$       | 获取当前执行的shell脚本进程号                      |

### 4、Bash内置变量命令

  #### （1）echo

- -n：输出后不换行

  ~~~shell
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

#### （2）eval

执行eval语句时，shell读入参数，并将它们组合成一个新的命令并执行

  ~~~shell
  [scott@localhost.localdomain ~]$ eval $(echo date)
  Mon Nov 15 00:26:54 CST 2021
  ~~~

#### （3）exec

exec能够在不创建子shell的前提下，执行指定的命令

~~~shell
[scott@localhost.localdomain ~]$ exec date
Mon Nov 15 00:30:24 CST 2021
~~~

#### （4）read

#### （5）shift

每使用一次shift语句，所有位置参数向左移动一个位置，并使 $# 减1，直到为0。

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

### 5、shell字串

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
[root@localhost.localdomain ~]# info="helloworld"
#返回变量
[root@localhost.localdomain ~]# echo $info
helloworld
#返回变量长度
[root@localhost.localdomain ~]# echo ${#info}
10
#截取字串
[root@localhost.localdomain ~]# echo ${info:5}
world
[root@localhost.localdomain ~]# echo ${info:0:5}
hello
#字串操作并不会修改原变量
[root@localhost.localdomain ~]# echo $info
helloworld
[root@localhost.localdomain ~]# info="123abc123def"
[root@localhost.localdomain ~]# echo ${info#123}
abc123def
#删除字串操作，必须以删除的字串开头或结尾，否则不能正常删除
[root@localhost.localdomain ~]# echo ${info%123}
123abc123def
[root@localhost.localdomain ~]# echo ${info%def}
123abc123
[root@localhost.localdomain ~]# echo ${info#1*3}
abc123def
[root@localhost.localdomain ~]# echo ${info##1*3}
def
#字符串替换操作
[root@localhost.localdomain ~]# echo ${info/123/|}
|abc123def
[root@localhost.localdomain ~]# echo ${info//123/|}
|abc|def
~~~

