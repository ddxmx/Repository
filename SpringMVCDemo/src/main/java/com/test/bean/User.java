package com.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Length(min = 4, max = 10, message = "名字长度必须为4~10位")
    private String name;

    @Min(value = 0, message = "年龄必须大于0")
    private Integer age;
}
