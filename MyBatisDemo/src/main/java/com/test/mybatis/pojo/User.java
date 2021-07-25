package com.test.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 实体类不要使用基本数据类型
 * 基本数据类型具有默认值，将无法赋值为null
 * 在动态SQL中，例如age != null的判断将永远为true，会出现一些隐藏的问题
 */
@Alias("testUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
