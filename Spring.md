# Spring实战

# 一、引导

Spring的IOC底层实现原理是**工厂设计模式+反射+XML配置文件。**

```xml
<!--spring开发依赖-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.8</version>
</dependency>

<!--lombok依赖-->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version>
</dependency>

<!--aop依赖-->
<dependency>
	<groupId>org.aspectj</groupId>
	<artifactId>aspectjweaver</artifactId>
	<version>1.9.6</version>
</dependency>
```

```xml
<!--编译配置-->
<build>
	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.8.1</version>
			<configuration>
				<source>1.8</source>
				<target>1.8</target>
			</configuration>
		</plugin>
	</plugins>
</build>
```

# 二、IOC（控制反转）

## 1、获取IOC容器方式

### 1）ClassPathXmlApplicationContext

通过classpath下的xml文件实例化IOC容器

```java
ApplicationContext context = new ClassPathXmlApplicationContext("day01-ioc.xml");
UserService userService = context.getBean("userService", UserService.class);
```

### 2）FileSystemXmlApplicationContext

通过绝对路径下的xml文件实例化IOC容器

```java
String resource = "E:/IdeaProjects/spring-basic/ssm-spring/src/main/resources/day01-ioc.xml";
ApplicationContext context = new FileSystemXmlApplicationContext(resource);
UserService userService = (UserService)context.getBean("userService");
```

### 3）AnnotationConfigApplicationContext

通过java类实例化IOC容器

```java
ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
UserDao userDao = context.getBean(UserMysqlDaoImpl.class);
```

## 2、Bean 实例化方式

### 1）构造器实例化

```xml
<!--使用默认构造器实例化-->
<bean id="student" class="com.test.bean.Student"/>
```

### 2）静态工厂类实例化

```java
/**
 * 静态工厂类，不需要先实例化UserServiceFactory类
 */
public class UserServiceFactory {
    public static UserService getUserService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserMysqlDaoImpl());
        return userService;
    }
}
```

```xml
<!--静态工厂类-->
<bean id="userServiceBean" class="com.test.factory.UserServiceFactory" factory-method="getUserService"/>
```

### 3）非静态工厂类实例化

```java
/**
 * 非静态工厂类，使用时需要先实例化工厂类对象
 */
public class StudentFactory {
    public Student getStudent() {
        return new Student();
    }
}
```

```xml
<!--非静态工厂类-->
<!--首先非静态工厂类实例化-->
<bean id="studentFactory" class="com.test.factory.StudentFactory"/>
<!--然后通过非静态工厂类的非静态方法，实例化对象-->
<bean id="studentBean" factory-bean="studentFactory" factory-method="getStudent"/>
```

## 3、装配

Spring装配有三种方式：

- 使用XML方式显示配置

- 在java中显示配置

- 隐式的bean发现机制和自动装配

### 1）自动装配

#### A、@Component和@ComponentScan

自动装配两个条件：组件扫描（@ComponentScan）、自动装配（@Autowired）

```java
@Component：用于类上，表明该类会作为组件类，并告知Spring要为这个类创建bean  
@Repository：用于对dao层实现类进行标注（持久层）
@Service：用于对service层实现类进行标注（业务层）
@Controller：用于对Controller层实现类进行标注（web层)
```
组件扫描默认是不启用。需要手动开启。开启后类上的@Component注解才能够被识别。
```java
@ComponentScan：用于类或接口上，主要是指定扫描包及子包，spring会把指定路径下带有指定注解的类自动装配到bean容器里。
会被自动装配的注解包括@Component、@Controller、@Service、@Repository等等。
@ComponentScan作用等同于xml中<context:component-scan base-package="com.test.bean" />。
```
```java
//注册组件
@Component
@Data
public class Book {
    private String title;
    private double price;
}
```

```java
//java配置类中使用组件扫描
@Configuration
@ComponentScan({"com.test.bean"})
//等同于以下方式，使用class比使用字符串更加安全
//扫描类所在的包及子包
//@ComponentScan(basePackageClasses = {Book.class})
public class BookConfig {
}
```

扫描多个包使用形式：

- @ComponentScan(basePackageClasses = {Book.class, UserDao.class})
- @ComponentScan({"com.test.bean","com.test.dao"})

#### B、@Autowired

