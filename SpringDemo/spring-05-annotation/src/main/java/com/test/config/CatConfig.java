package com.test.config;

import com.test.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatConfig {
    @Bean
    public Cat getCat(){
        return new Cat();
    }
}
