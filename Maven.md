# Maven

Maven是一个项目管理工具，它包含了一个项目对象模型（POM Project Object Model），一组标准集合，一个项目生命周期(Project LiftCycle)，一个依赖管理系统（Dependency Mainagement System）,和用来运行定义在声明周期阶段（phase）中插件（plugin）目标（goal）的逻辑。

实际上，主要做了两件事：

- 依赖管理

- 项目构建

## 一、Maven项目结构

   MavenProjectRoot(项目根目录)
    |----src
    |   |----main
    |   |     |----java ——存放项目的.java文件
    |   |     |----resources ——存放项目资源文件，如[spring](http://lib.csdn.net/base/javaee), [hibernate](http://lib.csdn.net/base/javaee)配置文件
    |   |----test
    |   |     |----java ——存放所有[测试](http://lib.csdn.net/base/softwaretest).java文件，如JUnit测试类
    |   |     |----resources ——存放项目资源文件，如spring, hibernate配置文件
    |----target ——项目输出位置
    |----pom.xml ——用于标识该项目是一个Maven项目 

## 二、Maven下载安装

maven下载地址：https://maven.apache.org/download.cgi

- 依赖 JAVA_HOME 环境变量
- 设置 MAVEN_HOME 为maven的安装路径
- 将 %MAVEN_HOME%\bin 加入Path
- 执行  mvn –v  验证安装

## 三、Maven仓库

maven依赖查询站点：https://mvnrepository.com/

Maven项目  ->  **本地仓库**  -> **远程仓库**  ->  **中央仓库**

### 1、本地仓库

存储从远程仓库或者中央仓库下载的插件和jar包，项目中需要使用的jar优先从本地仓库中获取。 

本地仓库的路径默认为：${user.home}/.m2/repository 

本地仓库的路径是可以修改的，只需要在config/settings.xml中添加本地仓库路径即可，即localRepository 

~~~xml
<!--  localRepository
   | The path to the local repository maven will use to store artifacts.
   |
   | Default: ${user.home}/.m2/repository
-->
<localRepository>/path/to/local/repo</localRepository>
~~~

### 2、远程仓库

若本地仓库中没有项目中要用的jar包，则从远程仓库获取。

公司内部搭建远程仓库，可以解决中央仓库访问慢的问题，同时还具有以下特点：

- 可以保存具有版权的资源
- 一定范围内共享资源，仅对内部开放，不对外共享

### 3、中央仓库

maven中内置了一个远程仓库地址 https://repo1.maven.org/maven2/ ，这个网址就是中央仓库，服务于整个互联网，里面保存了几乎所有的jar包

### 4、配置settings.xml

settings.xml 文件一般存在于以下两个位置，用户配置优先于全局配置

- 全局配置： ${maven.home}/conf/settings.xml

- 用户配置： ${user.home}/.m2/settings.xml

以下通过指定镜像仓库地址，用于代替默认的中央仓库地址。

~~~xml
<!-- 阿里云镜像 -->
<mirrors>
    <mirror>
        <id>aliyunmaven</id>
        <mirrorOf>central</mirrorOf>
        <name>aliyun maven</name>
        <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
</mirrors>
~~~

## 四、Maven常用命令

- mvn compile:maven工程编译指令，其作用是将src/main/java下的文件编译为class文件输出到target目录下

- mvn test:maven工程测试命令，执行src/test/java下的单元测试类

- mvn clean:maven工程的清理命令，执行clean会删除target目录及内容

- mvn package:maven工程的打包命令，将java工程打成jar包，将web工程打成war包

- mvn install:maven工程的安装命令，其作用是将jar包或war包发布到本地仓库

## 五、依赖管理

### 1、依赖的格式

~~~xml
<dependencies>
    <dependency>
    <!--项目组织唯一的标识符，一般为域名反写-->
  <groupId>javax.servlet</groupId>
    <!--项目的唯一的标识符，实际对应项目的名称-->
  <artifactId>servlet-api</artifactId>
    <!--版本号-->
  <version>2.5</version>
    <!--依赖作用的范围-->
  <scope>provided</scope>
</dependency>
</dependencies>
~~~

### 2、依赖传递

依赖具有传递性，包括直接传递和间接传递。

直接依赖：在当前项目中通过依赖配置建立的依赖关系（A依赖B，B就A的直接依赖）

间接依赖：被依赖的资源如果依赖其他资源，当前项目间接依赖其他资源（A依赖B ，B依赖C，C就是A的间接依赖） 

无论是直接依赖还是间接依赖，在项目中都可以正常使用依赖。

### 3、依赖冲突

依赖传递的冲突问题：

路径优先：当依赖中出现相同的资源时，层级越深，优先级越低，层级越浅，优先级越高

声明优先：当资源在相同层级被依赖时，配置顺序靠前的覆盖配置顺序靠后的

特殊优先：当同级配置了相同资源的不同版本，后配置的覆盖先配置的 

### 4、依赖排除

项目A依赖项目B，项目B依赖项目C，那么项目A也会依赖项目C（依赖传递）。 但当项目A不是完全依赖项目B的时候，即项目A只用到了项目B的一部分功能，而正巧项目B这部分功能的实现，并不需要依赖于项目C，这个时候，项目A就应该排除对项目C的依赖。 

当我们使用一个工程时，控制实际需要的依赖列表非常重要。而且，排除不必要的依赖还可以帮助我们节约磁盘、内存等空间，避免许可协议问题以及类路径问题等。  我们在享受Maven依赖的自动传递性带给我们的便利的同时，要时刻注意引入冗余、不必要的依赖对我们项目产生的负面影响。 

#### 4.1 可选依赖（不透明）

可选依赖指的是对外隐藏当前所依赖的资源。A依赖B，在B中进行配置

~~~xml
<dependency>
  <groupId></groupId>
  <artifactId></artifactId>
  <version></version>
  <!--添加下面这一行-->
  <optional>true</optional>
</dependency>
~~~

#### 4.2 排除依赖（不需要）

 排除依赖指主动断开依赖的资源，被排除的资源无需指定版本。A依赖B，在A中进行配置

~~~xml
<dependency>
  <groupId></groupId>
  <artifactId></artifactId>
  <version></version>
  <!--添加下面的排除信息-->
  <exclusions>
    <exclusion>
      <groupId></groupId>
      <artifactId></artifactId>
    </exclusion>
  </exclusions>
</dependency>
~~~

### 5、依赖范围

| 依赖范围        | 主代码 | 测试 | 打包 | 例子        |
| --------------- | ------ | ---- | ---- | ----------- |
| compile（默认） | √      | √    | √    | log4j       |
| provided        | √      | √    | ×    | servlet-api |
| test            | ×      | √    | ×    | junit       |
| runtime         | ×      | ×    | √    | jdbc        |

## 六、模块管理

### 1、聚合

 聚合用于快速构建Maven工程，一次性构建多个模块

~~~xml
<!--创建一个空模块，打包类型定义为pom -->
<packaging>pom</packaging>
~~~

参与聚合操作的模块最终执行顺序与模块间的依赖关系有关，与配置顺序无关

~~~xml
<modules>
  <module>模块地址</module>
  <module>模块地址</module>
  <module>模块地址</module>
  <module>模块地址</module>
</modules>
~~~

### 2、继承

继承用于实现在子模块中沿用父模块中的配置，统一多个模块中的依赖版本

- 父模块中管理依赖

~~~xml
<!--声明此处进行依赖管理-->
<dependencyManagement>
  <!--具体的依赖-->
  <dependencies>
    <dependency>
      <groupId></groupId>
      <artifactId></artifactId>
      <version></version>
    </dependency>
  </dependencies>
</dependencyManagement>
~~~

- 子模块中绑定父模块

~~~xml
<!--定义该工程的父工程-->
<parent>
    <groupId></groupId>
    <artifactId></artifactId>
    <version></version>
    <!--填写父工程的pom文件-->
    <relativePath>父工程pom文件地址</relativePath>
</parent>
~~~

~~~xml
<!--子模块声明的groupId和父模块一致，可以省略-->
<!--<groupId></groupId>-->
<artifactId></artifactId>
<!--子模块声明的version和父模块一致，可以省略-->
<!--<version></version>-->
~~~

在子模块中定义依赖关系，无需声明依赖版本，版本参照父模块中依赖的版本

~~~xml
<dependency>
  <groupId></groupId>
  <artifactId></artifactId>
</dependency>
~~~

## 七、属性

### 1、自定义属性

 等同于定义变量，方便统一维护

~~~xml
<!--定义自定义属性-->
<properties> 
  <spring.version>5.1.9.RELEASE</spring.version>
</properties>
~~~

~~~xml
<dependency> 
  <groupId>org.springframework</groupId> 
  <artifactId>spring-context</artifactId> 
  <!--使用自定义属性-->
  <version>${spring.version}</version>
</dependency>
~~~

### 2、内置属性

- ${basedir}：表示项目的根路径，即包含pom.xml文件的目录
- ${version}：表示项目版本
- ${maven.build.timestamp}：表示项目构建开始时间
- ${maven.build.timestamp.format}：表示${maven.build.timestamp}的展示格式，默认值为yyyyMMdd-HHmm 

~~~xml
<properties>
    <maven.build.timestamp.format>yyyyMMddHHmmss</maven.build.timestamp.format>
</properties>
~~~

- maven.compiler.source、maven.compiler.target：编译和运行使用的JDK版本

```xml
<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

### 3、pom属性(使用pom属性可以引用到pom.xml文件对应元素的值)

- ${project.basedir}：同${basedir}
- ${project.baseUri}：表示项目文件地址

- ${project.build.sourceEncoding}：表示主源码的编码格式， 默认为平台编码 

  ~~~xml
  <properties>
  	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  ~~~

- ${project.build.sourceDirectory}：表示主源码路径， 默认为 src/main/java/ 
- ${project.build.testSourceDirectory}：表示测试源码目录，默认为 src/test/java/
- ${project.build.directory}：表示构建目录，默认为target 
- ${project.build.outputDirectory}：表示主代码编译输出目录，默认为 target/classes/
- ${project.build.testOutputDirectory}：表示测试代码编译输出目录，默认为 target/testclasses/ 

- ${project.build.finalName}：表示输出文件名称 ，缺省为${project.artifactId}-${project.version} 

- ${project.version}：表示项目版本,与 ${version}相同

### 4、setting属性

使用以settings.开头的属性引用settings.xml文件中的XML元素值)

~~~xml
<!--本地仓库路径-->
${settings.localRepository}
~~~

### 5、java系统属性(所有的Java系统属性都可以使用Maven属性引用)

**使用 mvn help:system 命令可查看所有的Java系统属性**

~~~xml
<!--用户家目录-->
${user.home}
~~~

### 6、环境变量属性

**使用 mvn help:system 命令可查看所有的Java系统属性**

环境变量以 env 开头

~~~xml
<!--java安装路径-->
${env.JAVA_HOME}
~~~

## 八、版本管理

- SNAPSHOT（快照版本） 

- RELEASE（发布版本） 

## 九、资源配置

### 1、 配置文件引用pom文件中properties属性

~~~xml
<properties>
    <jdbc.password>123456</jdbc.password>
</properties>
~~~

~~~xml
<!--开启配置文件加载pom属性-->
<build>
    .......
      <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    ......
</build>
~~~

在配置文件中使用  ${属性名}  方式引用

~~~xml
${jdbc.password}
~~~

### 2、resouce下的include和exclude的使用

第一段<resource>配置声明：在src/main/resources目录下，仅jdbc.properties和mail.properties两个文件是资源文件，这两个文件需要被过滤。

而第二段<resource>配置声明：同样在src/main/resources目录下，除jdbc.properties和mail.properties两个文件外的其他文件也是资源文件，但是它们不会被过滤。 

~~~xml
<resources>
<!-- Filter jdbc.properties & mail.properties.-->
<!-- NOTE: We don't filter applicationContext-*.xml -->
  <resource>
    <directory>src/main/resources</directory>
    <filtering>true</filtering>
    <includes>
      <include>jdbc.properties</include>
      <include>mail.properties</include>
    </includes>
  </resource>
  <!-- Include other files as resources files. -->
  <resource>
    <directory>src/main/resources</directory>
    <filtering>false</filtering>
    <excludes>
      <exclude>jdbc.properties</exclude>
      <exclude>mail.properties</exclude>
    </excludes>
  </resource>
</resources>
~~~

## 十、插件

### 1、可运行jar包

~~~xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-jar-plugin</artifactId>
	<version>2.4</version>
	<configuration>
		<archive>
			<!-- 生成的jar中，包含pom.xml和pom.properties这两个文件 -->
			<addMavenDescriptor>true</addMavenDescriptor>
			<!-- 生成MANIFEST.MF的设置 -->
			<manifest>
				<!--依赖以-SNAPSHOT结尾时，默认自动名称成时间戳名称，导致依赖的jar包
				无法正常找到-->
				<useUniqueVersions>false</useUniqueVersions>
				<!-- 为依赖包添加路径, 这些路径会写在MANIFEST文件的Class-Path下 -->
				<addClasspath>true</addClasspath>
				<!-- 这个jar所依赖的jar包添加classPath的时候的前缀，如果这个jar本身
				和依赖包在同一级目录，则不需要添加 -->
				<classpathPrefix>lib/</classpathPrefix>
				<!-- jar启动入口类 -->
				<mainClass>com.ht.pojo.Test</mainClass>
			</manifest>
			<manifestEntries>
				<!-- 在Class-Path下添加配置文件的路径 -->
				<Class-Path>../config/</Class-Path>
				<!--假如这个项目可能要引入一些外部资源，但是你打包的时候并不想把
				这些资源文件打进包里面，这个时候你必须在这边额外指定一些这些资源 
				文件的路径-->
			</manifestEntries>
		</archive>
		<!-- jar包的位置 -->
		<outputDirectory>${project.build.directory}/lib</outputDirectory>
		<includes>
			<!-- 打jar包时，打包class文件和config目录下面的 properties文件 -->
			<!-- 有时候可能需要一些其他文件，这边可以配置，包括剔除的文件等等 -->
			<include>**/*.class</include>
			<include>**/*.properties</include>
		</includes>
	</configuration>
</plugin>
~~~

