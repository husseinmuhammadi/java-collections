package com.javastudio.tutorial.collections.algorithm.programiz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class QuickSortTest {
    @Test
    void quickSort() {
        int[] data = {8, 7, 2, 1, 0, 9, 6};
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        int size = data.length;

        // call quicksort() on array data
        QuickSort.quickSort(data, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }

}