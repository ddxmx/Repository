# Spring MVC

# 一、引导

Spring MVC属于视图层框架。

Spring MVC基本流程

- 用户发送请求到前端控制器DispatcherServlet
- DispatcherServlet收到请求调用处理映射器HandlerMapping

- 处理映射器根据请求url找到具体的处理器，生成处理器执行链HandlerExecutionChain（包含处理器对象和处理器拦截器）返回给DispatcherServlet

- DispatcherServlet根据处理器Handler获取对应的适配器

- HandlerAdapter调用处理器Handler

- Handler（Controller）执行完成后返回ModelAndView

- HandlerAdapter返回ModelAndView

- DispatcherServlet统一将返回的ModelAndView派送到ViewResolve（视图解析器）解析

- 视图解析器解析之后返回View

- 对View进行渲染
- 响应用户

```xml
<!--spring-mvc依赖-->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-webmvc</artifactId>
	<version>5.3.8</version>
</dependency>

<!--servlet依赖-->
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>4.0.1</version>
</dependency>

<!--lombok依赖-->
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<version>1.18.20</version>
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

# 二、第一个Spring MVC

**通用错误检查**

- ==如果启动tomcat后无法展示index.jsp，提示404，检查project structure中Factes中Web Resource Directory配置是否正确==

- ==如果运行过程中请求后展示404，代码没有进入Controller，检查下project structure中Artifacts中发布的项目下，WEB-INF下是否有lib目录==

## 1、DispatcherServlet配置

```xml
<!--配置web.xml-->
<!--配置中央控制器DispatcherServlet，用于接收并转发所有请求-->
<servlet>
	<!--DispatcherServlet初始化时会初始化spring-mvc容器WebApplicationContext-->
	<servlet-name>dispatcherServlet</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<!--指定spring-mvc核心配置文件的路径。如果不指定，默认为/WEB-INF/${servlet-name}-servlet.xml-->
	<init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:springmvc.xml</param-value>
	</init-param>
	<!--标记容器是否应该在web应用程序启动的时候就加载这个servlet-->
	<!--值为正整数或者0时，表示容器在应用启动时就加载并初始化这个servlet，值越小，servlet的优先级越高，就越先被加载-->
	<load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
	<servlet-name>dispatcherServlet</servlet-name>
	<!--url-pattern可以使用两种值
	1、使用扩展名，*.xxx，如*.do、*.action
	2、使用/
	错误配置：/*,注意这里是不能这样配置的，如果这样写，最后转发到 jsp 页面的时候，仍然会由DispatcherServlet进行解析，
			 而这时候会找不到对应的Handler，从而报错！！！
	-->
	<url-pattern>/</url-pattern>
</servlet-mapping>
```

## 2、视图解析器配置

```xml
<!--配置springmvc.xml-->
<!--视图解析器-->
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<!--/WEB-INF/ 路径下的资源客户端无法直接访问-->
	<!--文件所在路径前缀-->
	<property name="prefix" value="/WEB-INF/jsp/"/>
	<!--文件所在路径后缀-->
	<property name="suffix" value=".jsp"/>
</bean>
```

## 3、控制器代码

```xml
<!--配置springmvc.xml-->
<!--扫描controller包的注解-->
<context:component-scan base-package="com.test.controller"/>
```

```java
@Controller
@RequestMapping("/demo1")
public class RequestController {
    /**
     * @return
     * @RequestMapping可以用在类或方法上 实际访问地址：项目名/demo1/test.do
     */
    @RequestMapping("/doTest")
    public ModelAndView doTest() {
        //用于将数据带到视图层
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("url", "/doTest");
        mv.addObject("msg", "hello");
        //添加视图
        //视图解析器不配置前后缀时，需要写上完整路径
        //mv.setViewName("/WEB-INF/jsp/hello.jsp");
        //视图解析器配置前后缀时，只需要写逻辑名称
        mv.setViewName("hello");
        return mv;
    }
}
```

## 4、JSP代码

```jsp
<!--index.jsp代码-->
<p><a href="demo1/doTest">/demo1/doTest</a></p>

