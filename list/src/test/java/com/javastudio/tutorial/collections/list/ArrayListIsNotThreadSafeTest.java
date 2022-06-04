package com.javastudio.tutorial.collections.list;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ArrayListIsNotThreadSafeTest {

    // replace it with Vector and see the result
    List<Object> objects = new ArrayList<>();

    @Test
    void givenArrayList_whenTwoThreadTryToAddItems_thenSomeItemsMissed() throws InterruptedException {
        Thread t1 = new Thread(this::addItems);
        Thread t2 = new Thread(this::addItems);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Assertions.assertThat(objects.size()).isEqualTo(2_000_000);
    }

    private void addItems() {
        for (int i = 0; i < 1_000_000; i++) {
            objects.add(new Object());
        }
    }
}
