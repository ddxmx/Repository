package com.test.day10;

/**
 * 封装性：高内聚，低耦合
 * 将属性和方法封装在类中，内部实现细节不对外暴露，只暴露操作的方式（公开的方法）
 * 封装性不仅仅指private关键字
 *
 * java规定了四种访问权限 private < 缺省(不使用任何关键字) < protected < public
 * 访问权限     当前类  当前包其他类	非当前包子类	非当前包非子类
 * public       是	    是	        是	        是
 * protected    是	    是	        是	        否
 * default      是	    是	        否	        否
 * private      是	    否	        否	        否
 *
 * 属性和方法：public、缺省、protected、private
 * 类：外部类（public、缺省），内部类（public、缺省、protected、private）
 */
class Person {
    String name;

    //封装后外部无法直接通过“对象.age”方式调用，'age' has private access
    private int age;

    /**
     * 提供方法给对象调用，方法中对参数进行校验
     *
     * @param _age
     */
    public void setAge(int _age) {
        if (_age >= 0) {
            age = _age;
        }
    }

    /**
     * 提供方法获取 age,一般针对封装属性都提供set方法和get方法
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}

public class PrivateDemo {
    public static void main(String[] args) {
        Person per = new Person();
        per.name = "张三";
        //per.age = -20; //属性未封装，外部直接调用，可以随便给属性赋值，数据不安全，可以将属性封装，只提供方法
        per.setAge(-20);
        per.show(); //姓名：张三，年龄：0

        //外部调用get方法
        per.setAge(12);
        int age = per.getAge();
        System.out.println("年龄：" + age); //年龄：12
    }
}