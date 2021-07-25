# MyBatis

# 一、引导

```xml
<!-- 官方文档地址：https://mybatis.org/mybatis-3/zh/index.html -->
<!--mybatis依赖-->
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis</artifactId>
	<version>3.5.7</version>
</dependency>

<!--jdbc驱动依赖-->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.25</version>
</dependency>

<!--分页插件pagehelper依赖-->
<dependency>
	<groupId>com.github.pagehelper</groupId>
	<artifactId>pagehelper</artifactId>
	<version>5.2.1</version>
</dependency>

<!--lombok依赖-->
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.18.20</version>
</dependency>
```

# 二、第一个MyBatis

## 1、数据库配置信息文件db.properties

```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=utf-8
username=root
password=123456
```

## 2、mybatis-config.xml文件中配置环境信息

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--方式一：从文件获取属性，优先级高，推荐方式-->
    <properties resource="db.properties"/>

    <!--方式二：在xml中配置属性-->
    <!--<properties>
        <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url"
                  value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=utf-8"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </properties>-->

    <!--environment可以定义多个，使用时设置default来选择环境信息-->
    <!--尽管可以配置多个环境，但每个SqlSessionFactory实例只能选择一种环境-->
    <!--如果想连接两个数据库，就需要创建两个SqlSessionFactory实例，每个数据库对应一个-->
    <environments default="development">
        <!--环境信息一-->
        <environment id="development">
            <!--事务管理器，以下使用了JDBC的提交和回滚事务-->
            <transactionManager type="JDBC"/>
            <!--数据源-->
            <dataSource type="POOLED">
                <!--和<properties resource="db.properties"/>联合使用，动态配置-->
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <!--从 MyBatis 3.4.2 开始，你可以为占位符指定一个默认值，如下，如果属性username没有配置，则设置为默认值admin-->
                <property name="username" value="${username:admin}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>

        <!--环境信息二-->
        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>

    <!--每个定义的mapper文件都需要在MyBatis核心配置文件中注册-->
    <mappers>
        <!--使用资源方式注册-->
        <mapper resource="mapper/user-mapper.xml"/>
    </mappers>
</configuration>
```

## 3、创建pojo类和Dao接口

```java
/**
 * 实体类不要使用基本数据类型
 * 基本数据类型具有默认值，将无法赋值为null
 * 在动态SQL中，例如age != null的判断将永远为true，会出现一些隐藏的问题
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
```

```java
/**
 * xml的sql语句
 */
public interface UserDao {
    //根据ID查询用户
    public User getUserById(int id);
}
```

## 4、定义mapper文件

在resource下的mapper目录下创建资源文件user-mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--mapper实际上就是接口的实现类，namespace的名称为对应Mapper接口或者Dao接口的完整包名，XML根据这个名称生成动态代理类，必须一致！-->
<mapper namespace="com.test.mybatis.dao.UserDao">
    <select id="getUserById" resultType="com.test.mybatis.pojo.User">
        select id, name, age
        from mybatis.user
        where id = #{id}
    </select>
</mapper>
```

## 5、执行SQL

```java
/**
 * MyBatis工具类，封装SqlSessionFactory和SqlSession的获取
 */
public class MyBatisUtil {
    //sqlSessionFactory作用域贯穿整个MyBatis的生命周期，应该是单例的
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //类路径(target/classes)下的资源文件
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            //SqlSessionFactoryBuilder用于创建SqlSessionFactory，创建后就无用了，应该是局部变量
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession实例用于数据库操作
     * SqlSession最佳的作用域就是请求作用域或方法作用域
     *
     * @return
     */
    public static SqlSession getSession() {
        //true表示设置自动提交，增、删、改需要提交操作
        return sqlSessionFactory.openSession(true);
    }
}
```

```java
try (SqlSession session = MyBatisUtil.getSession()) {
	UserDao mapper = session.getMapper(UserDao.class);
	User user = mapper.getUserById(1002);
	//User(id=1002, name=李四, age=24)
	System.out.println(user);
}
```

# 三、设置

## 1、设置sql日志

### 1）添加依赖

