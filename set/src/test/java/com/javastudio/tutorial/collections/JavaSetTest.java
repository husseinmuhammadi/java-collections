package com.javastudio.tutorial.collections;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class JavaSetTest {

    @Test
    void setIsUnordered() {
        Set<Integer> set = new TreeSet();
        set.add(2);
        set.add(1);
        set.add(3);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }
    }
}