<!--jsp/hello.jsp代码-->
<p>url：${url}</p>
<p>msg：${msg}</p>
```

# 三、Controller

## 1、@RequestMapping

```java
@RequestMapping注解用于映射url到控制器类或一个特定的处理程序方法。可用于类或方法上。
用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
@RequestMapping不指定method属性时，表示对请求方法类型不限制。
```

```java
//等价的几个注解
@GetMapping
@PostMapping 等价于 @RequestMapping(value = "/XXX", method = RequestMethod.POST)
@PutMapping
@DeleteMapping
@PatchMapping
```

method类型错误，如post请求使用get请求访问，将出现405错误

### 1）GET请求

```java
@RequestMapping(value = "/doGet",method = RequestMethod.GET)
public ModelAndView doGet() {
    //用于将数据带到视图层
    ModelAndView mv = new ModelAndView();
    //添加数据
    mv.addObject("url", "/doGet");
    mv.addObject("msg", "hello");
    //添加视图
    mv.setViewName("hello");
    return mv;
}
```

```jsp
<p><a href="demo1/doGet">发送GET请求</a></p>
```

### 2）POST请求

```java
@RequestMapping(value = "/doPost",method = RequestMethod.POST)
public ModelAndView doPost() {
	//用于将数据带到视图层
	ModelAndView mv = new ModelAndView();
	//添加数据
	mv.addObject("url", "/doPost");
	mv.addObject("msg", "hello");
	//添加视图
	mv.setViewName("hello");
	return mv;
}
```

```jsp
<form action="demo1/doPost" method="post">
    <input type="submit" value="发送POST请求">
</form>
```

## 2、数据传递到前台

以下三种方式都支持将数据传到前台

### 1）ModelAndView

```java
@RequestMapping("/doTest")
public ModelAndView doTest() {
	ModelAndView mv = new ModelAndView();
	mv.addObject("url", "/doTest");
	mv.addObject("msg", "hello");
	mv.setViewName("hello");
	return mv;
}
```

```jsp
<p><a href="demo1/doTest">/demo1/doTest</a></p>
```

### 2）ModelMap

```java
@GetMapping("/doModelMap")
public String doModelMap(ModelMap map) {
	map.put("url", "/doModelMap");
	map.put("msg", "ModelMap");
    //返回视图
	return "hello";
}
```

```jsp
<p><a href="demo1/doModelMap">通过ModelMap将数据传到前台</a></p>
```

### 3）Model

```java
@GetMapping("/doModel")
public String doModel(Model model) {
	model.addAttribute("url", "/doModel");
	model.addAttribute("msg", "Model");
    //返回视图
	return "hello";
}
```

```jsp
<p><a href="demo1/doModel">通过Model将数据传到前台</a></p>
```

## 3、Restful请求获取PATH路径占位符

传统方式操作资源：通过不同的参数来实现不同的效果！方法单一，post 和 get
http://127.0.0.1/item/queryItem.action?id=1	查询,GET
http://127.0.0.1/item/saveItem.action	新增,POST
http://127.0.0.1/item/updateItem.action	更新,POST
http://127.0.0.1/item/deleteItem.action?id=1	删除,GET或POST

使用Restful操作资源：可以通过不同的请求方式来实现不同的效果！如下：请求地址一样，但是功能可以不同！
http://127.0.0.1/item/1	查询,GET
http://127.0.0.1/item	新增,POST
http://127.0.0.1/item	更新,PUT
http://127.0.0.1/item/1	删除,DELETE

### 1）@PathVariable

通过@PathVariable可以将 URL中占位符参数绑定到控制器处理方法的入参中。
URL中的{xxx}占位符可以通过@PathVariable(“xxx“)绑定到操作方法的入参中。

```java
@Controller
@RequestMapping("/demo2")
public class RestfulController {
    @RequestMapping("/test/{info}/{id}")
    public String doTest(@PathVariable String info, @PathVariable Integer id, HttpServletRequest request) {
        request.setAttribute("url", "/test/" + info + "/" + id);
        request.setAttribute("msg", "@PathVariable");
        return "hello";
    }
}
```

```jsp
<p><a href="demo2/test/action/123">获取请求中的路径</a></p>
```

## 4、接收请求中的参数

### 0）==解决请求参数中文乱码的问题==

```xml
<!--在web.xml中配置过滤器-->
<filter>
	<filter-name>CharacterEncodingFilter</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<!--设置项目中使用的字符编码-->
	<init-param>
		<param-name>encoding</param-name>
		<param-value>utf-8</param-value>
	</init-param>
	<!--强制请求对象使用encoding设置的编码方式-->
	<init-param>
		<param-name>forceRequestEncoding</param-name>
		<param-value>true</param-value>
	</init-param>
	<!--强制响应对象使用encoding设置的编码方式-->
	<init-param>
		<param-name>forceResponseEncoding</param-name>
		<param-value>true</param-value>
	</init-param>
