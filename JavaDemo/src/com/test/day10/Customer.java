package com.test.day10;

/**
 * JavaBean的特点
 * 1、类的权限是public
 * 2、存在无参构造器
 * 3、属性使用private封装
 * 4、属性提供了setter和getter方法
 */
public class Customer {
    private int id;
    private String name;

    //无参构造，后续通过反射进行对象的实例化操作需要依赖无参构造
    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}