```java
@Autowired：可以使用在属性、构造器、普通方法、构造器参数上。
使用@Autowired，但是没有匹配的bean或存在多个匹配的bean，将抛出异常。
required属性为false时，没有装配成功不会抛出异常，但是未装配的属性有可能会出现NullPointerException。
@Autowired先根据type查找，再根据name查找。不支持设置名称，
```

```java
//修饰属性时,不依赖set方法,通过反射方式注入
@Autowired
private UserDao userDao;

//修饰构造器时,使用该构造器实例化。构造器存在参数时,从ioc容器中自动获取。只有一个构造器时，@Autowired可以省略
@Autowired
public UserService(UserDao userDao) {
    this.userDao = userDao;
}

//修饰构造器属性时,会自动注入属性。当类中只有一个构造器,且是有参构造,自动装配。
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

- #### @Primary

```java
@Primary：自动装配时当找到多个Bean时，被注解为@Primary的Bean将作为首选者
```

```java
//接口存在多个实现类
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
//@Primary和@Component一起使用，当找到多个bean时，作为首选
@Primary
public class UserMysqlDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("向MySQL数据库新增一个用户~");
    }
}
```

- ==@Qualifier==

```java
@Qualifier：自动装配时当出现多个Bean候选者时，根据指定名称选择bean注入
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

```
@Resource：先根据name查找bean，再根据type查找，可以指定名称
```

```java
@Component
public class UserServiceImpl implements UserService {
    @Resource("userMysqlDaoImpl")
    private UserDao userDao;

    public void addUser() {
        userDao.addUser();
    }
}
```

### 2）通过java方式装配bean

#### @Configuration 和@Bean

````java
@Configuration：用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
````

```java
@Configuration
public class BookConfig {
    //bean的默认名称和方法名称一致，可以使用@Bean("book")方式设置bean的名称
    @Bean
    public Book book() {
        return new Book("小学生作文选", 59.9);
    }
}
```

使用java方式，创建bean时，bean之间存在依赖，使用以下方式手动装配属性。

```java
//方式一
@Bean
public Student student() {
    //Spring会拦截对book()的调用并确保返回的是Spring所创建的bean
    return new Student("张三", 18, book());
}

//方式二，推荐方式
//会在spring容器中查找id为book的bean，自动装配
@Bean
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
    <!--name表示参数的名称-->
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

**c标签，简化<constructor-arg>标签**

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
	util:set 创建一个java.util.Set类型的bean，其中包含值或引用
	util:map 创建一个java.util.Map类型的bean，其中包含值或引用
	util:properties 创建一个java.util.Properties类型的bean
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

**属性注入依赖set方法**

==使用构造器注入还是属性注入?：强依赖使用构造器注入，而对可选性的依赖使用属性注入==

```xml
<bean id="book" class="com.test.bean.Book" p:title="java编程思想" p:price="99.9"/>

<bean id="student" class="com.test.bean.Student">
    <!--name表示参数的名称-->
    <property name="name" value="张三"/>
    <property name="age" value="20"/>
    <property name="book" ref="book"/>
</bean>
```

**p标签，简化<property>标签**

```xml
<bean id="student" class="com.test.bean.Student" p:name="张三" p:age="20" p:book-ref="book"/>
```

### 4）混合配置

#### @Import

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
//导入其他配置类
@Import({BookConfig.class})
public class StudentConfig {
    @Bean
    public Student student(Book book) {
        return new Student("张三", 14, book);
    }
}
```

#### A：在JavaConfig中引用XML配置

#### @ImportResource

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
<!--注册bean-->
<bean class="com.test.config.UserConfig"/>

<!--必须要加这个，否则javaConfig中的@Bean注解不能被识别-->
<context:annotation-config/>
```

## 4、属性占位符${ }

### 1）使用@PropertySource注解和Environment获取运行时外部值

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

### 2）使用@PropertySource注解和${ }获取运行时外部值

@Value的作用是通过注解将常量、配置文件中的值、其他bean的属性值注入到变量中，作为变量的初始值。

```java
//若构造器只有一个要注入的参数，也可以将@Value写在该构造器上
@Value("张三")
public void setName(String name) {
	this.name = name;
}
```

- java方式

```java
@Component
@Data
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
    //注册bean，用于将属性文件生成k-v键值对
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

## 5、Spring EL表达式

### 1）表示字面量

```java
//数字
#{3.14}
//boolean常量
#{false}
//字符串
#{'hello'}
```

### 2）引用bean、属性和方法

