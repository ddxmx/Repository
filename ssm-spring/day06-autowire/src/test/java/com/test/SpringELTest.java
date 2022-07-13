package com.test;

import com.test.el.SpringEL;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringELTest {
    @Test
    public void spelTest() {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring/applicationContext-spel.xml");
        SpringEL el = context.getBean("springEL", SpringEL.class);
        System.out.println(el.num); // 5
        System.out.println(el.car); // Car(brand=宝马, price=300000.0)
        System.out.println(el.type); // Car
        System.out.println(el.color); // black
        System.out.println(el.countryName); // China
        System.out.println(el.cityName); // JiangSu-NanJing
        System.out.println(el.upperCityName); // JIANGSU-NANJING
        System.out.println(el.lowerCityName); // jiangsu-nanjing
        System.out.println(el.pi); // 3.141592653589793
        System.out.println(el.random); // 0.8668325686228439
        System.out.println(el.town); // 苏州-昆山
        System.out.println(el.number); // 109.42477796076938
        System.out.println(el.logicOperation); // false
        System.out.println(el.logicOperation2); // false
        System.out.println(el.logicOperation3); // 200
        System.out.println(el.regularExpression); // true
        System.out.println(el.home); // SuZhou
        System.out.println(el.upperHome); // SUZHOU
        System.out.println(el.mapValue); // 1
        System.out.println(el.mapStrByCities); // 5
        System.out.println(el.propertiesValue); // com.mysql.jdbc.Driver
        System.out.println(el.carList); // [Car{brand='桑塔纳', price=90000.0}, Car{brand='宝骏', price=110000.0}, Car{brand='荣威', price=95000.0}]
        System.out.println(el.car2); // Car{brand='桑塔纳', price=90000.0}
        System.out.println(el.car3); // Car{brand='荣威', price=95000.0}
        System.out.println(el.brandList); // [桑塔纳, 宝骏, 荣威]
    }
}