package com.test.day23;

import java.util.*;

/**
 * List接口：存储有序的，可重复数据
 * java.lang.Object
 * ↳     java.util.AbstractCollection<E>
 * ↳     java.util.AbstractList<E>
 * ↳     java.util.ArrayList<E>
 * <p>
 * ArrayList：List主要实现类，数组实现，非线程安全，遍历、查找时使用
 * LinkedList：双向链表实现，插入、删除时使用
 * Vector：古老实现类，数组实现，线程安全的，已经逐步被Collections.synchronizedList(List<T> list) 方法取代
 */
public class ListDemo {
    public static void main(String[] args) {
        /*
             ArrayList内部是Object[]，初始为空数组{}
             第一次增加元素时，扩容长度为10，后续不足时，扩容为原数组的1.5倍
             开发中如果明确ArrayList中存储元素的个数，可以使用带参数的构造器：public ArrayList(int initialCapacity)
         */
        {
            ArrayList<Object> list = new ArrayList();
            list.add(123);
            list.add(456);
            list.add("AA");
            list.add(new Person("Tom", 12));
            list.add(456);

            System.out.println(list); //[123, 456, AA, Person{name='Tom', age=12}, 456]

            //list转换为数组
            //Arrays.asLis生成的list是不能执行add和remove方法，因为没有覆写该类操作方法，继承父类AbstractList的默认实现就是抛出异常
            List<Integer> srcList = Arrays.asList(11, 22, 33, 44, 55);
            Integer[] destArray = srcList.toArray(new Integer[0]);
            System.out.println(Arrays.toString(destArray)); //[11, 22, 33, 44, 55]

            //不同集合类型之间的转换，可以通过构造方法
            LinkedList<Object> linkedList = new LinkedList(list);
            System.out.println(linkedList.getFirst()); //123
            System.out.println(linkedList.getLast()); //456

            ArrayList<Object> arrayList = new ArrayList<>(linkedList);
            System.out.println(arrayList); //[123, 456, AA, Person{name='Tom', age=12}, 456]

            System.out.println("******************************");
            //和索引相关的方法，都是List区别Collection，新增的方法
            list.add(1, "BB");

            list.addAll(1, Arrays.asList(1, 2, 3));
            System.out.println(list); //[123, 1, 2, 3, BB, 456, AA, Person{name='Tom', age=12}, 456]

            System.out.println(list.indexOf(456)); //5
            System.out.println(list.indexOf(999)); //-1
            System.out.println(list.lastIndexOf(456)); //8

            list.remove(1);
            System.out.println(list); //[123, 2, 3, BB, 456, AA, Person{name='Tom', age=12}, 456]
            //直接写456，方法会匹配到 public E remove(int index)
            list.remove(Integer.valueOf(456));
            System.out.println(list); //[123, 2, 3, BB, AA, Person{name='Tom', age=12}, 456]

            list.set(3, "CC");
            System.out.println(list); //[123, 2, 3, CC, AA, Person{name='Tom', age=12}, 456]

            List<Object> subList = list.subList(0, 4);
            System.out.println(subList); //[123, 2, 3, CC]
            System.out.println(list); //[123, 2, 3, CC, AA, Person{name='Tom', age=12}, 456]

            System.out.println("******************************");
            //遍历方式一：
            Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            System.out.println("==============================");
            //遍历方式二：
            //ListIterator是专门为遍历List而存在的
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                System.out.println(listIterator.next());
            }
            System.out.println("---------------------------");
            while (listIterator.hasPrevious()) {
                System.out.println(listIterator.previous());
            }

            System.out.println("==============================");
            //遍历方式三：
            for (Object element : list) {
                System.out.println(element);
            }

            System.out.println("==============================");
            //遍历方式四：
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            System.out.println("==============================");
            //遍历方式五：古老的遍历类
            Vector<Object> vector = new Vector<>(list);

            Enumeration<Object> enu = vector.elements();
            while (enu.hasMoreElements()) {
                System.out.println(enu.nextElement());
            }
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person() {
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return -1;
        } else if (this.age < o.age) {
            return 1;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}
