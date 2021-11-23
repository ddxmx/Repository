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

### （1）定义环境变量

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

### （2）取消环境变量

使用unset取消全局和局部变量

~~~shell
[scott@localhost.localdomain ~]$ export name=zhangsan
[scott@localhost.localdomain ~]$ echo $name
zhangsan
[scott@localhost.localdomain ~]$ unset name
[scott@localhost.localdomain ~]$ echo $name

~~~

### （3）环境变量初始化与文件生效顺序

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

### （1）定义本地变量

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

### （2）命令的结果赋值变量

==命令替换会创建一个子shell来运行对应的命令==

~~~shell
#方式一
变量名=`命令`
#方式二（推荐）
变量名=$(命令)
~~~

### （3）变量表示

~~~shell
#方式一
echo $name
#方式二，当变量后连接其他字符时，必须使用${}表示边界
echo ${name}
~~~

### 3、特殊变量

### （1）$0、$n、$#、$*、$@、$?、$$

| 位置变量 | 作用                                                         |
| -------- | ------------------------------------------------------------ |
| $0       | 获取shell脚本文件名，"./脚本名" 时为 ./脚本名，"sh 脚本名" 时为 脚本名 |
| $n       | 获取shell脚本的第n个参数，n大于9时，需要使用如 ${10}的方式   |
| $#       | 获取shell脚本参数个数                                        |
| $*       | 获取shell脚本所有传参，不加双引号和$@相同，加双引号"$*"，将所有参数作为单个字符串 |
| $@       | 获取shell脚本所有传参，不加双引号和$*相同，加双引号"$@"，每个参数作为独立的字符串。<br />不加双引号时，参数中包含双引号的参数会被拆分为多个参数。<br />如遍历参数，执行sh test.sh "a b" 1 2，将分别打印 a、b、1、2，所以使用时一定要加上双引号 |

### （2）dirname（获取脚本路径）

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

### （3）basename（获取脚本名称）

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

### （1）eval

执行eval语句时，shell读入参数，并将它们组合成一个新的命令并执行

  ~~~shell
  [scott@localhost.localdomain ~]$ eval $(echo date)
  Mon Nov 15 00:26:54 CST 2021
  ~~~

### （2）shift 

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

## 三、运算符

### 1、双小括号(())

(( ))允许使用高级数学表达式。进行数值运算和数值比较，只能操作整数

命令执行时不需要加$，输出时需要加$

如果表达式的结果为0，那么返回的退出状态码为1，或者 是"假"，而一个非零值的表达式所返回的退出状态码将为0，或者是"true"

- ((i=i+1))：先运算后赋值，将 i+1 的值赋值给 i

- i=$((i+1))：i+1的值计算后，赋值给 i

- ((8>7 && 5==5))：用于条件判断，结果为1，表示true

- echo $((2+1))：输出计算的结果

- ((a++))：返回后自增

- ((--a))：自减后返回

- value=10;echo $((value+1))：支持使用变量计算

- let i=1+1;echo $i：let命令等同于(())

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
#不支持单独使用
[scott@localhost.localdomain ~]$ [1+2]
-bash: [1+2]: command not found
~~~

（2）[ ] 为test的另一种形式，bash的内置命令

[ ]中括号内左侧和右侧必须存在空格

大于号和小于号必须要转义，否则会被解释为重定向

[ $num1 == $num2 ]

### 3、[[ ]]

(1)[[ ]]是[ ]的增强，并不是一个命令

[[ ]]中不再需要对大于号和小于号进行转义

(2)支持字符串的模式匹配

正则匹配：[[ hello =~ [a-z]{5} ]]

[[ hello == hell? ]]

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

### 5、read

read -p 提示信息 -t 超时时间 多个变量名

~~~shell
[scott@localhost.localdomain ~]# read -p "请输入2个数字：" -t 10 num1 num2
请输入2个数字：1 2
[scott@localhost.localdomain ~]# echo $num1
1
[scott@localhost.localdomain ~]# echo $num2
2
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

| 比较   | 描述          |
| ------ | ------------- |
| a = b  | 字符串相等    |
| a != b | 字符串不等    |
| -n a   | 字符串长度非0 |
| -z a   | 字符串长度为0 |

### 8、文件比较

| 比较    | 描述               |
| ------- | ------------------ |
| -d file | file是否是一个目录 |
| -f file | file是否是一个文件 |
| -e file | file是否存在       |
| -r file | file是否可读       |
| -w file | file是否可写       |
| -x file | file是否可执行     |
| -s file | file是否内容为空   |

### 9、逻辑运算

| 符号                       | 描述   |
| -------------------------- | ------ |
| condition1 && condition2   | 与关系 |
| condition1 \|\| condition2 | 或关系 |

~~~shell
[scott@localhost.localdomain ~]$ [ 1 -eq 1 ] && echo yes || echo no
yes
[scott@localhost.localdomain ~]$ [ 1 -eq 2 ] && echo yes || echo no
no
~~~

| 符号             | 作用                                   |
| ---------------- | -------------------------------------- |
| 命令1 ; 命令2    | 命令1和命令2顺序执行，之间没有逻辑关系 |
| 命令1 && 命令2   | 命令1执行成功($?=0)，命令2才会执行     |
| 命令1 \|\| 命令2 | 命令1执行失败($?!=0)，命令2才会执行    |

### 10、布尔运算符

假定变量 a 为 10，变量 b 为 20，用于在 [ ]中使用

| 符号 | 描述                                                         |
| ---- | ------------------------------------------------------------ |
| !    | 非运算，表达式为 true 则返回 false，否则返回 true。[ ! false ] 返回 true。 |
| -o   | 或运算，有一个表达式为 true 则返回 true。[ $a -lt 20 -o $b -gt 100 ] 返回 true。 |
| -a   | 与运算，两个表达式都为 true 才返回 true。[ $a -lt 20 -a $b -gt 100 ] 返回 false。 |

## 四、结构化命令

### 1、if-then

==if 后的命令退出状态码为0时，执行then的语句==

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

==数字比较切记不能使用 >、<、>=、<=等运算符，因此他们返回的结果为0==

~~~shell
[scott@localhost.localdomain ~]$ [ 3 > 1 ]
[scott@localhost.localdomain ~]$ echo $?
0
[scott@localhost.localdomain ~]$ [ 3 < 1 ]
[scott@localhost.localdomain ~]$ echo $?
0
[scott@localhost.localdomain ~]$ [ 3 -eq 1 ]
[scott@localhost.localdomain ~]$ echo $?
1
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
 echo "not in 1、2、3、4"
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

## 五、重定向

### 1、输入重定向

| 语法               | 功能                                               |
| ------------------ | -------------------------------------------------- |
| 命令 < 文件1       | 命令把文件1的内容作为标准输入设备                  |
| 命令 << 标识符     | 命令从标准输入中读入内容，直到遇到“标识符”为止     |
| 命令< 文件1 >文件2 | 命令把文件1的内容作为标准输入，把文件2作为标准输出 |

~~~shell
# <
[scott@localhost.localdomain ~]# cat hello.txt
abc
[scott@localhost.localdomain ~]# cat < hello.txt
abc
# <<
[scott@localhost.localdomain ~]# cat << EOF
> 11
> 22
> 33
> EOF
11
22
33
# < >
[scott@localhost.localdomain ~]# cat < hello.txt > world.txt
[scott@localhost.localdomain ~]# cat hello.txt
abc
[scott@localhost.localdomain ~]# cat world.txt
abc
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
