package com.test.oop.day07;

class Book {
    private String title;
    private double price;
    // Book类中包含Person类属性，是包含关系
    private Person owner;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

class Person {
    private String name;
    private int age;
    // 包含Book类对象
    private Book book;
    // 包含当前类对象
    private Person father;
    // 包含当前类对象数组
    private Person[] children;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person[] getChildren() {
        return children;
    }

    public void setChildren(Person[] children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * 类之间的关系：
 * |- 继承：is A，Apple继承Fruit：apple is a fruit
 * |- 包含：has A，Library包含Book：library has a book
 */
public class ClassIncludesDemo {
    public static void main(String[] args) {
        Book book1 = new Book("java编程思想", 89.9);
        Book book2 = new Book("一千零一夜", 19.9);
        Book book3 = new Book("格林童话", 24.9);

        Person person = new Person("张三", 30);
        Person child1 = new Person("张小花", 6);
        Person child2 = new Person("张小虎", 8);

        // 绑定Person和Book的关系，给Book设置owner属性
        book1.setOwner(person);
        book2.setOwner(child1);
        book3.setOwner(child2);

        // 绑定Person和Book的关系，给Person设置book属性
        person.setBook(book1);
        child1.setBook(book2);
        child2.setBook(book3);

        // 绑定person和children属性的关系
        person.setChildren(new Person[]{child1, child2});
        child1.setFather(person);
        child2.setFather(person);

        /*
            father的书 -> child的书
            Book{title='一千零一夜', price=19.9}
            Book{title='格林童话', price=24.9}
         */
        Person[] children = book1.getOwner().getChildren();
        for (Person child : children) {
            System.out.println(child.getBook());
        }

        /*
            child1的书 -> child2的书
            Book{title='格林童话', price=24.9}
         */
        Person[] allChildren = book2.getOwner().getFather().getChildren();
        for (Person child : allChildren) {
            Book temp = child.getBook();
            if (temp != book2) {
                System.out.println(temp);
            }
        }
    }
}