</filter>

<filter-mapping>
	<filter-name>CharacterEncodingFilter</filter-name>
	<!--强制所有的请求先通过过滤器-->
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

```xml
SpringMVC的@ResponseBody注解可以将请求方法返回的对象直接转换成JSON对象，但是当返回值是String的时候，中文会乱码，
原因是因为其中字符串转换和对象转换用的是两个转换器，而String的转换器中固定了转换编码为"ISO-8859-1"；
在@RequestMapping中的produces指定编码格式，可以解决此问题。也可以在springmvc.xml中统一配置
<!-- 能支持springmvc更高级的一些功能，JSR303，快捷的ajax -->
<mvc:annotation-driven>
	<mvc:message-converters register-defaults="true">
		<bean class="org.springframework.http.converter.StringHttpMessageConverter">
			<constructor-arg value="UTF-8"/>
		</bean>
	</mvc:message-converters>
</mvc:annotation-driven>
```

### 1）逐个接收参数，请求中参数名和方法中参数名一致

==**方法中的参数名称和请求中的参数名称必须一致**==

```java
@Controller
@RequestMapping("/demo3")
//当前类中的所有方法返回字符串
@ResponseBody
public class ParamController {
    //produces指定返回字符串的编码格式
    @PostMapping(value = "/doEachParam",produces = {"text/plain;charset=utf-8"})
    public String paramDo(String name, Integer age) {
        String msg = "name = " + name + ",age = " + age;
        //通过post请求提交的数据，请求体里面的中文会有乱码问题，需要在CharacterEncodingFilter中统一配置
        System.out.println(msg);
        return msg;
    }
}
```

```jsp
<form method="post" action="demo3/doEachParam">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="逐个接收请求中的参数，参数名称一致">
</form>
```

### 2）逐个接收参数，请求中参数名和方法中参数名不一致

@RequestParam

```java
@RequestParam：将请求参数绑定到控制器的方法参数上（是springmvc中接收普通参数的注解）
语法：@RequestParam(value=”参数名”,required=”true/false”,defaultValue=””)
value：请求中参数名
required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。
defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值
```

```java
//produces指定返回字符串的编码格式
@PostMapping(value = "/doIgnoreParam", produces = {"text/plain;charset=utf-8"})
//参数不要使用基本数据类型，当参数名不匹配赋值失败时，基本数据类型无法赋值为null，将导致异常
public String doIgnoreParam(@RequestParam("name") String userName, @RequestParam(value = "age", required = false) Integer userAge) {
	String msg = "userName = " + userName + ",userAge = " + userAge;
	System.out.println(msg);
	return msg;
}
```

```jsp
<form method="post" action="demo3/doIgnoreParam">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="逐个接收请求中的参数，参数名称不一致">
</form>
```

### 3）使用对象接收参数

```java
/**
 * 前端传递的参数会使用接收对象的属性设置值
 * 属性名称不一致时属性值为null
 */
@PostMapping(value = "/doObjectParam",produces = {"text/plain;charset=utf-8"})
//User对象的创建由框架自己完成
public String paramObjectDo(User user) {
	System.out.println(user);
	return user.toString();
}
```

```jsp
<form method="post" action="demo3/doObjectParam">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="使用对象接收参数">
</form>
```

## 5、返回数据

### 1）视图（model AndView）

### 2）字符串

### 3）返回json数据

```xml
<!--用于controller返回对象时转换为json数据-->
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.12.4</version>
</dependency>
```

```java
@GetMapping("/doJsonResult")
public User doJsonResult() {
	User user = new User("jerry", 12);
	//返回的对象会自动转换为json，同时响应的Content-Type为application/json
	return user;
}
```

## 6、使用RestController代替Controller

```java
@RestController：使用在类上，相当于@ResponseBody＋@Controller
```

## 7、转发与重定向

1）转发

#### A：方式一

```java
@GetMapping("/doForward")
public String doForward(HttpServletRequest request) {
	request.setAttribute("url", "/doForward");
	request.setAttribute("msg", "转发方式一");
	return "hello";
}
```

