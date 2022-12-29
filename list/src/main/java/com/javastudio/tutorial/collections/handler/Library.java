package com.javastudio.tutorial.collections.handler;

import com.javastudio.tutorial.collections.model.Book;

import java.util.List;

public interface Library {
    int getSize();

    void add(Book book, Position position);
}
