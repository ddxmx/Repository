package com.test.oop.day05;

/**
 * 成员方法
 */
class Customer {
    String name;

    /**
     * 方法返回值使用void，则方法中不能使用"return 返回值"的形式。
     * 但是可以只使用 return; 表示结束方法
     * return语句不是必须的，但是return之后不能有语句，因为无法被执行到
     */
    public void eat() {
        System.out.println("Customer.eat");
    }

    /**
     * 方法可以接收参数
     */
    public void work(int hour) {
        System.out.println("Customer.work：" + hour);
    }

    /**
     * 使用return返回数据，并结束方法，返回值的数据类型和方法定义的返回值类型要一致
     */
    public String getCountry() {
        return "中国";
    }

    public String getCity(String city) {
        // 方法中可以调用属性和方法
        return name + "：" + getCountry() + "-" + city;
    }

    /**
     * 扩展：实例方法实际上也可以改写成静态方法
     * 比如public String getCity(String city)
     */
    public static String getCity(String city, Customer customer) {
        return customer.name + "：" + customer.getCountry() + "-" + city;
    }

}

/**
 * 方法的定义格式：
 * 修饰符 返回值类型 方法名称(参数类型1 参数名1 , 参数类型2 参数名2 , ...)
 * 定义方法并不会导致方法被执行，方法执行需要被调用
 * 方法的执行过程实际上是进栈和出栈的过程，栈中保存了返回的方法地址、方法的参数和方法内定义的变量，返回值有专门的存储器存储
 * 对于基本数据类型，方法的参数和方法内定义的变量都保存在栈内存中
 * 对于引用数据类型，参数和变量实际存储在堆内存，栈中存储的是堆内存的访问地址
 * 方法执行完后栈中参数和变量出栈，但堆内存不会释放，直到无任何栈空间指向
 */
public class MethodDemo {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.name = "张三";
        customer.eat(); // Customer.eat
        customer.work(8); // Customer.work：8
        System.out.println(customer.getCountry()); // 中国
        System.out.println(customer.getCity("南京")); // 张三：中国-南京
        System.out.println(Customer.getCity("南京", customer)); // 张三：中国-南京
    }
}
