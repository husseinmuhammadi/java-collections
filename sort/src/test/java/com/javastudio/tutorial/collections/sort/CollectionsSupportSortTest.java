package com.javastudio.tutorial.collections.sort;

import com.javastudio.tutorial.collections.model.Book;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionsSupportSortTest {

    @Test
    void arraySupportSort() {
        int[] numbers = new int[]{
                4, 5, 6, 7, 3, 76, 4, 6, 7, 8, 12
        };
        Arrays.sort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    /**
     * Arrays.sort uses dual-pivot Quicksort on primitives.
     * It offers O(n log(n)) performance and is typically faster than traditional (one-pivot) Quicksort implementations.
     */
    @Test
    void sortArrayOfPrimitive() {

    }

    /**
     * Arrays.sort uses a stable, adaptive, iterative implementation of mergesort algorithm for Array of Objects.
     */
    void sortArrayOfObjects() {

    }

    @Test
    void sortingAList() {
        List<Integer> numbers = Arrays.asList(3, 4, 6, 3, 3, 6, 4, 3, 67, 3, 4, 12, 56, 78, 5, 4, 9, 10);
        Collections.sort(numbers, Integer::compareTo);
        numbers.forEach(System.out::println);
    }

    @Test
    void c1(){
        TreeSet<Book> books = new TreeSet<>(Comparator.comparing(Book::getName));
        books.add(Book.builder().name("AAA").build());
        books.add(Book.builder().name("BBB").build());
        books.add(Book.builder().name("CCC").build());

        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }

}
