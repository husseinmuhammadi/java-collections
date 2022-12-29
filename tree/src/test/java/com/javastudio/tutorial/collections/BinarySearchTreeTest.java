package com.javastudio.tutorial.collections;

import org.junit.jupiter.api.Test;
import org.junit.rules.Stopwatch;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class BinarySearchTreeTest {

    @Test
    void findTheLargestItemLessThanGivenNumber() {
        TreeMap<Integer, Integer> numbers = new java.util.TreeMap<>();

        IntStream.range(0, 9).map(i -> i * 31).forEach(i -> numbers.put(i, i));

        for (Integer i : numbers.keySet()) {
            System.out.println(i);
        }

        Integer x = numbers.floorKey(31);
        System.out.println(x);
    }



}
