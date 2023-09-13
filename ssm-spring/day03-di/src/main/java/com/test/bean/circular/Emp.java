package com.test.bean.circular;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private String ename;
    private Dept dept;

    /**
     * 对象循环依赖的问题，因此生成toString方法时，不能直接打印dept对象
     */
    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", dept=" + dept.getDname() +
                '}';
    }
}
