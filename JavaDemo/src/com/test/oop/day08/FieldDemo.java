package com.test.oop.day08;

/**
 * 成员属性
 */
class User {
    /*
        |-基本数据类型的默认值
            byte short int long 0
            float double    0.0
            char    \u0000
            boolean false
        |-引用数据类型// String类型的默认值是null
            null
     */
    String name; // 引用类型默认值：null
    int age; // int类型默认值：0
    boolean isMale; // boolean类型默认值false

    public void talk(String language) { // 形参，局部变量
        // 方法中定义的变量也是局部变量
        String secondLanguage = "english";
        System.out.println("使用第一语言：" + language + "进行交流");
        System.out.println("学会了第二语言：" + secondLanguage);
        String thirdLanguage;
        // 编译报错，局部变量没有默认值，使用前必须赋值
        // System.out.println(thirdLanguage);
    }
}

/**
 * 成员变量和局部变量
 * 成员变量直接定义在类中，可以使用访问权限修饰符 public > protected > 缺省的 > private，具有默认初始化值，保存在堆内存中
 * 局部变量定义在方法内、方法参数上、代码块内、构造方法内、构造方法参数上，不能使用访问权限修饰符，没有默认初始化值，保存在栈内存中
 */
public class FieldDemo {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.name); // null
        System.out.println(user.age); // 0
        System.out.println(user.isMale); // false
        /*
            使用第一语言：中文进行交流
            学会了第二语言：english
         */
        user.talk("中文");
    }
}
