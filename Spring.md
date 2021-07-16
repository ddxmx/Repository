# Spring

# 一、IOC

## 1、装配

Spring装配有三种方式：

- 使用XML方式显示配置

- 在java中显示配置

- 隐式的bean发现机制和自动装配

### 1）自动装配

#### A、==@Component和@ComponentScan==

自动装配两个条件：组件扫描（@ComponentScan）、自动装配（@Autowired）

```java
@Component：用于类上，表明该类会作为组件类，并告知Spring要为这个类创建bean  
```
组件扫描默认是不启用。需要手动开启。
```java
@ComponentScan：用于类或接口上，主要是指定扫描包及子包，spring会把指定路径下带有指定注解的类自动装配到bean容器里。
会被自动装配的注解包括@Controller、@Service、@Component、@Repository等等。
其作用等同于XML中<context:component-scan base-package="com.test.bean" />。
```
```java
//注册组件
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private double price;
}

//java配置类中使用组件扫描
@Configuration
@ComponentScan({"com.test.bean"})
//等同于以下使用方式，使用class比使用字符串更加安全
//@ComponentScan(basePackageClasses = {Book.class})
public class BookConfig {
}
```

扫描多个包使用形式：

- @ComponentScan(basePackageClasses = {Book.class, UserDao.class})
- @ComponentScan({"com.test.bean","com.test.dao"})

#### B、==@Autowired==

@Autowired：可以使用在属性、构造器、普通方法、构造器参数上。

没有匹配的bean或存在多个匹配的bean，将抛出异常。

required属性为false时，没有装配成功不会抛出异常，但是未装配的属性有可能会出现NullPointerException。

Autowired不支持设置名称，先根据type查找，再根据name查找

```java
//修饰属性时,不依赖set方法,通过反射方式赋值
@Autowired
private UserDao userDao;

//修饰构造时,实例化时调用该构造器。构造器存在参数时,从ioc容器中自动获取。只有一个构造器时，@Autowired可以省略
@Autowired
public UserService(UserDao userDao) {
    this.userDao = userDao;
}

//修饰构造构造器属性时,会自动注入属性。当类中只有一个构造器,且是有参构造,自动赋值。
public UserService(@Autowired UserDao userDao) {
    this.userDao = userDao;
}

//修饰普通方式时,实例化后会调用该方法一次。如果方法有参数,从ioc容器中自动获取。
@Autowired
public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
}
```

#### C：自动装配歧义解决

- #### ==@Primary==

```
@Primary：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者
```

```java
public interface UserDao {
    public void addUser();
}

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("向数据库新增一个用户~");
    }
}

@Component
//@Primary可以和@Component一起使用，当出现多个bean时，作为首选
@Primary
public class UserMysqlDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("向MySQL数据库新增一个用户~");
    }
}
```

- ==@Qualifier==

```
@Qualifier：自动装配时当出现多个Bean候选者时，指定名称注入
```

```java
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userMysqlDaoImpl")
    private UserDao userDao;

    public void addUser() {
        userDao.addUser();
    }
}
```

- ==@Resource==

Resource可以指定名称，先根据name查找，再根据type查找

```java
@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public void addUser() {
        userDao.addUser();
    }
}
```

### 2）通过java方式装配bean

#### ==@Configuration== 和==@Bean==

````java
@Configuration：用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
````

```java
@Configuration
public class BookConfig {
    //bean的默认名称和方法名称一致，可以使用@Bean("book")方式设置bean的名称
    //默认情况下， Spring中的bean都是单例的
    @Bean
    public Book book() {
        return new Book("小学生作文选", 59.9);
    }
}
```

使用java方式，创建bean时，bean之间存在依赖，使用以下方式

```java
//方式一
@Bean
public Student student() {
    //Spring会拦截对book()的调用并确保返回的是Spring所创建的bean
    return new Student("张三", 18, book());
}

//方式二，推荐方式
//会在spring容器中查找id为book的bean，自动装配
public Student student(Book book) { 
    return new Student("张三", 18, book);
}
```

### 3）通过xml方式装配bean

```xml
<!--定义bean,id唯一标识-->
<bean id="book" class="com.test.bean.Book"/>
```

#### A、构造器注入

```xml
<bean id="book" class="com.test.bean.Book">
    <constructor-arg name="title" value="一千零一夜"/>
    <constructor-arg name="price" value="19.9"/>
</bean>

<!--value表示设置字面量，ref表示设置引用-->
<bean id="student" class="com.test.bean.Student">
    <constructor-arg name="name" value="张三"/>
    <constructor-arg name="age" value="20"/>
    <constructor-arg name="book" ref="book"/>
</bean>
```

