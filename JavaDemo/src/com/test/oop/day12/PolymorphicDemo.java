package com.test.oop.day12;

class Animal {
    int age = 10;

    public void shout() {
        System.out.println("动物喊叫~");
    }

    public void showAge() {
        System.out.println(this.age);
    }
}

class Dog extends Animal {
    int age = 20;

    @Override
    public void shout() {
        System.out.println("汪~汪~汪");
    }

    public void showAge() {
        System.out.println(this.age);
    }
}

class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("喵~喵~喵");
    }
}

/**
 * 多态：父类引用指向子类实例
 * 引用可以调用的方法，取决于编译的类型，即声明的类型
 * 实际调用的方法，依赖于实例化的对象类型，即运行时的对象类型
 * 总结：编译看左边，运行看右边
 * <p>
 * 子类继承父类，父类的引用指向子类的实例，调用父类方法时，实际调用的是被子类覆写的方法----虚拟方法调用
 * 重载是编译时多态，覆写时运行时多态。重载也称为静态绑定，覆写称为动态绑定
 */
public class PolymorphicDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.shout(); //动物喊叫~

        Dog dog = new Dog();
        dog.shout(); //汪~汪~汪

        System.out.println("***********************************");
        Animal animal2 = new Dog();
        animal2.shout(); //汪~汪~汪
        System.out.println(animal2.age); //10，同名属性取决于声明类型
        animal2.showAge(); //20

        System.out.println("***********************************");
        show(new Dog()); //汪~汪~汪
        show(new Cat()); //喵~喵~喵
    }

    /**
     * 对象的多态可以统一参数，不再需要针对父类的每一个子类进行重载
     *
     * @param animal
     */
    public static void show(Animal animal) {
        animal.shout();
    }
}
