package com.test.day08;

import java.text.SimpleDateFormat;
import java.util.Date;

class Customer {
    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep(int hour) {
        System.out.printf("休息了%s个小时\n", hour);
    }

    /**
     * 使用return返回数据，并结束方法，返回的数据类型和方法的返回值类型要一致
     * 如果方法使用void声明，不需要使用return，如果特定条件下需要结束方法，可以使用return，但不能带数据
     *
     * @return
     */
    public String getTimeString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date());
    }
}

/**
 * 方法定义描述
 * 修饰符 返回值类型 方法名称(参数类型1 参数名1 , 参数类型2 参数名2 , ...)
 */
public class MethodDemo03 {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.eat(); // 吃饭
        customer.sleep(8); // 休息了8个小时
        System.out.println(customer.getTimeString()); // 2020-05-06 20:27:06
    }
}
