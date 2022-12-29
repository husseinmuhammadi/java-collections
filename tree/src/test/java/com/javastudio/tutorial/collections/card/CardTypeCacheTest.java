package com.javastudio.tutorial.collections.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CardTypeCacheTest {

    @Test
    void mockData() throws IOException {
        try (Writer out = new BufferedWriter(new FileWriter(new File("bin-range.txt")))) {

            IntStream.range(1, 13000).map(i -> i * 53 + 100000)
                    .mapToObj(i -> new BinRange(String.valueOf(i), String.valueOf(i + rand(53)), String.valueOf(i / 53)))
                    .forEach(binRange -> {
                        try {
                            out.write(String.format("%s:%s:%s%n", binRange.start, binRange.end, binRange.cardType));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    private int rand(int bound) {
        return new Random().nextInt(bound);
    }

    CardTypeCache cardTypeCache;

    @BeforeEach
    void setUp() throws IOException {
        List<BinRange> binRanges = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("bin-range.txt")))) {
            while (reader.ready()) {
                Optional.of(reader.readLine().split(":")).map(i -> new BinRange(i[0], i[1], i[2])).ifPresent(binRanges::add);
            }
        }

        cardTypeCache = CardTypeCache.buildCache(binRanges);
    }

    @Test
    void performanceTest() throws IOException {
        long start = System.nanoTime();
        for (int i = 0; i < 50; i++) {
            IntStream.range(100000, 999999).mapToObj(String::valueOf).forEach(cardTypeCache::getCardType);
        }
        long end = System.nanoTime();
        System.out.printf("%f%n", (end - start) / 1E9);

    }

    @Test
    void cardTypeCacheShouldWork() {
        System.out.println(cardTypeCache.getCardType("677255"));
        System.out.println(cardTypeCache.getCardType("677266"));
    }

}