```xml
<!--日志依赖-->
<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-api</artifactId>
	<version>1.7.31</version>
</dependency>

<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-log4j12</artifactId>
	<version>1.7.31</version>
</dependency>

<dependency>
	<groupId>log4j</groupId>
	<artifactId>log4j</artifactId>
	<version>1.2.17</version>
</dependency>
```

### 2）mybatis-config.xml中开启日志

```xml
<settings>
	<!--开启日志，默认不开启，也可以配置为自带的COMMONS_LOGGING-->
	<setting name="logImpl" value="LOG4J"/>
</settings>
```

### 3）配置日志文件

在resource下创建log4j.properties文件

```properties
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
log4j.rootLogger=DEBUG,console
#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n
#文件输出的相关设置
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/MyBatisDemo.log
log4j.appender.file.MaxFileSize=100mb
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n
#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```

### 4）执行时打印日志信息

```
[DEBUG][21-07-25][org.apache.ibatis.transaction.jdbc.JdbcTransaction]Opening JDBC Connection
[DEBUG][21-07-25][org.apache.ibatis.datasource.pooled.PooledDataSource]Created connection 846254484.
[DEBUG][21-07-25][com.test.mybatis.dao.UserDao.getUserById]==>  Preparing: select id, name, age from mybatis.user where id = ?
[DEBUG][21-07-25][com.test.mybatis.dao.UserDao.getUserById]==> Parameters: 1002(Integer)
[DEBUG][21-07-25][com.test.mybatis.dao.UserDao.getUserById]<==      Total: 1
User(id=1002, name=李四, age=24)
[DEBUG][21-07-25][org.apache.ibatis.transaction.jdbc.JdbcTransaction]Closing JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@3270d194]
[DEBUG][21-07-25][org.apache.ibatis.datasource.pooled.PooledDataSource]Returned connection 846254484 to pool.
```

## 2、开启驼峰命名

```xml
<settings>
	<!--开启驼峰命名，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn-->
	<setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```

## 3、属性文件开启默认值、修改默认值

### 1）开启属性默认值

```xml
<properties resource="db.properties">
	<!-- 开启允许设置默认值，默认分隔符为: -->
	<property name="org.apache.ibatis.parsing.PropertyParser.enable-default-value" value="true"/>
</properties>
```

 **使用时指定默认值**

```xml
<environment id="development">
	<!--事务管理器，以下使用了JDBC的提交和回滚事务-->
	<transactionManager type="JDBC"/>
	<!--数据源-->
	<dataSource type="POOLED">
		<!--和<properties resource="db.properties"/>联合使用，动态配置-->
		<property name="driver" value="${driver}"/>
		<property name="url" value="${url}"/>
		<!--从 MyBatis 3.4.2 开始，你可以为占位符指定一个默认值，如下，如果属性username没有配置，则设置为默认值admin-->
		<property name="username" value="${username:admin}"/>
		<property name="password" value="${password}"/>
	</dataSource>
</environment>
```

### 2）修改默认值分隔符

```xml
<properties resource="db.properties">
	<!-- 开启允许设置默认值，默认分隔符为: -->
	<property name="org.apache.ibatis.parsing.PropertyParser.enable-default-value" value="true"/>

	<!-- 如果属性名中使用了:或者在SQL映射文件中使用了三元运算符，则需要修改默认值的分隔符，以下将默认值修改为?: -->
	<!--<property name="org.apache.ibatis.parsing.PropertyParser.default-value-separator" value="?:"/>-->
</properties>
```

 **使用时指定默认值**

```xml
<environment id="development">
	<transactionManager type="JDBC"/>
	<dataSource type="POOLED">
		<property name="driver" value="${driver}"/>
		<property name="url" value="${url}"/>
		<property name="username" value="${username?:admin}"/>
		<property name="password" value="${password}"/>
	</dataSource>
</environment>
```

## 4、指定别名

