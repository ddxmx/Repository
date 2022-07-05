package com.test.oop.day08.spel.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
    public static final String TYPE = "Car";

    @Value("宝马")
    public String brand;

    @Value("300000")
    public double price;

    public Car(){}

    public Car(String brand,double price){
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
