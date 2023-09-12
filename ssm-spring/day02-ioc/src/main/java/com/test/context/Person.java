package com.test.context;

import org.springframework.stereotype.Component;

@Component
public class Person {
    public Person() {
        System.out.println("Person Constructor");
    }

    public void print() {
        System.out.println("Person.print");
    }
}
