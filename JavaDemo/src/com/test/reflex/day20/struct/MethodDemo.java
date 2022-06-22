package com.test.reflex.day20.struct;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * Method类的实例化及使用
 */
public class MethodDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.test.reflex.day20.Person");

        // getMethods():获取当前类及其所有父类中声明为public权限的方法
        System.out.println("***************getMethod***************");
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        // getDeclaredMethods():获取当前类中声明的所有方法（不包含父类中声明的方法）
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
        System.out.println("***************getDeclaredMethods***************");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            // 1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            // 2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            // 3.返回值类型
            System.out.print(m.getGenericReturnType().getTypeName() + "\t");

            // 4.方法名
            System.out.print(m.getName());

            // 5.形参列表
            Type[] parameterTypes = m.getGenericParameterTypes();
            System.out.print("(");
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getTypeName() + " args_" + i);
                if (i != parameterTypes.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(")\t");

            // 6.抛出的异常
            Type[] exceptionTypes = m.getGenericExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.print(exceptionTypes[i].getTypeName());
                    if (i != exceptionTypes.length - 1) {
                        System.out.print(",");
                    }
                }
            }

            System.out.println();
        }

        // 调用方法
        System.out.println("***************调用方法***************");
        Object object = clazz.getDeclaredConstructor().newInstance();
        Method showMethod = clazz.getDeclaredMethod("show", String.class);
        showMethod.invoke(object, "中国");
    }
}
