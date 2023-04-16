package com.test.oop.day05;

/**
 * 成员变量和局部变量
 * 成员变量直接定义在类中，可以使用访问权限修饰符（public > protected > 缺省的 > private），具有默认初始化值，保存在堆内存中
 * 局部变量定义在普通方法、构造方法和代码块内，普通方法和构造方法参数上，不能使用访问权限修饰符，没有默认初始化值，保存在栈内存中
 */
class User {
    /*
        1、基本数据类型的默认值
            byte、short、int、long：0
            float、double：0.0
            char：\u0000
            boolean：false
        2、引用数据类型的默认值
            null
     */
    String name;
    int age;
    boolean isMale;

    public void talk(String lang) { // 形参，局部变量
        // 方法中定义的变量也是局部变量
        String secondLang = "english";
        System.out.println("first language：" + lang);
        System.out.println("second language：" + secondLang);
        
        String thirdLang;
        // 编译报错，局部变量没有默认值，使用前必须赋值
        // System.out.println(thirdLang);
    }
}

public class FieldDemo {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.name); // null
        System.out.println(user.age); // 0
        System.out.println(user.isMale); // false
        /*
            first language：中文
            second language：english
         */
        user.talk("中文");
    }
}
