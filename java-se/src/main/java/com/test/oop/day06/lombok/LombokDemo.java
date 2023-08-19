package com.test.oop.day06.lombok;

import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data // 等价于 @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
// @Builder(builderMethodName = "personBuilder")
@SuperBuilder(builderMethodName = "personBuilder")
class Person {
    private String name;
    private int age;
}

/**
 * @Builder和@SuperBuilder使用约束 （1）父类使用@SuperBuilder，子类可以使用@Builder或@SuperBuilder，用于选择是否获取继承的属性
 * （2）父类使用@Builder，子类只能使用@Builder，不能使用@SuperBuilder，无法获取继承的属性
 * （3）父类和子类同时使用@Builder或@SuperBuilder中的任一个注解，需要指定builderMethodName用于区分builder()方法
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE) // 构造器注解可以指定访问权限
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true) // 用于将父类对象属性也返回
@EqualsAndHashCode(callSuper = true) // 用于子类对象之间进行比较的时候，equals和hashcode将父类对象属性算进去
// @Builder(builderMethodName = "studentBuilder")
@SuperBuilder(builderMethodName = "studentBuilder")
class Student extends Person {
    private double score;
}

public class LombokDemo {
    public static void main(String[] args) {
        {
            System.out.println("=========================Person类=========================");
            // Person类
            // 1、@NoArgsConstructor
            Person per = new Person();

            // 2、@AllArgsConstructor
            Person per2 = new Person("张三", 10);

            // 3、@Data
            Person per3 = new Person("张三", 12);
            per3.setAge(10);
            System.out.println(per3.getAge()); // 10
            System.out.println(per3); // Person(name=张三, age=10)
            System.out.println(per2.equals(per3)); // true
            System.out.println(per2.hashCode()); // 778960

            // 4、@Builder
            /*
                类名称.builder()方法用于生成"类名称Builder"的内部类对象
                在继承关系中，父类和子类如果都添加了@Builder的注解，那父子类中都有builder()的方法
                但方法返回值类型不同，Person.PersonBuilder对象和Student.StudentBuilder对象导致无法构成方法覆写
                因此需要指定builder的名称用于区分
             */
            Person per4 = Person.personBuilder().name("李四").age(16).build();
            System.out.println(per4); // Person(name=李四, age=16)
        }

        {
            System.out.println("=========================Student类=========================");
            // Student类
            // 1、@NoArgsConstructor设置构造方法private访问权限
            // 编译失败，'Student()' has private access
            // Student stu = new Student();

            // 2、@AllArgsConstructor生成构造器不包含父类的属性，Student的全参数构造器中只有一个参数score
            // 编译失败，Expected 1 arguments but found 3
            // Student stu2 = new Student("张三", 12, 60);

            // 3、@Builder和@SuperBuilder
            // @Builder无法指定继承父类的属性，@SuperBuilder可以指定继承父类的属性
            Student stu3 = Student.studentBuilder().name("张三").age(12).score(98).build();
            // callSuper = true的属性，包含继承父类属性
            System.out.println(stu3); // Student(super=Person(name=张三, age=12), score=98.0)
        }
    }
}
