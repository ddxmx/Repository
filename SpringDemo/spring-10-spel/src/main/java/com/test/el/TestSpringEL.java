package com.test.el;

import com.test.constant.TestConstant;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * SpEL 字面量：
 * - 整数：#{8}
 * - 小数：#{8.8}
 * - 科学计数法：#{1e4}
 * - String：可以使用单引号或者双引号作为字符串的定界符号。
 * - Boolean：#{true}
 * SpEL引用bean , 属性和方法：
 * - 引用其他对象:#{car} - 引用其他对象的属性：#{car.brand}
 * - 调用其它方法 , 还可以链式操作：#{car.toString()}
 * - 调用静态方法静态属性：#{T(java.lang.Math).PI}
 * SpEL支持的运算符号：
 * -算术运算符：+，-，*，/，%，^(加号还可以用作字符串连接)
 * - 比较运算符：< , > , == , >= , <= , lt , gt , eg , le , ge
 * - 逻辑运算符：and , or , not , |
 * - if-else 运算符(类似三目运算符)：？:(temary), ?:(Elvis)
 * - 正则表达式：#{admin.email matches ‘[a-zA-Z0-9._%±]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}’}
 */
public class TestSpringEL {
    /*
     * @Value注解等同于XML配置中的<property/>标签,
     * SpringEL同样支持在XML<property/>中编写
     */
    // 注入简单值,输出num为5
    @Value("#{5}")
    private Integer num;

    // 注入ID为testConstant的Bean
    @Value("#{testConstant}")
    private TestConstant Constant;

    // 注入ID为testConstant Bean中的STR常量/变量
    @Value("#{testConstant.STR}")
    private String str;

    /*
     * TestConstant类中有两个方法重载,
     * 返回值为String类型
     */
    // 调用无参方法
    @Value("#{testConstant.showProperty()}")
    private String method1;

    // 有参接收字符串的方法
    @Value("#{testConstant.showProperty('Hello')}")
    private String method2;

    /*
     * 若然希望方法返回的String为大写
     */
    @Value("#{testConstant.showProperty().toUpperCase()}")
    private String method3;

    /*
     * 若使用method3这种方式,若然showProperty返回为null,
     * 将会抛出NullPointerException,可以使用以下方式避免
     */
    @Value("#{testConstant.showProperty()?.toUpperCase}")
    private String method4;

    /*
     * 使用?.符号代表若然左边的值为null,将不执行右边方法,
     * 读者可以灵活运用在其他场景,只要左边可能返回null,
     * 即可使用上面示例中的?.
     */

    /*
     * 注入JDK中的工具类常量或调用工具类的方法
     */
    // 获取Math的PI常量
    @Value("#{T(java.lang.Math).PI")
    private double pi;

    /**
     * T()表达式，如果不用T()，则会错误认为是一个bean名称
     */
    // 调用random方法获取返回值
    @Value("#{T(java.lang.Math).random()}")
    private double ramdom;

    /*
     * 使用SpringEL进行运算及逻辑操作
     */
    // 拼接字符串
    @Value("#{testConstant.nickname + ' ' + testConstant.name}")
    private String concatString;

    // 对数字类型进行运算,testConstant拥有num属性
    @Value("#{ 3 * T(java.lang.Math).PI + testConstant.num}")
    private double operation;

    // 进行逻辑运算
    @Value("#{testConstant.num > 100 and testConstant.num <= 200}")
    private boolean logicOperation;

    // 进行或非逻辑操作
    @Value("#{ not testConstant.num == 100 or testConstant.num <= 200}")
    private boolean logicOperation2;

    // 使用三元运算符
    @Value("#{testConstant.num > 100 ? testConstant.num : testConstant.num + 100}")
    private Integer logicOperation3;

    // 验证是否邮箱地址正则表达式
    @Value("#{testConstant.STR matches '\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+'}")
    private boolean regularExpression;

    /*
     * TestConstant类中拥有名为testList的List变量, 和名为testMap的Map
     */
    // 获取下标为0的元素
    @Value("#{testConstant.testList[0]}")
    private String str2;

    // 获取下标为0元素的大写形式
    @Value("#{testConstant.testList[0]?.toUpperCase()}")
    private String upperStr;

    // 获取map中key为hello的value
    @Value("#{testConstant.testMap['hello']}")
    private String mapValue;

    // 根据testList下标为0元素作为key获取testMap的value
    @Value("#{testConstant.testMap[testConstant.testList[0]]}")
    private String mapStrByTestList;

    /*
        <!-- 首先通过applicaContext.xml中<util:properties>增加properties文件 -->
        <!-- 注意需要引入Spring的util schemea命名空间和注意id属性,id属性将在SpringEL中使用 -->
        <util:properties id="test" location="classpath:application.properties"/>
     */
    // 注意test为xml文件中声明的id
    @Value("#{test['jdbc.url']}")
    private String propertiesValue;

    /*
     * 声明City类,有population属性 testContants拥有名叫cityList的City类List集合
     * 必须使用.?查询运算符
     */
    // 过滤testConstant中cityList集合population属性大于1000的全部数据注入到本属性
    @Value("#{testConstant.cityList.?[population > 1000]}")
    private List<City> cityList;

    //^表示第一条数据
    // 过滤testConstant中cityList集合population属性等于1000的第一条数据注入到本属性
    @Value("#{testConstant.cityList.^[population == 1000]}")
    private City city;

    //$表示最后一条数据
    // 过滤testConstant中cityList集合population属性小于1000的最后一条数据注入到本属性
    @Value("#{testConstant.cityList.$[population < 1000]}")
    private City city2;

    /*
     * 首先为city增加name属性,代表城市的名称
     */
    /*
     * 假如我们在过滤城市集合后只想保留城市的名称,
     * 可以使用如下方式进行投影
     * 集合投影语法：bean.![属性名]
     */
    @Value("#{testConstant.cityList.?[population > 1000].![name]}")
    private List<String> cityName;

    //1.测试集合或数组
    //#this表示集合中每一个元素
/*    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(4);
    list.add(5);
    list.add(7);
    Collection<Integer> result1 = parser.parseExpression("#list.?[#this>4]").getValue(context1, Collection.class);*/


}
