package com.test.config;

import com.test.bean.Dept;
import com.test.bean.Emp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    //bean的默认名称和方法名称一致，可以使用@Bean("myDept")方式设置bean的名称
    public Dept dept() {
        Dept dept = new Dept();
        dept.setName("研发部");
        return dept;
    }

    @Bean
    // @Bean方法上的参数，会自动进行装配
    public Emp emp(Dept dept) {
        return new Emp("Smith", dept);
    }

}