```xml
<!--为全限定类名设置别名，任何使用全限定类名的地方都可以使用别名代替-->
<typeAliases>
	<!--手动定义和注解定义同一个类的别名，都会生效-->
	<!--方式一：定义单个别名-->
	<typeAlias type="com.test.mybatis.pojo.User" alias="myUser"/>

	<!--方式二：包扫描方式，批量定义别名
	每一个在包 com.test.mybatis.pojo 中的 Java Bean，在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名。
	若有注解，则别名为其注解值。-->
	<package name="com.test.mybatis.pojo"/>
</typeAliases>
```

# 四、注解方式

```java
/**
 * 注解方式的sql语句
 * 注解方式不再需要sql映射文件，但是只适合于一些简单的SQL语句
 */
public interface UserAnnotationDao {
    //不管是注解方式和xml方式，一个参数时，可以不使用@Param注解
    @Select("select * from mybatis.user where id=#{id}")
    public User getUserById(int id);

    @Select("select * from mybatis.user")
    public List<User> getUsers();

    @Insert("insert into mybatis.user value (#{id},#{name},#{age})")
    public int addUser(User user);

    @Update("update mybatis.user set name=#{name},age=#{age} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from mybatis.user where id=#{id}")
    public int deleteUser(int id);
}
```

# 五、Mapper

## 1、parameterType

parameterType表示传入sql语句参数的类型，只能配置单个类型，可以省略

### 0）使用${}代替#{}

```java
//使用${}查询
public List<User> getUserWith$(String name);
```

```xml
<!--#{}和${}区别，#{}是占位符，预编译处理，${}是变量，直接进行字符串连接，存在sql注入风险，${}一般用于替换列名或表名-->
<select id="getUserWith$" resultType="com.test.mybatis.pojo.User">
	select id, name, age
	from mybatis.user
	where name=${name}
</select>
```

```java
try (SqlSession session = MyBatisUtil.getSession()) {
	UserDao mapper = session.getMapper(UserDao.class);
	//List<User> list = mapper.getUserWith$("'王五'");

	//使用#{}方式，查询出来是空结果
	//使用${}方式，查询出来是所有数据
	//使用#方式传递字符串时不需要在字符串上手动传入单引号，$方式需要手动传入
	List<User> list = mapper.getUserWith$("'王五' or 1=1");
	list.forEach(System.out::println);
}
```

### 1）基本类型

sql语句中#{}中的名字可以时任意的，一般和dao中方法参数名一致

```java
//删除一个用户
public int deleteUser(int id);

//模糊查询
public List<User> getUserLikeName(String name);
```

```xml
<delete id="deleteUser">
	delete
	from mybatis.user
	where id = #{id}
</delete>

<select id="getUserLikeName" resultType="com.test.mybatis.pojo.User">
	select id, name, age
	from mybatis.user
	where name like #{name}
</select>
```

### 2）多个参数

#### @Param

```java
//mapper中select语句设置时，参数只能是一个，如果传参是两个，可以在接口方法的参数前加@Param属性
//Sql语句编写的时候，直接取@Param中设置的值即可，不需要单独设置参数类型
public List<User> getUserByIdOrName(@Param("id") int id, @Param("name_test") String name);
```

```xml
<!--直接使用@Param注解中设置的字段，名称必须一致-->
<select id="getUserByIdOrName" resultType="myUser">
	select id, name, age
	from mybatis.user
	where id = #{id}
	  or name = #{name_test}
</select>
```

### 3）对象类型

#{}中的名字必须和对象的属性名字一致

```java
//新增一个用户
public int addUser(User user);

//修改一个用户
public int updateUser(User user);
```

```xml
<!--直接使用的类中属性名称-->
<insert id="addUser">
	insert into mybatis.user(id, name, age)
	values (#{id}, #{name}, #{age})
</insert>

<update id="updateUser">
	update mybatis.user
	set name=#{name},
		age=#{age}
	where id = #{id}
</update>
```

### 4）map类型

```java
//使用map进行传参，实际上是将多个参数封装为一个map传入
public List<User> getUserByMap(Map<String, Object> map);
```

```xml
<!--map的缺陷：阅读性差，传参map时，无法控制传入的map是否存在指定的key-->
<!--占位符名称为map的key值-->
<select id="getUserByMap" resultType="testUser">
	select id, name, age
	from mybatis.user
	where id = #{uid}
	  or name = #{uname}
</select>
```

