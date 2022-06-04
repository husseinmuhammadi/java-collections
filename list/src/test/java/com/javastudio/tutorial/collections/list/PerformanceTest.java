package com.javastudio.tutorial.collections.list;

import com.javastudio.tutorial.collections.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PerformanceTest {
    private static final int INITIAL_CAPACITY = 1_000_000;

    @Test
    void givenArrayList_whenInitiateTheSize_thenBetterPerformance() {
        long elapsedTimeInitiateWithDefault  = createCollectionOfBooksUsingArrayList(10);
        long elapsedTimeInitiateWithOneBillion  = createCollectionOfBooksUsingArrayList(INITIAL_CAPACITY);
        System.out.println(elapsedTimeInitiateWithDefault);
        System.out.println(elapsedTimeInitiateWithOneBillion);
        Assertions.assertThat(elapsedTimeInitiateWithDefault).isGreaterThan(elapsedTimeInitiateWithOneBillion);
    }

    private long createCollectionOfBooksUsingArrayList(int initialCapacity) {
        long start = System.currentTimeMillis();

        List<Book> books = new ArrayList<>(initialCapacity);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            books.add(Book.builder().build());
        }

        long stop = System.currentTimeMillis();

        // elapsed time
        return stop - start;
    }

}
