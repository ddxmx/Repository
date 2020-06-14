package com.test.config;

import com.test.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CatConfig.class)  //导入一个或多个配置类
public class BeanConfig {

    @Bean
    public Dog getDog() {
        return new Dog();
    }
}