## 2、resultType

### 1）基本数据类型

```java
//查询总条数
public int count();
```

```xml
<select id="count" resultType="int">
	select count(*)
	from mybatis.user
</select>
```

### 2）对象类型

查询结果中的字段名称和对象中属性的名称一致时，可以直接赋值。否则对象中的属性为null。

```java
//查询所有用户
public List<User> getAllUsers();
```

```xml
<!--resultType是数据库中一行记录的类型-->
<select id="getAllUsers"  resultType="com.test.mybatis.pojo.User">
	select id, name, age
	from mybatis.user
</select>
```

### 3）map类型

```java
//查询到的结果转换为map对象存储
public Map<String, Object> getPersonByAge(int age);
```

```xml
<!--自动映射，映射在map上直接取值就可以，key为字段的名称，value为字段值-->
<!--结果只能是一条数据，否则会报错-->
<!--org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 2-->
<select id="getPersonByAge" resultType="map">
	select *
	from mybatis.user
	where age = #{age}
</select>
```

## 3、resultMap

```java
@Data
public class Person {
    private int id;
    private String username;
    private int age;
}
```

```java
public Person getPersonById(int id);
```

````xml
<!--问题：实体类和数据库字段不一致，导致属性赋值未赋值，Person(id=1003, username=null, age=21)-->
<select id="getPersonById" resultType="com.test.mybatis.pojo.Person">
	select id, name, age
	from mybatis.user
	where id = #{id}
</select>
````

### 1）使用别名进行映射

查询结果中字段名称和对象中属性名称不一致时，可以通过起别名的方式进行映射。

```xml
<!--处理方式一，起别名，将数据库查询出的字段名称起别名为类中属性名，Person(id=1003, username=王五, age=21)-->
<select id="getPersonById" resultType="com.test.mybatis.pojo.Person">
	select id, name as username, age
	from mybatis.user
	where id = #{id}
</select>
```

### 2）使用resultMap手动映射

```xml
<!--处理方式二：返回类型不一致，使用resultMap，建立实体类属性和数据库字段的映射关系，推荐方式，可以复用-->
<resultMap id="personMap" type="com.test.mybatis.pojo.Person">
	<!--主键使用id，其他字段使用result-->
	<id property="id" column="id"/>
	<result property="username" column="name"/>
</resultMap>

<!--使用resultMap手动映射结果，和resultType只能使用一个-->
<select id="getPersonById" resultMap="personMap">
	select id, name, age
	from mybatis.user
	where id = #{id}
</select>
```

### 3）一对多、多对一关系

```java
@Data
public class Student {
    private int id;
    private String name;
    private Teacher teacher;
}

@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
}
```

#### A、一对多

```java
//Teacher对应多个Student
public Teacher getTeacher();
```

```xml
<resultMap id="teacherMap" type="com.test.mybatis.pojo.Teacher">
	<result property="id" column="tid"></result>
	<result property="name" column="tname"></result>

	<!--collection用于一对多的关系，ofType指定的是映射到list集合属性中pojo的类型。-->
	<collection property="students" ofType="com.test.mybatis.pojo.Student">
		<result property="id" column="sid"></result>
		<result property="name" column="sname"></result>
	</collection>
</resultMap>

<select id="getTeacher" resultMap="teacherMap">
	select t.id tid, t.name tname, s.id sid, s.name sname
	from mybatis.teacher t,
		 mybatis.student s
	where t.id = s.tid
</select>
```

```java
try (SqlSession session = MyBatisUtil.getSession()) {
	StudentTeacherDao mapper = session.getMapper(StudentTeacherDao.class);
	Teacher teacher = mapper.getTeacher();
	/*
		Teacher{id=1001,
			name='张老师',
			students=[Student{id=2001, name='小明', teacher=null},
				Student{id=2002, name='小红', teacher=null},
				Student{id=2003, name='小张', teacher=null},
				Student{id=2004, name='小李', teacher=null},
				Student{id=2005, name='小王', teacher=null}]
		}
	 */
	System.out.println(teacher);
}
```

#### B、多对一

```java
//对各Student对应一个Teacher
public List<Student> getStudents();
```

