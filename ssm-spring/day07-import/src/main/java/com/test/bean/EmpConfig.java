package com.test.bean;

import com.test.annotation.Dept;
import com.test.annotation.Emp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DeptConfig.class)
public class EmpConfig {
    @Bean
    public Emp emp(Dept dept) {
        Emp emp = new Emp();
        emp.setName("Tom");
        emp.setDept(dept);
        return emp;
    }
}
