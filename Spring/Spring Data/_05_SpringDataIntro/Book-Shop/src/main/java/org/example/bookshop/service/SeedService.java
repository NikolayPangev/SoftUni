package org.example.bookshop.service;

public interface SeedService {

    void seedAuthors();

    void seedBooks();

    void seedCategories();

    default void seedAllData() {
        seedAuthors();
        seedBooks();
        seedAuthors();
    }
}