```xml
<!--多对一的关系-->
<resultMap id="studentMap" type="com.test.mybatis.pojo.Student">
	<result property="id" column="sid"></result>
	<result property="name" column="sname"></result>

	<!--对象的依赖关系都是用association-->
	<!--association用于一对一、多对一的关系，JavaType是用来指定pojo中属性的类型-->
	<association property="teacher" javaType="com.test.mybatis.pojo.Teacher">
		<result property="id" column="tid"></result>
		<result property="name" column="tname"></result>
	</association>
</resultMap>

<select id="getStudents" resultMap="studentMap">
	select s.id sid, s.name sname, s.tid tid, t.name tname
	from mybatis.student s,
		 mybatis.teacher t
	where s.tid = t.id
</select>
```

```java
try (SqlSession session = MyBatisUtil.getSession()) {
	StudentTeacherDao mapper = session.getMapper(StudentTeacherDao.class);
	List<Student> list = mapper.getStudents();
	/*
		Student{id=2001, name='小明', teacher=Teacher{id=1001, name='张老师', students=null}}
		Student{id=2002, name='小红', teacher=Teacher{id=1001, name='张老师', students=null}}
		Student{id=2003, name='小张', teacher=Teacher{id=1001, name='张老师', students=null}}
		Student{id=2004, name='小李', teacher=Teacher{id=1001, name='张老师', students=null}}
		Student{id=2005, name='小王', teacher=Teacher{id=1001, name='张老师', students=null}}
	 */
	list.forEach(System.out::println);
}
```

# 六、动态SQL

## 1、if 、where 标签

```java
public List<Blog> getBlogByTitleOrAuthor(Map<String, Object> map);
```

```xml
<select id="getBlogByTitleOrAuthor" resultType="com.test.mybatis.pojo.Blog">
	select * from mybatis.blog
	<!--where标签能够自动去除无用的where、and、or关键字-->
	<where>
		<!--test表示判断,其中的属性是入参中的属性-->
		<if test="title != null">
			title=#{title}
		</if>
		<if test="author != null">
			or author=#{author}
		</if>
	</where>
</select>
```

## 2、set 标签

```java
public int updateBlog(Blog blog);
```

```xml
<update id="updateBlog">
	update mybatis.blog
	<!--set标签能够自动去除无用的set关键字和无用的逗号,-->
	<set>
		<if test="title != null">
            title=#{title},
        </if>
        <if test="author != null">
            author=#{author}
        </if>
	</set>
	where id=#{id}
</update>
```

## 3、choose、when 标签

```java
public List<Blog> getBlogByTitleChoiceAuthor(Blog blog);
```

```xml
<!--choose就是java中if-else的能力-->
<select id="getBlogByTitleChoiceAuthor" resultType="com.test.mybatis.pojo.Blog">
	select * from mybatis.blog
	<where>
		<choose>
			<when test="title != null">
				title=#{title}
			</when>
			<when test="author != null">
				author = #{author}
			</when>
			<otherwise>
				author='张三'
			</otherwise>
		</choose>
	</where>
</select>
```

## 4、foreach 标签

```java
public List<Blog> getBlogForeach(List<String> ids);
```

```xml
<select id="getBlogForeach" resultType="com.test.mybatis.pojo.Blog">
	select * from mybatis.blog
	<where>
		id in
		<!--如果传递的是一个List，则mybatis会封装为一个以"list"为key的map-->
		<foreach collection="list" item="id" open="(" close=")" separator=",">
			#{id}
		</foreach>
        
		<!--如果传递的是一个array，则mybatis会封装为一个以"array"为key的map-->
		<!--<foreach collection="array" item="id" open="(" close=")" separator=",">
			#{id}
		</foreach>-->
        
		<!--如果传递的是一个map，则collection里放的是自定义map的key
			Map map = new HashMap();
			List list = new ArrayList();
			list.add(1);
			list.add(3);
			list.add(5);
			list.add(7);
			map.put("ids",list);
		-->
		<!--<foreach collection="ids" item="id" open="(" close=")" separator=",">
			#{id}
		</foreach>-->
	</where>
</select>
```