```java
//引用bean
#{car}
//引用属性
#{car.brand}
//引用方法
#{car.setBrand('宝马')}
//?.类型安全运算符，防止NullPointerException，判断不为null时才调用toUpperCase()，为null时直接返回null，不再调用后续方法
#{car.getBrand()?.toUpperCase()}
```

### 3）表达式中使用类型

在SpEL中访问类作用域的方法和常量的话， 要依赖T()运算符

```java
//静态属性
#{T(java.lang.Math).PI}
//静态方法
#{T(java.lang.Math).random()}
```

### 4）运算符

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
#{ not (city.number == 300 or city.number <= 200)}
// 使用三元运算符
#{city.number > 100 ? city.number : city.number + 100}
// 设置默认值，为null时使用默认值替换
#{city.name?:'NanJing'}
// 验证邮箱地址正则表达式
#{city.info matches '(\\d{3}\\w*)?[^a-c]+(11|22)'}
```

### 5）使用集合

```java
// city类中有属性为cities的List变量, 和属性为msg的Map变量
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
#{mysql_config['jdbc.url']}

// 过滤city中cars集合price属性>50000的全部数据注入到本属性
// SpEL提供了查询运算符（.?[]），它会用来对集合进行过滤，得到集合的一个子集
#{city.cars.?[price > 50000]}

// ^表示第一条数据
// 过滤city中cars集合price属性>50000的第一条数据注入到本属性
#{city.cars.^[price > 50000]}

// $表示最后一条数据
// 过滤city中cars集合price属性<100000的最后一条数据注入到本属性
#{city.cars.$[price < 100000]}

// 假如我们在过滤cars后只想保留cars的名称,可以使用如下方式进行投影
// 集合投影语法：bean.![属性名]
#{city.cars.?[price > 50000].![brand]}
```

## 6、Bean的作用域及生命周期

### 1）scope

- 单例（ Singleton） ： 默认作用域，在整个应用中， 只创建bean的一个实例。
- 原型（ Prototype） ： 每次注入或者通过Spring Context获取的时候， 都会创建一个新的bean实例。
- 会话（ Session） ： 在Web应用中， 为每个会话创建一个bean实例。
- 请求（ Rquest） ： 在Web应用中， 为每个请求创建一个bean实例。

```xml
<!--xml方式-->
<bean id="book" class="com.test.bean.Book" scope="singleton"/>
<bean id="book" class="com.test.bean.Book" scope="prototype"/>
```

```java
//注解方式
@Data
@Scope("prototype")
//或使用ConfigurableBeanFactory中的常量值
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Book {
    private String title;
    private double price;
}
```

### 2）init-method

可以使用init-method和destroy-method设置实例化后和对象销毁前执行的方法

```java
public class User {
    public User(){
        System.out.println("User对象被实例化...");
    }

    public void init(){
        System.out.println("User的init方法被执行...");
    }

    public void destroy(){
        System.out.println("User的destroy方法被执行...");
    }
}
```

A、xml方式

```xml
<bean id="user" class="com.test.bean.User" init-method="init"/>
```

B、注解方式

```java
@PostConstruct
public void init(){
	System.out.println("User的init方法被执行...");
}
```

### 3）destroy-method

**destroy-method只对bean的scope是singleton时才生效**

调用容器的close方法关闭容器时执行bean销毁操作，ClassPathXmlApplicationContext实例.close()

A、xml方式

```xml
<bean id="user" class="com.test.bean.User" destroy-method="destroy"/>
```

B、注解方式

```java
@PreDestroy
public void destroy(){
	System.out.println("User的destroy方法被执行...");
}
```

### 4）lazy-init

**lazy-init只对bean的scope是singleton时才生效，prototype方式默认就是获取时才实例化**

A、xml方式

```xml
<!--bean对象默认是单例的，IOC容器启动时会实例化所有bean，使用lazy-init可以在获取bean时才创建-->
<bean id="user" class="com.test.bean.User" lazy-init="true"/>
```

B、注解方式

在bean上使用注解@Lazy就表示延迟加载

# 三、AOP（面向切面编程）

## 1、动态代理

### 1）JDK动态代理

```java
/**
 * 需要被代理的类实现接口，基于接口的代理
 */
public class NetJDKProxy implements InvocationHandler {
    //真实类对象
    private Net realNet;

    public NetJDKProxy(Net realNet) {
        this.realNet = realNet;
    }

