package com.test.oop.day11;

class Book {
    private String title;
    private double price;
    private Human human;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

class Human {
    private String name;
    private int age;
    private Book book;
    private Human father;
    private Human[] children;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * 类中的成员可以是引用数据类型，甚至可以是当前类的类型
 */
public class ReferenceFileDemo {
    public static void main(String[] args) {
        Book book1 = new Book("java编程思想", 89.9);
        Book book2 = new Book("一千零一夜", 19.9);
        Book book3 = new Book("格林童话", 24.9);

        Human human = new Human("张三", 30);
        Human child1 = new Human("张小花", 6);
        Human child2 = new Human("张小虎", 8);

        // 绑定Human和Book的关系
        book1.setHuman(human);
        book2.setHuman(child1);
        book3.setHuman(child2);

        human.setBook(book1);
        child1.setBook(book2);
        child2.setBook(book3);

        // 绑定Human和children属性的关系
        human.setChildren(new Human[]{child1, child2});
        child1.setFather(human);
        child2.setFather(human);

        /*
            father的书 -> child的书
            Book{title='一千零一夜', price=19.9}
            Book{title='格林童话', price=24.9}
         */
        Human[] children = book1.getHuman().getChildren();
        for (Human child : children) {
            System.out.println(child.getBook());
        }

        /*
            child1的书 -> child2的书
            Book{title='格林童话', price=24.9}
         */
        Human[] children2 = book2.getHuman().getFather().getChildren();
        for (Human child : children2) {
            Book book = child.getBook();
            if (book != book2) {
                System.out.println(book);
            }
        }
    }
}
