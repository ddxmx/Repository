package com.test.collection.day18.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ApacheCollectionUtilsDemo {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("B", "D");

        System.out.println("====================并集====================");
        Collection<String> c1 = CollectionUtils.union(list1, list2);
        System.out.println(c1); // [A, B, C, D]

        System.out.println("====================交集====================");
        Collection<String> c2 = CollectionUtils.intersection(list1, list2);
        System.out.println(c2); // [B]

        System.out.println("====================交集的补集====================");
        // 交接的补集 = 并集 - 交集
        Collection<String> c3 = CollectionUtils.disjunction(list1, list2);
        System.out.println(c3); // [A, C, D]

        System.out.println("====================差集====================");
        // 在list1中，但不在list2中
        Collection<String> c4 = CollectionUtils.subtract(list1, list2);
        System.out.println(c4); // [A, C]

        System.out.println("====================集合判空====================");
        System.out.println(CollectionUtils.isEmpty(list1)); // false
        System.out.println(CollectionUtils.isEmpty(new ArrayList<>())); // true
        System.out.println(CollectionUtils.isNotEmpty(list1)); // true
        System.out.println(CollectionUtils.isNotEmpty(new ArrayList<>())); // false

        System.out.println("====================集合相等====================");
        System.out.println(CollectionUtils.isEqualCollection(list1, list2)); // false
        System.out.println(CollectionUtils.isEqualCollection(Arrays.asList("A", "B", "C"), list1)); // true
    }
}
