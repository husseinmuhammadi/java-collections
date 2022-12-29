package com.javastudio.adyen;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    AtomicLong accountNumberGenerator=new AtomicLong(1);
    @Test
    void s(){
        System.out.println(accountNumberGenerator.incrementAndGet());
    }
}