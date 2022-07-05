package com.test.oop.day11.transaction.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    private int id;
    private String name;
    private int age;
}
