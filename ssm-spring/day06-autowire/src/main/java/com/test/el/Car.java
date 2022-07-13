package com.test.el;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    public static final String TYPE = "Car";

    public static String color;

    @Value("宝马")
    public String brand;

    @Value("300000")
    public double price;
}
