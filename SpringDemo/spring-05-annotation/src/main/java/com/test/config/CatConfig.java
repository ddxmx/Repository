package com.test.config;

import com.test.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//表明该类是一个配置类
@Configuration
public class CatConfig {
    @Bean
    public Cat getCat(){
        return new Cat();
    }
}
