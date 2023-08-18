package com.test.oop.day07.relation;

class Book {
    private String title;
    private double price;
    // Book类中包含Person类属性，是关联关系
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

public class ClassAssociationDemo {
    public static void main(String[] args) {
        Book book1 = new Book("java编程思想", 89.9);
        Book book2 = new Book("一千零一夜", 19.9);
        Book book3 = new Book("格林童话", 24.9);

        Person person = new Person("张三", 32);
        Person child1 = new Person("张小花", 5);
        Person child2 = new Person("张小虎", 8);

        // 绑定Person和Book的关系，给Book设置owner属性
        book1.setOwner(person);
        book2.setOwner(child1);
        book3.setOwner(child2);

        // 绑定Person和Book的关系，给Person设置book属性
        person.setBook(book1);
        child1.setBook(book2);
        child2.setBook(book3);

        // 绑定person和father属性的关系
        child1.setFather(person);
        child2.setFather(person);

        // 绑定person和children属性的关系
        person.setChildren(new Person[]{child1, child2});

        // father的书找到child的书
        /*
            张小花：Book{title='一千零一夜', price=19.9}
            张小虎：Book{title='格林童话', price=24.9}
         */
        for (Person child : book1.getOwner().getChildren()) {
            System.out.println(child.getName() + "：" + child.getBook());
        }

        // child的书找到father的书
        // Book{title='java编程思想', price=89.9}
        System.out.println(book3.getOwner().getFather().getBook());
    }
}
