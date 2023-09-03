package com.test.reflex.day20.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 定义租房接口
 */
interface Subject {
    public void rent();

    public void hello(String str);
}

/**
 * 创建租房实现类
 */
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
    private Subject subject;

    // 构造方法，传入真实类对象
    public DynamicProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        // 设置只代理rent方法
        if ("rent".equals(method.getName())) {
            // 在代理真实对象前我们可以添加一些自定义操作
            System.out.println("before rent house");
            // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
            method.invoke(subject, args);
            // 在代理真实对象后我们也可以添加一些自定义操作
            System.out.println("after rent house");
        } else {
            method.invoke(subject, args);
        }

        return null;
    }

    /**
     * 动态代理类中可以提供方法直接返回代理对象
     */
    public Subject getProxy() {
        return (Subject) Proxy.newProxyInstance(this.getClass().getClassLoader(), subject.getClass().getInterfaces(), this);
    }
}

/**
 * 动态代理
 * 1、每一个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个handler
 * 2、当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的invoke方法来进行调用
 * InvocationHandler这个接口的唯一一个方法invoke方法
 * Object invoke(Object proxy, Method method, Object[] args) throws Throwable
 * proxy:　　指代我们所代理的那个真实对象
 * method:　　指代的是我们所要调用真实对象的某个方法的Method对象
 * args:　　指代的是调用真实对象某个方法时接受的参数
 * 3、Proxy这个类的作用就是用来动态创建一个代理对象的类，它提供了newProxyInstance这个方法用于得到一个动态的代理对象
 * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException
 * loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
 * interfaces:一个Interface对象的数组，代理的对象需要实现的接口
 * h:一个InvocationHandler对象，代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        // 我们要代理的真实对象
        Subject realSubject = new RealSubject();

        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        DynamicProxy dynamicProxy = new DynamicProxy(realSubject);

        // 生成代理对象
        Subject proxySubject = (Subject) Proxy.newProxyInstance(dynamicProxy.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), dynamicProxy);
        // 通过代理类提供的获取代理实例的方法，也能获取到代理类对象
        Subject proxySubject2 = dynamicProxy.getProxy();

        /*
            before rent house
            I want to rent my house
            after rent house
         */
        proxySubject.rent();

        // 代理操作只调用了真实的方法，没有额外操作
        // hello: 你好
        proxySubject.hello("你好");
    }
}