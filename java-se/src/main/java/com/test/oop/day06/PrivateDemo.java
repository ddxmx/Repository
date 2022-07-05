package com.test.oop.day06;

/**
 * 类中的属性直接对外暴露，可能导致属性被赋值为非法值
 * java提供了封装性来解决属性和方法的访问权限问题
 * 将属性和方法封装在类中，内部实现细节不对外暴露，只暴露操作的方式（提供如public的方法）
 * 封装性不仅仅指private关键字
 * java规定了四种访问权限 private < 缺省 < protected < public
 * |- private只能在本类中访问
 * |- 缺省，只能在本类或本包中访问
 * |- protected，只能在本类或本包或不同包的子类中访问
 * |- public，任何地方都可以访问
 * 属性和方法：public、缺省、protected、private
 * 类：外部类（public、缺省），内部类（public、缺省、protected、private）
 */
class Person {
    String name;

    // 封装后外部无法直接通过“对象.属性”方式调用（'age' has private access）
    private int age;

    /**
     * 提供方法用于外部设置类中的属性，方法中可以对参数进行校验
     */
    public void setAge(int a) {
        if (a > 0) {
            age = a;
        }
    }

    /**
     * 提供方法用于外部获取类中的属性
     */
    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}

public class PrivateDemo {
    public static void main(String[] args) {
        Person per = new Person();
        per.name = "张三";

        // 属性未封装，外部直接调用，可以随便给属性赋值，数据不安全
        // 属性使用private封装后，以下代码编译错误
        // per.age = -20;

        // 通过类提供的方法设置类中的属性值，非法值进行了校验
        per.setAge(-20);
        per.printInfo(); // 姓名：张三，年龄：0

        // 传入正确的值能够正常给age赋值
        per.setAge(12);
        per.printInfo(); // 姓名：张三，年龄：12

        // 通过get方式获取类中的属性值
        int age = per.getAge();
        System.out.println(age); // 12
    }
}
