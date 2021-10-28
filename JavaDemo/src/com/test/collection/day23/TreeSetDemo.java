package com.test.collection.day23;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet判断元素是否相等，是按照compareTo方法进行判断
 * TreeSet底层是TreeMap，采用红黑树结构
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        {
            TreeSet<Integer> set = new TreeSet();
            set.add(15);
            set.add(32);
            set.add(-28);
            set.add(45);
            set.add(9);
            print(set);
        }

        {
            System.out.println("***********************");
            TreeSet<Person> set = new TreeSet();
            /*
                Exception in thread "main" java.lang.ClassCastException: com.test.collection.day23.Person cannot be cast to java.lang.Comparable
                TreeSet元素必须要实现java.utils.comparable接口
             */
            set.add(new Person("Jack", 22));
            set.add(new Person("Helen", 20));
            set.add(new Person("Tom", 24));
            set.add(new Person("Jerry", 21));
            set.add(new Person("Bob", 22));
            /*
                Person{name='Tom', age=24}
                Person{name='Bob', age=22}
                Person{name='Jack', age=22}
                Person{name='Jerry', age=21}
                Person{name='Helen', age=20}
             */
            print(set);
        }

        {
            System.out.println("***********************");
            Comparator comparator = new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if (o1.getClass() != Person.class || o2.getClass() != Person.class) {
                        throw new IllegalArgumentException("参数类型错误");
                    }

                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    if (p1.getAge() < p2.getAge()) {
                        return -1;
                    } else if (p1.getAge() > p2.getAge()) {
                        return 1;
                    } else {
                        return p1.getName().compareTo(p2.getName());
                    }
                }
            };

            TreeSet set = new TreeSet(comparator);
            set.add(new Person("Jack", 22));
            set.add(new Person("Helen", 20));
            set.add(new Person("Tom", 24));
            set.add(new Person("Jerry", 21));
            set.add(new Person("Bob", 22));
            /*
                Person{name='Helen', age=20}
                Person{name='Jerry', age=21}
                Person{name='Bob', age=22}
                Person{name='Jack', age=22}
                Person{name='Tom', age=24}
             */
            print(set);
        }
    }

    public static void print(Set set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}