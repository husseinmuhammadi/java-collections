package com.javastudio.tutorial.collections.algorithm;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] array, int start, int end) {
        final int pivot = array[end];
        int p = start;

        System.out.printf("(%d, %d) %s %d%n", start, end, Arrays.toString(array), p);

        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, p, i);
                p++;
            }
            System.out.printf("(%d, %d) %s %d%n", start, end, Arrays.toString(array), p);
        }

        if (pivot <= array[p])
            swap(array, p, end);

        System.out.printf("(%d, %d) %s %d%n", start, end, Arrays.toString(array), p);

        return p;
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j)
            return;
        int value = array[i];
        array[i] = array[j];
        array[j] = value;
    }

    static void perform(int[] array, int start, int end) {
        // pivot index
        int index = partition(array, start, end);

        if (start < index - 1)
            perform(array, start, index - 1);
        if (end > index + 1)
            perform(array, index + 1, end);
    }
}