    /**
     * 返回代理类对象
     *
     * @return	代理类对象
     */
    public Net getProxy() {
        /*
            Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
            参数：
            1、loader，真实类的classLoder
            2、interfaces，真实类实现的接口
            3、InvocationHandler，将代理对象关联到上面的InvocationHandler对象上
         */
        Net netProxy = (Net) Proxy.newProxyInstance(realNet.getClass().getClassLoader(), realNet.getClass().getInterfaces(), this);
        return netProxy;
    }

    /**
     * @param proxy，代理类对象
     * @param method，接口中的方法
     * @param args，方法的参数
     * @return 返回接口中方法的返回值，不清楚是什么类型，使用Object类型接收
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("设置上网代理...");
        Object result = method.invoke(realNet, args);
        System.out.println("取消上网代理...");
        return result;
    }
}

class NetJDKProxyTest {
    public static void main(String[] args) {
        Net net = new NetJDKProxy(new RealNet()).getProxy();
        net.browse();
    }
}
```

### 2）CgLib动态代理

```xml
<!--cglib动态代理依赖-->
<dependency>
	<groupId>cglib</groupId>
	<artifactId>cglib</artifactId>
	<version>3.3.0</version>
</dependency>
```

```java
/**
 * Cglib代理类是真实类的子类，通过方法覆写来实现代理
 */
public class NetCglibProxy implements MethodInterceptor {
	//真实类对象
    private Object realNet;

    //通过构造方法或其他方法，将真实类对象注入
    public NetCglibProxy(Object realNet) {
        this.realNet = realNet;
    }

    //获取代理类对象
    public Object getProxy() {
        //实例化一个增强类
        Enhancer enhancer = new Enhancer();
        //设置增强类的父类是真实类
        enhancer.setSuperclass(realNet.getClass());
        //设置代理
        enhancer.setCallback(this);

        //生成代理类对象
        return enhancer.create();
    }

    /**
     * @param o           代理类对象
     * @param method      目标方法
     * @param objects     方法参数
     * @param methodProxy 代理对象对方法的引用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("设置上网代理");
        Object result = method.invoke(realNet, objects);
        System.out.println("结束代理");
        return result;
    }
}

class NetCglibTest {
    public static void main(String[] args) {
        NetCglibProxy netCglibProxy = new NetCglibProxy(new RealNet());
        Net proxy = (Net) netCglibProxy.getProxy();
        proxy.browse();
    }
}
```

## 2、AOP基本概念

- 通知（ Advice）：切面的工作被称为通知。

  前置通知（Before） ： 在目标方法被调用之前调用通知功能；
  后置通知（After） ： 在目标方法完成之后调用通知， 此时不会关心方法的输出是什么；
  返回通知（After-returning） ： 在目标方法成功执行之后调用通知；
  异常通知（After-throwing） ： 在目标方法抛出异常后调用通知；
  环绕通知（Around） ： 通知包裹了被通知的方法， 在被通知的方法调用之前和调用之后执行自定义的行为。  

- 连接点（Join point）：连接点是在应用执行过程中能够插入切面的一个点。Spring只支持方法级别的连接点。

- 切点（Poincut）：一个切面并不需要通知应用的所有连接点，切点有助于缩小切面所通知的连接点范围。如果说通知定义了切面的“什么”和“何时”的话，那么切点就定义了“何处”。因此，切点其实就是定义了需要在哪些连接点上执行通知。

- 切面（ Aspect）：切面是通知和切点的结合。通知和切点共同定义了切面的全部内容——它是什么，在何时和在何处完成其功能。  

- 引入（ Introduction）：引入允许我们向现有的类添加新方法或属性。

- 织入（ Weaving）：织入是把切面应用到目标对象并创建新的代理对象的过程。切面在指定的连接点被织入到目标对象中。在目标对象的生命周期中有很多个点可以进行织入。

### 1）execution(表达式)

==表达式语法：execution([修饰符] 返回值类型 包名.类名.方法名(参数))==

```java
execution (* com.sample.service.impl..*.*(..))
- execution(): 表达式主体。
- 第一个*：表示返回类型，*表示所有的类型。
- 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包。
- 第二个*：表示类名，*表示所有的类。
- *(..):最后这个*表示方法名，*表示所有的方法，后面括号里面表示方法的参数，两个句点表示任何类型和个数参数。
```

```java
//拦截所有public方法
execution(public * *(..))

//拦截所有save开头的方法
execution(* save*(..))

//拦截指定类的指定方法, 拦截时一定要定位到方法
execution(* com.test.dao.UserDao.save(..))

//拦截指定类的所有方法
execution(* com.test.dao.UserDao.*(..))

//拦截指定包，以及其子包下所有类的所有方法
execution(* com..*.*(..))
```

## 3、使用注解方式

### 1）定义切面

```java
@Aspect：切面。表示一个横切进业务的一个对象。它里面包含切入点(Pointcut)和Advice（通知）。
@Pointcut：切入点。表示需要切入的位置，比如某些类或者某些方法，也就是先定一个范围。
@Before：Advice（通知）的一种，切入点的方法体执行之前执行。
@AfterReturning：Advice（通知）的一种，在切入点正常运行结束后执行，异常则不执行
@After：Advice（通知）的一种，在切入点正常运行结束后执行。
@AfterThrowing：Advice（通知）的一种，在切入点运行异常时执行。
@Around：Advice（通知）的一种，环绕切入点执行也就是把切入点包裹起来执行。
```

```java
//切面类注解
@Aspect
public class LogAspect {
    // 定义切入点，可以被多个通知引用
    @Pointcut("execution(* com.test.service.UserService.*(..))")
    private void cut() {
    }

    /**
     * 前置通知，方法执行前执行
     */
    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("连接点信息：" + joinPoint.getClass().getName());
        System.out.println("前置通知");
    }

