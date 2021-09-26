package com.test.oop.day08;

class Customer {
    String name;

    /**
     * 方法返回值使用void，则方法中不能使用"return 返回值"的形式。
     * 但是可以只使用 return; 表示结束方法
     */
    public void eat() {
        System.out.println("吃饭");
    }

    public void work(int hour) {
        System.out.println("工作了" + hour + "个小时");
    }

    /**
     * 使用return返回数据，并结束方法，返回值的数据类型和方法定义的返回值类型要一致
     * 如果方法使用void声明，不需要使用return，如果特定条件下需要结束方法，可以只使用 return; 的形式，但return后不能包含返回值
     */
    public String getCountry() {
        return "中国";
    }

    public String getCity(String city) {
        // 方法中可以调用属性和方法
        return name + "：" + getCountry() + "-江苏-" + city;
    }
}

/**
 * 方法的定义格式：
 * 修饰符 返回值类型 方法名称(参数类型1 参数名1 , 参数类型2 参数名2 , ...)
 */
public class MethodDemo {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.name = "张三";
        customer.eat(); // 吃饭
        customer.work(8); // 工作了8个小时
        System.out.println(customer.getCountry()); // 中国
        System.out.println(customer.getCity("南京")); // 张三：中国-江苏-南京
    }
}
