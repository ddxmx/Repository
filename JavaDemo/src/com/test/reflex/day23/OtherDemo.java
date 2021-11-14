package com.test.reflex.day23;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class OtherDemo {
    public static void main(String[] args) {
        {
            // 获取构造器结构
            Class clazz = Person.class;
            // getConstructors():获取当前运行时类中声明为public的构造器
            /*
                public com.test.reflex.day28.Person()
                public com.test.reflex.day28.Person(java.lang.String,int)
             */
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor c : constructors) {
                System.out.println(c);
            }

            System.out.println("*******************************");
            // getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
            /*
                public com.test.reflex.day28.Person(java.lang.String,int)
                private com.test.reflex.day28.Person(java.lang.String)
                public com.test.reflex.day28.Person()
             */
            Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
            for (Constructor c : declaredConstructors) {
                System.out.println(c);
            }

            System.out.println("*******************************");
            // 获取运行时类的父类
            Class superclass = clazz.getSuperclass();
            System.out.println(superclass); // class com.test.reflex.day28.Animal

            System.out.println("*******************************");
            // 获取运行时类实现的接口
            Class[] interfaces = clazz.getInterfaces();
            for (Class c : interfaces) {
                System.out.println(c); // interface java.io.Serializable
            }

            System.out.println("*******************************");
            // 获取运行时类的父类实现的接口
            Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
            for (Class c : interfaces1) {
                System.out.println(c); // interface java.lang.Cloneable
            }

            System.out.println("*******************************");
            // 获取运行时类所在的包
            Package pack = clazz.getPackage();
            System.out.println(pack); // package com.test.reflex.day28

            System.out.println("*******************************");
            // 获取运行时类声明的注解
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation); // @java.lang.Deprecated()
            }

            // 判断是否存在指定注解
            System.out.println(clazz.isAnnotationPresent(Deprecated.class)); // true
        }
    }
}