    /**
     * 后置正常返回通知，方法正常返回后执行
     * @param result 目标方法返回值对象
     */
	@AfterReturning(pointcut = "cut()", returning = "result")
    public void afterReturn(JoinPoint joinPoint, String result) {
        System.out.println("连接点信息：" + joinPoint.getClass().getName());
        System.out.println("后置正常返回通知：" + result);
    }
    
    /**
     * 最终通知，方法执行无论是否有异常都会执行
     */
    @After("cut()")
    public void after() {
        System.out.println("最终通知");
    }

    /**
     * 异常通知，方法执行出现异常后执行
     * @param e 目标方法抛出的异常对象
     */
    @AfterThrowing(pointcut = "cut()", throwing = "e")
    public void afterThrow(Exception e) {
        System.out.println("异常通知：" + e.getMessage());
    }

    /**
     * 环绕通知
     */
    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("前置通知");
        Object result = null;
        try {
            //连接点方法调用
            result = joinPoint.proceed();
            System.out.println(result);
            System.out.println("正常返回通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }

        return result;
    }
}
```

### 2）开启AOP代理能力

#### A：注解方式

```java
@Configuration
@EnableAspectJAutoProxy
public class LogConfig {
    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
```

#### B：xml方式

```xml
<!--声明自动为spring容器中那些配置@aspectJ切面的bean创建代理，织入切面-->
<aop:aspectj-autoproxy/>
```

## 4、使用xml方式

```xml
<!--顶层的AOP配置元素。 大多数的<aop:*>元素必须包含在<aop:config>元素内-->
<aop:config>
	<!--定义切入点-->
	<aop:pointcut id="cut" expression="execution(* com.test.day07.aop.service.UserService.*(..))"/>
	<!--定义切面，切面包含切入点和通知-->
	<aop:aspect ref="logXmlAspect">
		<!--前置通知，指定切入点-->
		<aop:before method="before" pointcut-ref="cut"/>
		<!--返回通知，returning中值和方法的参数名一致-->
		<aop:after-returning method="afterReturn" pointcut-ref="cut" returning="result"/>
		<!--最终通知-->
		<aop:after method="after" pointcut-ref="cut"/>
		<!--异常通知-->
		<aop:after-throwing method="afterThrow" pointcut-ref="cut" throwing="e"/>
		<!--环绕通知-->
		<!--<aop:around method="around" pointcut-ref="cut"/>-->
	</aop:aspect>
</aop:config>
```

# 四、定时任务

```java
在线生成地址：https://www.matools.com/cron/
cron表达式是一个字符串，字符串分为6或7个域，每一个域代表一个含义
格式：
Seconds Minutes Hours DayofMonth Month DayofWeek Year
或
Seconds Minutes Hours DayofMonth Month DayofWeek
每一个域都使用数字，但还可以出现如下特殊字符，它们的含义是：

(1)*：表示匹配该域的任意值，假如在Minutes域使用*,即表示每分钟都会触发事件。
(2)?:只能用在DayofMonth和DayofWeek两个域。因为DayofMonth和DayofWeek会相互影响。
(3)-:表示范围，例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次
(4)/：表示起始时间开始触发，然后每隔固定时间触发一次，例如在Minutes域使用5/20,则意味着5分钟触发一次，而25，45等分别触发一次.
(5),:表示列出枚举值值。例如：在Minutes域使用5,20，则意味着在5和20分每分钟触发一次。
(6)L:表示最后，只能出现在DayofWeek和DayofMonth域，如果在DayofWeek域使用5L,意味着在最后的一个星期四触发。
(7)W:表示有效工作日(周一到周五),只能出现在DayofMonth域，系统将在离指定日期的最近的有效工作日触发事件。
例如：在DayofMonth使用5W，如果5日是星期六，则将在最近的工作日：星期五，即4日触发。如果5日是星期天，则在6日触发；
如果5日在星期一到星期五中的一天，则就在5日触发。另外一点，W的最近寻找不会跨过月份
(8)LW:这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五。
(9)#:用于确定每个月第几个星期几，只能出现在DayofMonth域。例如在4#2，表示某月的第二个星期三

【1】0 0 10,14,16  *  *  ? 每天10点、14点、16点
【2】0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
【3】0 0 12 ? * WED  表示每个星期三中午12点
【4】0 0 12 * * ? 每天12点触发 
【5】0 15 10 ? * * 每天10点15分触发 
【6】0 15 10 * * ? 每天10点15分触发 
【7】0 15 10 * * ? * 每天10点15分触发 
【8】0 15 10 * * ? 2005 2005年每天10点15分触发 
【9】0 * 14 * * ? 每天下午的 2点到2点59分每分触发 
【10】0 0/5 14 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发) 
【11】0 0/5 14,18 * * ? 每天下午的 2点到2点59分、18点到18点59分(整点开始，每隔5分触发) 
【12】0 0-5 14 * * ? 每天下午的 2点到2点05分每分触发 
【13】0 10,44 14 ? 3 WED 3月每周三下午的 2点10分和2点44分触发 
【14】0 15 10 ? * MON-FRI 从周一到周五每天上午的10点15分触发 
【15】0 15 10 15 * ? 每月15号上午10点15分触发 
【16】0 15 10 L * ? 每月最后一天的10点15分触发 
【17】0 15 10 ? * 6L 每月最后一周的星期五的10点15分触发 
【18】0 15 10 ? * 6L 2002-2005 从2002年到2005年每月最后一周的星期五的10点15分触发 
【19】0 15 10 ? * 6#3 每月的第三周的星期五开始触发 
【20】0 0 12 1/5 * ? 每月的第一个中午开始每隔5天触发一次 
【21】0 11 11 11 11 ? 每年的11月11号 11点11分触发(光棍节)
```

## 1、注解方式

```java
public class MonitorTask {
    //10秒执行一次
    @Scheduled(cron = "*/10 * * * * ?")
    public void run() {
		System.out.println(LocalDateTime.now() + " 监控窗口中...");
    }
}
```

1）java类方式

```
@EnableScheduling：在配置类上使用该注解开启对定时任务的支持
```

```java
@Configuration
@EnableScheduling
public class TaskConfig {
    @Bean
    public MonitorTask monitorTask() {
        return new MonitorTask();
    }
}
```

2）xml方式

```xml
<!--开启对定时任务的支持-->
<task:annotation-driven/>
```

## 2、xml方式

```java
public class LogTask {
    /**
     * 定时任务，实际上就是一个普通方法
     */
    public void run() {
        System.out.println(LocalDateTime.now() + " " + LogTask.class.getName());
    }
}
```

```xml
<task:scheduled-tasks>
    <!--10秒执行一次-->
	<task:scheduled ref="logTask" method="run" cron="*/10 * * * * ?"/>
</task:scheduled-tasks>
```

# 五、JDBC Template

 Jdbc Template是Spring对JDBC的封装，目的是使JDBC更加易于使用。

在Jdbc Template中执行SQL语句的方法大致分为3类：

- `execute`：可以执行所有SQL语句，一般用于执行DDL语句。
- `update`：用于执行`INSERT`、`UPDATE`、`DELETE`等DML语句。
- `queryXxx`：用于DQL数据查询语句。

```xml
<!--mysql数据库连接依赖-->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.25</version>
</dependency>

<!--数据源druid依赖-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.6</version>
</dependency>

<!--spring jdbc依赖-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.8</version>
</dependency>

<!--spring事务依赖-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-tx</artifactId>
    <version>5.3.8</version>
</dependency>
```

## 1、数据库配置文件jdbc.properties

````properties
#key值固定，不可更改
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=utf-8
jdbc.username=root
jdbc.password=123456
````

## 2、spring配置文件中绑定数据源

```xml
<!--加载jdbc.properties-->
<context:property-placeholder location="classpath:jdbc.properties"/>

<!--数据源对象-->
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <!--property name是druid里面的set方法，固定死的，不能改-->
    <property name="driverClassName" value="${jdbc.driver}"></property>
    <property name="url" value="${jdbc.url}"></property>
    <property name="username" value="${jdbc.username}"></property>
    <property name="password" value="${jdbc.password}"></property>
</bean>

<!--jdbc模板对象-->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <property name="dataSource" ref="dataSource"></property>
</bean>
```

## 3、获取JdbcTemplate对象进行操作

```java
@Autowired
private JdbcTemplate jdbcTemplate;
```

## 4、CRUD操作

```java
//public int update(String sql, @Nullable Object... args) throws DataAccessException
//新增操作
String sql = "insert into user(id,name, age) values(?,?,?)";
jdbcTemplate.update(sql, 2001, "Smith", 26);

//修改操作
String sql = "update user set age=? where id=?";
int count = jdbcTemplate.update(sql, "28", 2001);

//删除操作
String sql = "delete from user where id=?";
jdbcTemplate.update(sql, 2001);

//public <T> T queryForObject(String sql, Class<T> requiredType) throws DataAccessException
//统计个数
String sql = "select count(1) from user";
Long count = jdbcTemplate.queryForObject(sql, Long.class);
System.out.println(count);

//public void query(String sql, RowCallbackHandler rch, @Nullable Object... args) throws DataAccessException
//查询单个数据
User user = new User();
String sql = "select * from user where id = ?";
Object[] arr = new Object[]{1001};
jdbcTemplate.query(sql, (rs) -> {
    user.setId(rs.getInt("id"));
    user.setName(rs.getString("name"));
    user.setAge(rs.getInt("age"));
}, arr);
System.out.println(user);

//public <T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args) throws DataAccessException
//查询多条数据
User user = new User();
String sql = "select * from user where id in (?,?)";
Object[] arr = new Object[]{1001, 1002};
List<User> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
    return new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
}, arr);
System.out.println(list);
```

# 六、整合MyBatis

## 1、数据库配置文件jdbc.properties

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=utf-8
jdbc.username=root
jdbc.password=123456
```

