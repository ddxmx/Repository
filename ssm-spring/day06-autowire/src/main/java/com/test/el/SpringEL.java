package com.test.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * spring el表达水
 */
@Component
public class SpringEL {
    /*
     * @Value注解等同于XML配置中的<property/>标签,
     * SpringEL同样支持在<property/>中编写
     */
    // 注入简单值,输出num为5
    @Value("#{5}")
    public int num;

    // 注入ID为car的Bean
    @Value("#{car}")
    public Car car;

    // 注入ID为car Bean中的TYPE常量/变量
    @Value("#{car.TYPE}")
    public String type;

    // 设置默认值，如果car中color属性为null，设置color属性值为black
    @Value("#{car.color?:'black'}")
    public String color;

    // 调用无参方法
    @Value("#{city.getCountry()}")
    public String countryName;

    // 调用有参方法
    @Value("#{city.getName('NanJing')}")
    public String cityName;

    /*
     * 调用方法返回的String为大写
     */
    @Value("#{city.getName('NanJing').toUpperCase()}")
    public String upperCityName;

    /*
     * 以上如果getName方法为null，将会抛出NullPointerException,可以使用以下方式避免
     * 使用?.符号代表左边的值为null,将不执行右边方法,
     * 只要左边可能返回null,即可使用上面示例中的?.
     */
    @Value("#{city.getName('NanJing')?.toLowerCase}")
    public String lowerCityName;

    /**
     * T()表达式，如果不用T()，则会错误认为是一个bean名称
     */
    /*
     * 注入JDK中的工具类常量或调用工具类的方法
     */
    // 获取Math的PI常量
    @Value("#{T(java.lang.Math).PI}")
    public double pi;

    // 调用random方法获取返回值
    @Value("#{T(java.lang.Math).random()}")
    public double random;

    /*
     * 使用SpringEL进行运算及逻辑操作
     */
    // 拼接字符串
    @Value("#{city.SUZHOU + '-' + city.KUNSHAN}")
    public String town;

    // 对数字类型进行运算,city拥有number属性
    @Value("#{ 3 * T(java.lang.Math).PI + city.number}")
    public double number;

    // 进行逻辑与运算
    @Value("#{city.number > 100 and city.number <= 200}")
    public boolean logicOperation;

    // 进行或非逻辑操作
    @Value("#{ not (city.number == 100 or city.number <= 200)}")
    public boolean logicOperation2;

    // 使用三元运算符
    @Value("#{city.number > 100 ? city.number : city.number + 100}")
    public Integer logicOperation3;

    // 验证是否邮箱地址正则表达式
    @Value("#{city.STR matches '(\\d{3}\\w*)?[^a-c]+(11|22)'}")
    public boolean regularExpression;

    /*
     * city类中拥有名为testList的List变量, 和名为testMap的Map
     */
    // 获取下标为0的元素
    @Value("#{city.cities[0]}")
    public String home;

    // 获取下标为0元素的大写形式
    @Value("#{city.cities[0]?.toUpperCase()}")
    public String upperHome;

    // 获取map中key为hello的value
    @Value("#{city.msg['hello']}")
    public int mapValue;

    // 根据cities下标为4元素作为key获取msg的value
    @Value("#{city.msg[city.cities[4]]}")
    public String mapStrByCities;

    /*
        <!-- 首先通过applicationContext.xml中<util:properties>增加properties文件 -->
        <util:properties id="mysql_config" location="classpath:application.properties"/>
     */
    // 注意mysql_config为xml文件中声明的id
    @Value("#{mysql_config['jdbc.url']}")
    public String propertiesValue;

    // .?过滤所有
    // 过滤city中cityList集合price属性大于50000的全部数据注入到本属性
    @Value("#{city.cars.?[price > 50000]}")
    public List<Car> carList;

    // .^过滤第一条数据
    // 过滤city中cars集合price属性>50000的第一条数据注入到本属性
    @Value("#{city.cars.^[price > 50000]}")
    public Car car2;

    // .$过滤最后一条数据
    // 过滤city中cars集合price属性小于100000的最后一条数据注入到本属性
    @Value("#{city.cars.$[price < 100000]}")
    public Car car3;

    /*
     * 集合投影语法：bean.![属性名]
     * 假如我们在过滤车后只想保留车的名称,
     * 可以使用如下方式进行投影
     */
    @Value("#{city.cars.?[price > 50000].![brand]}")
    public List<String> brandList;
}