```jsp
<p><a href="demo5/doForward">转发方式一</a></p>
```

#### B：方式二

```java
@GetMapping("/doAnotherForward")
public String doAnotherForward(HttpServletRequest request) {
	request.setAttribute("url", "/doAnotherForward");
	request.setAttribute("msg", "转发方式二");
	//带了forward:后不再被视图解析器处理前后缀
	return "forward:/WEB-INF/jsp/hello.jsp";
}
```

```jsp
<p><a href="demo5/doAnotherForward">转发方式二</a></p>
```

2）重定向

```java
/**
 * 重定向方式
 * 重定向方式无法访问WEB-INF下的资源
 *
 * @param request
 * @return
 */
@GetMapping("/doRedirect")
public String doRedirect(HttpServletRequest request) {
	//重定向方式无法获取之前request中的参数
	request.setAttribute("url", "/doRedirect");
	request.setAttribute("msg", "重定向方式");

	//redirect:后不再被视图解析器处理前后缀
	//重定向方式是返回给客户端一个新的url，让客户端重新请求，无法访问WEB-INF下的资源，转发可以访问
	//return "redirect:/WEB-INF/jsp/hello.jsp";

	return "redirect:http://www.baidu.com";
}
```

```jsp
<p><a href="demo5/doRedirect">重定向方式</a></p>
```

# 四、拦截器

在实现上基于Java的反射机制，属于面向切面编程（AOP）的一种运用。由于拦截器是基于web框架的调用，因此可以使用Spring的依赖注入（DI）进行一些业务操作，同时一个拦截器实例在一个controller生命周期之内可以多次调用。但是缺点是只能对controller请求进行拦截，对其他的一些比如直接访问静态资源的请求则没办法进行拦截处理。

```java
/**
 * 拦截器是SpringMVC框架自己的，只有使用了SpringMVC框架的工程才能使用
 * 拦截器只会拦截访问的Controller方法， 如果访问的是jsp/html/css/image/js是不会进行拦截的
 */
public class MyInterceptor implements HandlerInterceptor {
    //在请求处理的方法之前执行
    //如果返回true执行下一个拦截器
    //如果返回false就不执行下一个拦截器
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("------------处理前------------");
        return true;
    }

    //在请求处理方法执行之后执行
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView
                                   modelAndView) throws Exception {
        System.out.println("------------处理后------------");
    }

    //在dispatcherServlet处理后执行,做清理工作 .
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("------------清理------------");
    }
}
```

```xml
<--在application-context.xml中配置拦截器-->
<!--关于拦截器的配置-->
<mvc:interceptors>
	<mvc:interceptor>
		<!--/** 包括路径及其子路径-->
		<!--/admin/* 拦截的是/admin/add等等这种 , /admin/add/user不会被拦截-->
		<!--/admin/** 拦截的是/admin/下的所有-->
		<mvc:mapping path="/demo4/*"/>
		<!--bean配置的就是拦截器-->
		<bean class="com.test.interceptor.MyInterceptor"/>
	</mvc:interceptor>
</mvc:interceptors>
```

# 五、过滤器

依赖于servlet容器。在实现上基于函数回调，可以对几乎所有请求进行过滤，但是缺点是一个过滤器实例只能在容器初始化时调用一次。

使用过滤器的目的是用来做一些过滤操作，获取我们想要获取的数据，比如：在过滤器中修改字符编码；在过滤器中修改HttpServletRequest的一些参数，包括：过滤低俗文字、危险字符等。

```java
/**
 * 过滤器
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤处理");
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (uri.contains("/demo5")) {
            ((HttpServletResponse) servletResponse).sendRedirect("http://www.baidu.com");
        } else {
            //将请求转发给过滤器链下一个filter,如果没有filter那就是请求的资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
```

```xml
<!--web.xml中注册过滤器，过滤器执行的顺序和配置的顺序一致-->
```

```xml
<!--在一个web应用中，可以开发编写多个Filter，这些Filter组合起来称之为一个Filter链。
web服务器根据Filter在web.xml文件中的注册顺序执行-->
<filter>
	<filter-name>crossFilter</filter-name>
	<filter-class>com.test.filter.MyFilter</filter-class>
</filter>
<filter-mapping>
	<filter-name>crossFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```



