package com.test.reflex.day20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 */
public class MethodDemo {

    public static void main(String[] args) {
        Class clazz = Person.class;

        // getMethods():获取当前类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("*******************************");
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
            System.out.print(m.getReturnType().getName() + "\t");

            // 4.方法名
            System.out.print(m.getName());

            // 5.形参列表
            System.out.print("(");
            Class[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getName() + " args_" + i);
                if (i != parameterTypes.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print(")\t");

            // 6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.print(exceptionTypes[i].getName());
                    if (i != exceptionTypes.length - 1) {
                        System.out.print(",");
                    }
                }
            }

            System.out.println();
        }

    }
}
