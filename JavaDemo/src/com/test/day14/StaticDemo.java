package com.test.day14;

class Chinese {
    private String name;
    private int age;
    private static String country = "中华民国";
    //记录对象实例化个数
    private static int count = 0;

    public Chinese() {
        //static属性用于累计实例化个数
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

    public static void setCountry(String _country) {
        country = _country;
    }

    public static String getCountry() {
        return country;
    }

    public static int getCount() {
        return count;
    }

    /*
        静态方法的生命周期在类的生命周期范围内，非静态方法的生命周期在对象的生命周期范围内
        静态方法中只允许调用静态方法，不允许调用非静态方法；非静态方法中可以调用静态方法
        静态方法中也不允许使用this或super关键字
     */
    public static void eat() {
        System.out.println("出生国籍：" + Chinese.getCountry());
        //System.out.println("姓名：" + getName()); //编译错误，静态方法中不能调用非静态方法
    }

    /*
        非静态方法中可以调用静态方法和非静态方法
     */
    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + this.getName() + "\'" +
                ", age=" + this.getAge() +
                ", country=" + Chinese.getCountry() +
                '}';
    }
}

/**
 * 属性：静态属性和非静态属性
 * 静态属性，也叫类变量，使用static修饰的属性，属性是对象共享的，随着类的加载而加载
 * 非静态属性，也叫实例变量，属性是对象独占的，对象实例化时生成
 */
public class StaticDemo {
    public static void main(String[] args) {
        System.out.println("实例化对象个数：" + Chinese.getCount()); //0

        Chinese c1 = new Chinese("张三", 20);
        Chinese c2 = new Chinese("李四", 24);
        System.out.println(c1); //Chinese{name='张三', age=20, country=中华民国}
        System.out.println(c2); //Chinese{name='李四', age=24, country=中华民国}

        //通过一个对象修改static属性，所有对象都受到影响
        c1.setCountry("中华人民共和国");
        System.out.println(c1); //Chinese{name='张三', age=20, country=中华人民共和国}
        System.out.println(c2); //Chinese{name='李四', age=24, country=中华人民共和国}

        //推荐通过类的名称访问static属性和方法
        Chinese.setCountry("China");
        System.out.println(c1); //Chinese{name='张三', age=20, country=China}

        System.out.println("实例化对象个数：" + Chinese.getCount()); //2
    }
}
