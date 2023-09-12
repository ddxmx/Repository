package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean // bean的默认名称和方法名称一致，可以使用@Bean("myDept")方式设置bean的名称
    public Dept getDept() {
        return new Dept("研发部");
    }

    @Bean("emp") // @Bean方法上的参数，会自动进行装配，必须保证参数Bean会被注册到Spring容器中
    // 方法参数默认注入方式为Autowired，即先根据类型匹配，若有多个再根据名称进行匹配
    public Emp getEmp(Dept dept) {
        return new Emp("Smith", dept);
    }
}
