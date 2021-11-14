package com.test.reflex.day23;

/**
 * 通过反射创建对应的运行时类的对象
 */
public class NewInstanceDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        /*
            newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。

            要想此方法正常的创建运行时类的对象，要求：
            1.运行时类必须提供空参的构造器
            2.空参的构造器的访问权限设置为public。

            在javabean中要求提供一个public的空参构造器。原因：
            1.便于通过反射，创建运行时类的对象
            2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
        */
        // 实例化Class对象方式一
        // Class<Person> clazz = Person.class;

        // 实例化Class对象方式二
        // Class<? extends Person> clazz = new Person().getClass();

        // 实例化Class对象方式三
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.test.reflex.day23.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 方式四：使用类的加载器：ClassLoader  (了解)
        // ClassLoader classLoader = NewInstanceDemo.class.getClassLoader();
        // Class clazz = classLoader.loadClass("com.test.reflex.day28.Person");

        Person person = null;
        try {
            // 使用无参构造实例化
            person = (Person) clazz.newInstance(); // Person()...
            // 使用带参数的构造方法实例化
            // person = (Person) clazz.getConstructor(String.class, int.class).newInstance("jerry", 20);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // Person{name='null', age=0}
        System.out.println(person);
    }
}
