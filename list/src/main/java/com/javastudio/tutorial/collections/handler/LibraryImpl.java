package com.javastudio.tutorial.collections.handler;

import com.javastudio.tutorial.collections.model.Book;

import java.util.List;

public class LibraryImpl implements Library {

    final List<Book> books;

    public LibraryImpl(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getSize() {
        return books.size();
    }

    @Override
    public void add(Book book, Position position) {
        if (position == Position.HEAD)
            books.add(0, book);
        else if (position == Position.TAIL)
            books.add(book);
    }
}
