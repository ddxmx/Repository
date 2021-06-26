package com.test.config;

import com.test.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 注释Dog和Cat类上的@Component注解，使用配置类注入
 *
 * 使用配置类创建bean:
 * 使用@Bean来修饰方法，该方法返回一个对象。
 * 不管方法体内的对象是怎么创建的，Spring可以获取得到对象就行了。
 * Spring内部会将该对象加入到Spring容器中
 * 容器中bean的ID默认为方法名
 */
//表明该类是一个配置类
@Configuration
//导入一个或多个配置类
@Import(CatConfig.class)
public class BeanConfig {
    @Bean
    public Dog getDog() {
        return new Dog();
    }
}
