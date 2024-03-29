package com.test.oop.day08.polymorphic;

class Animal {
    int age = 1;

    public void shout() {
        System.out.println("Animal.shout");
    }

    public void printAge() {
        System.out.println("Animal age:" + age);
    }
}

class Dog extends Animal {
    int age = 5;

    @Override
    public void shout() {
        System.out.println("Dog.shout");
    }
}

class Cat extends Animal {
    int age = 3;

    @Override
    public void shout() {
        System.out.println("Cat.shout");
    }

    @Override
    public void printAge() {
        System.out.println("Cat age:" + age);
    }
}

/**
 * 多态：父类引用指向子类实例
 * 父类引用的类型：编译类型（静态类型）；子类实例的类型：运行类型（动态类型）
 * 1、引用对象可以调用的方法，取决于编译的类型，即声明的类型
 * 引用对象运行中实际调用的方法，依赖于实例化的对象类型，即运行时的对象类型
 * 总结：编译看左边，运行看右边
 * 2、子类继承父类，父类的引用指向子类的实例，调用父类方法时，实际调用的是被子类覆写的方法
 * 3、重载是编译时多态，覆写时运行时多态。重载也称为静态绑定，覆写称为动态绑定
 * 4、变量不存在覆写的概念，private方法、static方法、final方法也不能被覆写
 */
public class UpcastingDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.shout(); // Animal.shout

        Dog dog = new Dog();
        dog.shout(); // Dog.shout

        // 向上转型
        Animal animal2 = dog;
        animal2.shout(); // Dog.shout
        // 父子类中同名属性取决于声明类型
        System.out.println(animal2.age); // 1
        // 就近原则，子类未覆写父类方法，父类方法执行时直接找到父类中的age属性
        animal2.printAge(); // Animal age：1

        Animal animal3 = new Cat();
        // 调用被子类覆写的方法，就近原则，直接找到子类中的age属性
        animal3.printAge(); // Cat age：3

        // 向上转型统一了方法的参数
        doShout(new Dog()); // Dog.shout
        doShout(new Cat()); // Cat.shout
    }

    /**
     * 对象的多态性可以统一方法的参数，不再需要针对父类的每一个子类进行重载，直接使用父类引用接收子类对象
     */
    public static void doShout(Animal animal) {
        animal.shout();
    }
}
