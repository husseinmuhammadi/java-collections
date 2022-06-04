package com.javastudio.tutorial.collections.model;

import java.time.LocalDate;

public class Book {

    private final Long id;
    private final String name;
    private final LocalDate publishDate;

    private Book(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.publishDate = builder.publishDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private LocalDate publishDate;

        private Builder() {

        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder publishDate(LocalDate publishDate) {
            this.publishDate = publishDate;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
}
