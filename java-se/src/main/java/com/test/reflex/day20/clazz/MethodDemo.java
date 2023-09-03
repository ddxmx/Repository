package com.test.reflex.day20.clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Method类的实例化及使用
 */
public class MethodDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Person.class;

        System.out.println("========================getMethod========================");
        // getMethods():获取当前类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("========================getDeclaredMethods========================");
        // getDeclaredMethods():获取当前类中声明的所有权限方法（不包含父类中声明的方法）
        /*
            public	java.lang.String	toString()
            public	java.lang.String	getName()
            public	void	setName(java.lang.String args_0)
            private	void	test()	throws java.io.IOException
            public	void	setAge(int args_0)
            public	int	    getAge()
            public	void	show()
            public	void	show(java.lang.String args_0)
            public	void	eat()
         */
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            // 1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            Arrays.stream(annotations).forEach(System.out::println);

            // 2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + " ");

            // 3.返回值类型
            System.out.print(m.getGenericReturnType().getTypeName() + " ");

            // 4.方法名
            System.out.print(m.getName());

            // 5.形参列表
            Type[] paramTypes = m.getGenericParameterTypes();
            System.out.print("(");
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getTypeName() + " args_" + i);
                if (i != paramTypes.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(") ");

            // 6.抛出的异常
            Type[] exceptionTypes = m.getGenericExceptionTypes();
            for (int i = 0; i < exceptionTypes.length; i++) {
                if (i == 0) {
                    System.out.print("throws ");
                }
                System.out.print(exceptionTypes[i].getTypeName());
                if (i != exceptionTypes.length - 1) {
                    System.out.print(",");
                }
            }

            System.out.println();
        }

        System.out.println("========================invoke========================");
        // 调用方法
        Person person = (Person) clazz.getDeclaredConstructor().newInstance();
        Method showMethod = clazz.getDeclaredMethod("show", String.class);
        showMethod.invoke(person, "中国");
    }
}
