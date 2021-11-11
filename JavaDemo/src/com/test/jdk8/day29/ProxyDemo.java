package com.test.jdk8.day29;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
    public void rent();

    public void hello(String str);
}

class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}

class DynamicProxy implements InvocationHandler {
    // 这个就是我们要代理的真实对象
    private Object subject;

    // 构造方法，给我们要代理的真实对象赋初值
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args)
            throws Throwable {
        // 在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent house");
        System.out.println("Method:" + method);
        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);
        // 在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after rent house");
        return null;
    }
}

class ProxyInstance implements InvocationHandler {
    private Subject subject;

    public ProxyInstance(Subject subject) {
        this.subject = subject;
    }

    public Subject getProxy() {
        return (Subject) Proxy.newProxyInstance(this.getClass().getClassLoader(), subject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent house");
        System.out.println("Method:" + method);
        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);
        // 在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after rent house");
        return null;
    }
}

/**
 * 动态代理
 * 每一个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个handler，
 * 当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。
 * InvocationHandler这个接口的唯一一个方法 invoke 方法
 * Object invoke(Object proxy, Method method, Object[] args) throws Throwable
 * proxy:　　指代我们所代理的那个真实对象
 * method:　　指代的是我们所要调用真实对象的某个方法的Method对象
 * args:　　指代的是调用真实对象某个方法时接受的参数
 * <p>
 * Proxy这个类的作用就是用来动态创建一个代理对象的类，它提供了许多的方法，但是我们用的最多的就是 newProxyInstance 这个方法：
 * 这个方法的作用就是得到一个动态的代理对象
 * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException
 * loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
 * interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
 * h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
 */
public class ProxyDemo {
    public static void main(String[] args) {
        // 我们要代理的真实对象
        Subject realSubject = new RealSubject();

        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);

        /*
            before rent house
            Method:public abstract void com.test.jdk8.day29.Subject.rent()
            I want to rent my house
            after rent house
         */
        subject.rent();

        /*
            before rent house
            Method:public abstract void com.test.jdk8.day29.Subject.hello(java.lang.String)
            hello: 你好
            after rent house
         */
        subject.hello("你好");

        System.out.println("=========================================");
        // 另一种使用方式，通过ProxyInstance
        ProxyInstance instance = new ProxyInstance(realSubject);
        Subject proxy = instance.getProxy();
        proxy.rent();
    }
}
