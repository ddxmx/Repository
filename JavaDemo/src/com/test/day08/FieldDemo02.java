package com.test.day08;

class Person02 {
    String name; //默认值：null
    int age; //默认值：0

    public void talk(String lang) {
        String secondLanguage = "english";
        String thirdLanguage;
        System.out.println("使用" + lang + "进行交流");
        System.out.println("我们学会了第二语言：" + secondLanguage);
//        System.out.println(thirdLanguage); // 编译报错，局部变量使用前必须赋值
    }
}

/**
 * 成员变量和局部变量
 * 成员变量直接定义在类中，可以使用访问权限修饰符 public > protected > default > private，具有默认初始化值，保存在堆内存中
 * 局部变量定义在方法内、方法参数上、代码块内、构造方法内、构造方法参数上，不能使用访问权限修饰符，没有默认初始化值，保存在栈内存中
 */
public class FieldDemo02 {
    public static void main(String[] args) {
        Person02 per = new Person02();
        System.out.println(per.name);
        System.out.println(per.age);
        per.talk("中文");
    }
}
