package com.test.oop.day08.spel.el;

import com.test.oop.day08.spel.config.BeanConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringELTest {
    @Test
    public void spelTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        //ApplicationContext context = new ClassPathXmlApplicationContext("day08-spel.xml");
        SpringEL spel = context.getBean("springEL", SpringEL.class);
        System.out.println(spel.num); //5
        System.out.println(spel.car); //Car{brand='宝马', price=300000.0}
        System.out.println(spel.type); //Car
        System.out.println(spel.countryName); //China
        System.out.println(spel.cityName); //JiangSu-NanJing
        System.out.println(spel.upperCityName); //JIANGSU-NANJING
        System.out.println(spel.lowerCityName); //jiangsu-nanjing
        System.out.println(spel.pi); //3.141592653589793
        System.out.println(spel.random); //0.8668325686228439
        System.out.println(spel.town); //苏州-昆山
        System.out.println(spel.number); //109.42477796076938
        System.out.println(spel.logicOperation); //false
        System.out.println(spel.logicOperation2); //false
        System.out.println(spel.logicOperation3); //200
        System.out.println(spel.regularExpression); //true
        System.out.println(spel.home); //SuZhou
        System.out.println(spel.upperHome); //SUZHOU
        System.out.println(spel.mapValue); //1
        System.out.println(spel.mapStrByCities); //5
        System.out.println(spel.propertiesValue); //com.mysql.jdbc.Driver
        System.out.println(spel.carList); //[Car{brand='桑塔纳', price=90000.0}, Car{brand='宝骏', price=110000.0}, Car{brand='荣威', price=95000.0}]
        System.out.println(spel.car2); //Car{brand='桑塔纳', price=90000.0}
        System.out.println(spel.car3); //Car{brand='荣威', price=95000.0}
        System.out.println(spel.brandList); //[桑塔纳, 宝骏, 荣威]
    }
}