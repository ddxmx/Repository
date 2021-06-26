package com.test.namespace;

import java.util.List;

public class Person {
    private String name;
    private List<String> parents;

    public Person() {

    }

    public Person(String name, List<String> parents) {
        this.name = name;
        this.parents = parents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }
}