c标签，简化constructor-arg标签

```xml
<bean id="student" class="com.test.bean.Student" c:name="张三" c:age="20" c:book-ref="book"/>
```

构造器标签可以装配集合，而c标签不能装配集合

```xml
<bean id="person" class="com.test.bean.Person">
    <constructor-arg name="name" value="张三"/>
    <constructor-arg name="age" value="20"/>
    <constructor-arg name="books">
        <!--array注入方式-->
        <array>
            <value>三国演义</value>
            <value>水浒传</value>
            <value>西游记</value>
            <value>红楼梦</value>
        </array>
    </constructor-arg>
</bean>

<!--list注入方式-->
<list>
    <value>读书</value>
    <value>音乐</value>
    <value>唱歌</value>
</list>

<!--set注入方式-->
<set>
    <value>英雄联盟</value>
    <value>魔兽世界</value>
    <value>绝地求生</value>
</set>

<!--map注入方式-->
<map>
    <entry key="爸爸" value="35"></entry>
    <entry key="妈妈" value="32"></entry>
    <entry key="爷爷" value="60"></entry>
    <entry key="奶奶" value="58"></entry>
</map>

<!--空注入，构造器中占位-->
<null/>

<!--properties属性输入-->
<props>
    <prop key="语文">95</prop>
    <prop key="数学">98</prop>
    <prop key="英语">92</prop>
</props>
```
注入时引用外部集合
```xml
<!--
	util:list 创建一个java.util.List类型的bean，其中包含值或引用
	util:map 创建一个java.util.Map类型的bean，其中包含值或引用
	util:properties 创建一个java.util.Properties类型的bean
	util:set 创建一个java.util.Set类型的bean，其中包含值或引用
-->
<util:list id="books">
    <value>三国演义</value>
    <value>水浒传</value>
    <value>西游记</value>
    <value>红楼梦</value>
</util:list>

<bean id="person" class="com.test.bean.Person">
    <constructor-arg name="name" value="张三"/>
    <constructor-arg name="age" value="20"/>
    <!--注入时使用外部集合-->
    <constructor-arg name="books" ref="books"/>
</bean>
```

#### B、属性注入

==属性注入依赖set方法==

==使用构造器注入还是属性注入选择：强依赖使用构造器注入，而对可选性的依赖使用属性注入==

```xml
<bean id="book" class="com.test.bean.Book" p:title="java编程思想" p:price="99.9"/>

<bean id="student" class="com.test.bean.Student">
    <property name="name" value="张三"/>
    <property name="age" value="20"/>
    <property name="book" ref="book"/>
</bean>
```

p标签，简化property标签

```xml
<bean id="student" class="com.test.bean.Student" p:name="张三" p:age="20" p:book-ref="book"/>
```

### 4）混合配置

#### ==@Import==

```java
@Import：导入其他配置类，等同于xml中使用<import resource="application-context-second.xml"/>导入其他xml配置
```

```java
@Configuration
public class BookConfig {
    @Bean
    public Book book() {
        return new Book("中学生作文选", 99.9);
    }
}
```

```java
@Configuration
@Import({BookConfig.class})
public class StudentConfig {
    @Bean
    public Student student(Book book) {
        return new Student("张三", 14, book);
    }
}
```

#### A：在JavaConfig中引用XML配置

#### ==@ImportResource==

```java
@ImportResource：用于导入Spring的配置文件，让配置文件里面的内容生效
```

```java
@Configuration
@ImportResource("classpath:application-context.xml")
public class StudentBookConfig {
}
```

#### B、在XML配置中引用JavaConfig  

```java
@Configuration
public class UserConfig {
    @Bean
    public User user() {
        return new User("张三", 20);
    }
}
```

```xml
<bean class="com.test.config.UserConfig"/>

<!--必须要加这个，否则javaConfig中的@Bean注解不能被识别-->
<context:annotation-config/>
```

## 2、属性占位符${ }

### A：使用==@PropertySource==注解和Environment获取运行时外部值

```java
@PropertySource：用于指定资源文件读取的位置，它不仅能读取properties文件，也能读取xml文件，并且通过YAML解析器，配合自定义PropertySourceFactory实现解析YAML文件。
```

```java
@Configuration
//存在中文需要设置编码方式
@PropertySource(value = "classpath:book.properties", encoding = "utf-8")
public class BookConfig {
    @Autowired
    private Environment env;

    @Bean
    public Book book() {
        Book book = new Book();
        //获取外部文件中的值
        book.setTitle(env.getProperty("title"));
        book.setPrice(Double.parseDouble(env.getProperty("price")));
        return book;
    }
}
```

