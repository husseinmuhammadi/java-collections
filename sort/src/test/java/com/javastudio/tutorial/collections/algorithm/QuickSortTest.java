package com.javastudio.tutorial.collections.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void quickSort() {
        int[] data = {8, 7, 2, 1, 0, 9, 6, 3, -1, 12, 7, 6, 7, 7, 7, 7};
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        QuickSort.perform(data, 0, data.length - 1);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}