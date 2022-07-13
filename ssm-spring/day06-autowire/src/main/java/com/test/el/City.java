package com.test.el;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class City {
    public static final String SUZHOU = "苏州";

    public static final String KUNSHAN = "昆山";

    public static int number = 100;

    public static String STR = "d22";

    public static List<String> cities = new ArrayList<>();

    public static Map<String, Integer> msg = new HashMap<>();

    public static List<Car> cars = new ArrayList<>();

    public City() {
        cities = Arrays.asList("SuZhou", "WuXi", "ChangZhou", "NanTong", "NanJing", "ZhenJiang");
        cars = Arrays.asList(new Car("五菱宏光", 50000), new Car("桑塔纳", 90000),
                new Car("宝骏", 110000), new Car("荣威", 95000));
        msg.put("hello", 1);
        msg.put("world", 2);
        msg.put("java", 3);
        msg.put("python", 4);
        msg.put("NanJing", 5);
    }

    public String getName(String cityName) {
        if (null == cityName || "".equals(cityName)) {
            return null;
        }
        return "JiangSu-" + cityName;
    }

    public String getCountry() {
        return "China";
    }
}
