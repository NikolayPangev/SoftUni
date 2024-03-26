package org.example.bookshop.service;

import org.example.bookshop.domain.entities.Book;

import java.util.List;

public interface BookService {

    boolean isDataSeeded();

    void seedCategories(List<Book> books);

}

