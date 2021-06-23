package com.test.day13;

class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
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
     * 覆写equals方法，java.lang.Object类中的equals方法默认比较的是内存地址
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        if (obj.getClass() == this.getClass()) {
            User user = (User) obj;
            if (null != this.name) {
                if (this.name.equals(user.name) && this.age == user.age) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * Object类是所有类的根父类，一个类没有使用extends显示继承类，则默认继承java.lang.Object类
 * Object类可以接收所有的引用数据类型
 */
public class ObjectDemo {
    public static void main(String[] args) {
        User user1 = new User("张三", 20);
        User user2 = new User("张三", 20);
        User user3 = new User("张三", 22);

        System.out.println(user1 == user2); //false
        System.out.println(user1.equals(user2)); //true，覆写equals方法后，属性都相等，结果相等
        System.out.println(user1.equals(user1)); //true
        System.out.println(user1.equals(null)); //false
        System.out.println(user1.equals(user3)); //false

        //单独使用对象或与字符串拼接时，默认会调用对象的toString方法
        System.out.println(user1); //User{name='张三', age=20}
        System.out.println(user1.toString()); //User{name='张三', age=20}
    }
}
