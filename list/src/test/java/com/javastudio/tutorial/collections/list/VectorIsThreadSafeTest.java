package com.javastudio.tutorial.collections.list;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class VectorIsThreadSafeTest {

    List<Object> objects = new Vector<>();

    @Test
    void shouldAddTwoMillionItemsToList() throws InterruptedException {
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
