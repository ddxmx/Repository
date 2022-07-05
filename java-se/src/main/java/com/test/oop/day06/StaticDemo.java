package com.test.oop.day06;

/**
 * 属性：分为静态属性和非静态属性
 * 静态属性，也叫类变量，使用static修饰，属性是所有对象共享的，随着类的加载而加载
 * 非静态属性，也叫实例变量，属性是对象独占的，不同对象的属性不同，对象实例化时生成
 */
class Chinese {
    private String name;
    private int age;
    // 如果所有对象的某个属性值相同，则该属性可以使用static修饰
    private static String country = "中国";
    // 记录对象实例化个数
    private static int count = 0;

    public Chinese() {
        // 使用static属性统计实例化个数
        count++;
    }

    public Chinese(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * static属性的get和set方法
     */
    public static void setCountry(String country) {
        Chinese.country = country;
    }

    public static String getCountry() {
        return Chinese.country;
    }

    public static int getCount() {
        return count;
    }

    /**
     * 静态属性和方法先于实例化对象产生，因此调用静态属性或方法时，可能尚未产生实例化对象
     * 静态方法的生命周期在类的生命周期范围内，非静态方法的生命周期在对象的生命周期范围内
     * 静态方法中只允许调用静态方法，不允许调用非静态方法；非静态方法中可以调用静态方法
     * 静态方法中也不允许使用this或super关键字
     */
    public static void printCountry() {
        System.out.println("国籍：" + Chinese.getCountry());

        // 编译错误，静态方法中不能调用非静态方法
        // System.out.println("姓名：" + getName());
    }

    /**
     * 非静态方法中可以调用静态方法和非静态方法
     */
    public void printInfo() {
        System.out.println("姓名：" + this.getName()
                + "，年龄：" + this.getAge()
                + "，国籍：" + Chinese.getCountry()
        );
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("实例化对象个数：" + Chinese.getCount()); // 0

        Chinese c1 = new Chinese("张三", 20);
        Chinese c2 = new Chinese("李四", 24);
        c1.printInfo(); // 姓名：张三，年龄：20，国籍：中国
        c2.printInfo(); // 姓名：李四，年龄：24，国籍：中国
        System.out.println("实例化对象个数：" + Chinese.getCount()); // 2

        // 通过一个对象修改static属性，所有对象都受到影响
        c1.setCountry("中华人民共和国");
        c1.printInfo(); // 姓名：张三，年龄：20，国籍：中华人民共和国
        c2.printInfo(); // 姓名：李四，年龄：24，国籍：中华人民共和国

        // 推荐通过类访问static属性和方法，而不是使用对象访问
        Chinese.setCountry("China");

        c1.printInfo(); // 姓名：张三，年龄：20，国籍：China
        c2.printInfo(); // 姓名：李四，年龄：24，国籍：China
    }
}
