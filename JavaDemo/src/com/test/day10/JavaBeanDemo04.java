package com.test.day10;

/**
 * JavaBean
 * 1、类是public修饰
 * 2、存在无参构造
 * 3、属性提供get和set方法
 */
public class JavaBeanDemo04 {
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setName("Smith");
        emp.setDept("财务部");
    }
}
