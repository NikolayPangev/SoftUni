package org.example.bookshop.service;

import org.example.bookshop.domain.entities.Book;

import java.util.List;

public class BookServiceImpl implements BookService{
    @Override
    public boolean isDataSeeded() {
        return false;
    }

    @Override
    public void seedCategories(List<Book> books) {

    }
}