## 2、Spring配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!--加载jdbc.properties-->
    <context:property-placeholder location="classpath:jdbc.properties"/>

    <!--配置数据源信息-->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    <!--配置sqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--绑定数据源-->
        <property name="dataSource" ref="dataSource"/>
        <!--关联Mybatis配置-->
        <property name="configLocation" value="mybatis-config.xml"/>
    </bean>

    <!--配置sqlSession-->
    <!--<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
        <constructor-arg index="0" ref="sqlSessionFactory"/>
    </bean>-->

    <!--配置userMapper对象-->
    <!--<bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
        <property name="mapperInterface" value="com.test.day10.mybatis.dao.UserDao"/>
        <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
    </bean>-->

    <!--使用MapperScannerConfigurer,不用每次都指定MapperFactoryBean-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.test.day10.mybatis.dao"/>
    </bean>
</beans>
```

## 3、mybatis配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--关联映射文件-->
    <mappers>
        <mapper resource="mapper/user-mapper.xml"/>
    </mappers>
</configuration>
```

## 4、Mapper映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.test.day10.mybatis.dao.UserDao">
    <select id="getUserById" resultType="com.test.day10.mybatis.bean.User">
        select *
        from mybatis.user
        where id = #{id}
    </select>
</mapper>
```

## 5、Java执行数据库操作

```java
//Dao接口
public interface UserDao {
    //根据ID查询用户
    public User getUserById(int id);
}
```

```java
ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
UserDao userDao = context.getBean("userDao", UserDao.class);
User user = userDao.getUserById(1001);
System.out.println(user);
```

# 七、事务

## 1、不使用事务存在的问题

如果不考虑事务的隔离性，那么就会引发如下安全性问题。

| 名称       | 数据的状态 | 实际行为                                 | 产生原因   |
| ---------- | ---------- | ---------------------------------------- | ---------- |
| 脏读       | 未提交     | 打算提交但是数据回滚了，读取了提交的数据 | 数据的读取 |
| 不可重复读 | 已提交     | 读取了修改前的数据                       | 数据的修改 |
| 幻读       | 已提交     | 读取了插入前的数据                       | 数据的插入 |


## 2、事务的传播机制

事务的传播性一般用在事务嵌套的场景，比如一个事务方法里面调用了另外一个事务方法，那么两个方法是各自作为独立的方法提交还是内层的事务合并到外层的事务一起提交，这就是需要事务传播机制的配置来确定怎么样执行。
常用的事务传播机制如下：

- PROPAGATION_REQUIRED
  Spring默认的传播机制，能满足绝大部分业务需求，如果外层有事务，则当前事务加入到外层事务，一块提交，一块回滚。如果外层没有事务，新建一个事务执行
- PROPAGATION_REQUES_NEW
  该事务传播机制是每次都会新开启一个事务，同时把外层事务挂起，当当前事务执行完毕，恢复上层事务的执行。如果外层没有事务，执行当前新开启的事务即可
- PROPAGATION_SUPPORT
  如果外层有事务，则加入外层事务，如果外层没有事务，则直接使用非事务方式执行。完全依赖外层的事务
- PROPAGATION_NOT_SUPPORT
  该传播机制不支持事务，如果外层存在事务则挂起，执行完当前代码，则恢复外层事务，无论是否异常都不会回滚当前的代码
- PROPAGATION_NEVER
  该传播机制不支持外层事务，即如果外层有事务就抛出异常
- PROPAGATION_MANDATORY
  与NEVER相反，如果外层没有事务，则抛出异常
- PROPAGATION_NESTED
  该传播机制的特点是可以保存状态保存点，当前事务回滚到某一个点，从而避免所有的嵌套事务都回滚，即各自回滚各自的，如果子事务没有把异常吃掉，基本还是会引起全部回滚的。

## 3、事务的隔离级别

事务的隔离级别定义一个事务可能受其他并发务活动活动影响的程度，可以把事务的隔离级别想象为这个事务对于事物处理数据的自私程度。

| 名称                       | 结果                                   | 脏读 | 不可重复读 | 幻读 |
| -------------------------- | -------------------------------------- | ---- | ---------- | ---- |
| Read UnCommitted(读未提交) | 什么都不解决                           | √    | √          | √    |
| Read Committed(读提交)     | 解决了脏读的问题                       | –    | √          | √    |
| Repeatable Read(重复读)    | （mysql的默认级别）解决了不可重复读 ） | –    | –          | √    |
| Serializable(序列化)       | 解决所有问题                           | –    | –          | –    |
## 4、事务的使用

```xml
<!--配置事务管理，绑定数据源-->
<bean id="transactionManager"
	  class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	<constructor-arg ref="dataSource"/>
</bean>
```

### 1）注解方式

**在类或方法上面加事务注解@Transactional**

- 如果@Transactional添加在类上面，这个类里面的所有方法都添加事务
- 如果@Transactional添加方法上面，只是为该方法都添加事务

```java
@Component
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void doUser(User user, int id) {
        userDao.addUser(user);
        System.out.println(10 / 0);
        userDao.deleteUser(id);
    }
}
```

```xml
<!--开启事务注解-->
<tx:annotation-driven transaction-manager="transactionManager"/>
```

### 2）xml方式

```xml
<!--配置事务通知-->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <tx:attributes>
        <!--spring事务传播特性：-->
        <!--事务传播行为就是多个事务方法相互调用时，事务如何在这些方法间传播。spring支持7种事务传播行为：-->
        <!--propagation_required：如果当前没有事务，就新建一个事务，如果已存在一个事务中，加入到这个事务中，这是最常见的选择。-->
        <tx:method name="doUser" propagation="REQUIRED"/>
    </tx:attributes>
</tx:advice>

<!--配置aop织入事务-->
<aop:config>
    <aop:pointcut id="txPointcut"
                  expression="execution(* com.test.day11.transaction.service.UserService.doUser(..))"/>
    <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut"/>
</aop:config>
```