### B、使用@PropertySource注解和${}获取运行时外部值

==@Value==的作用是通过注解将常量、配置文件中的值、其他bean的属性值注入到变量中，作为变量的初始值。

- java方式

```java
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@PropertySource(value = "classpath:customer.properties", encoding = "utf-8")
public class Customer {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;
}
```

```java
@Configuration
public class CommonConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
```

- xml方式

```xml
<bean id="customer" class="com.test.bean.Customer" p:name="${name}" p:age="${age}"/>
<!--使用${}依赖的bean，同时指定资源文件-->
<context:property-placeholder location="classpath:customer.properties"/>
```



## 3、Spring EL表达式

- 表示字面量

  ```java
  //数字
  #{3.14}
  //boolean常量
  #{false}
  //字符串
  #{'hello'}
  ```

- 引用bean、属性和方法

  ```java
  //引用bean
  #{car}
  //引用属性
  #{car.brand}
  //引用方法
  #{car.getBrand()}
  //安全返回，防止NullPointerException，判断不为null时才调用toUpperCase()，为null时直接返回null，不再调用后续方法
  #{car.getBrand()?.toUpperCase()}
  ```

- 表达式中使用类型

  在SpEL中访问类作用域的方法和常量的话， 要依赖T()运算符

  ```
  #{T(java.lang.Math)}
  #{T(java.lang.Math).PI}
  #{T(java.lang.Math).random()}
  ```

- 运算符

| 运算符类型 | 运 算 符                                               |
| ---------- | ------------------------------------------------------ |
| 算术运算   | +、 -、 * 、 /、 %、 ^                                 |
| 比较运算   | < 、 > 、 == 、 <= 、 >= 、 lt 、 gt 、 eq 、 le 、 ge |
| 逻辑运算   | and 、 or 、 not 、 │                                  |
| 条件运算   | ?: (ternary) 、 ?: (Elvis)                             |
| 正则表达式 | matches                                                |

```java
// 进行逻辑与运算
#{city.number > 100 and city.number <= 200}

// 进行或非逻辑操作
#{ not (city.number == 100 or city.number <= 200)}

// 使用三元运算符
#{city.number > 100 ? city.number : city.number + 100}

// 设置默认值，为null时使用默认值替换
#{city.name?:'NanJing'}

// 验证是否邮箱地址正则表达式
#{city.STR matches '(\\d{3}\\w*)?[^a-c]+(11|22)'}
```

-  使用集合

```java
/*
 * city类中拥有名为cities的List变量, 和名为msg的Map变量
 */
// 获取下标为0的元素
#{city.cities[0]}

// 获取map中key为hello的value
#{city.msg['hello']}

// 根据cities下标为4元素作为key获取msg的value
#{city.msg[city.cities[4]]}

/*
    <!-- 首先通过applicationContext.xml中<util:properties>增加properties文件 -->
    <util:properties id="mysql_config" location="classpath:application.properties"/>
 */
// 注意mysql_config为xml文件中声明的id
#{mysql_config['jdbc.url']}

// 过滤city中cityList集合pricen属性大于50000的全部数据注入到本属性
//SpEL提供了查询运算符（.?[]），它会用来对集合进行过滤，得到集合的一个子集
#{city.cars.?[price > 50000]}

//^表示第一条数据
// 过滤city中cars集合price属性>50000的第一条数据注入到本属性
#{city.cars.^[price > 50000]}

//$表示最后一条数据
// 过滤city中cars集合price属性小于100000的最后一条数据注入到本属性
#{city.cars.$[price < 100000]}

/*
 * 假如我们在过滤车后只想保留车的名称,
 * 可以使用如下方式进行投影
 * 集合投影语法：bean.![属性名]
 */
#{city.cars.?[price > 50000].![brand]}
```

## 4、Bean的作用域

- 单例（ Singleton） ： 在整个应用中， 只创建bean的一个实例。
- 原型（ Prototype） ： 每次注入或者通过Spring应用上下文获取的时候， 都会创建一个新的bean实例。
- 会话（ Session） ： 在Web应用中， 为每个会话创建一个bean实例。
- 请求（ Rquest） ： 在Web应用中， 为每个请求创建一个bean实例。

单例是默认的作用域。

```xml
<bean id="book" class="com.test.day02.ioc.bean.Book" scope="singleton"/>
<bean id="book" class="com.test.day02.ioc.bean.Book" scope="prototype"/>
```

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
//或使用ConfigurableBeanFactory中的常量值
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Book {
    private String title;
    private double price;
}
```





