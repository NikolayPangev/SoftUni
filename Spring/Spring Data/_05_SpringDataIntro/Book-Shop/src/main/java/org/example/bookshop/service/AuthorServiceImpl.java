package org.example.bookshop.service;

import org.example.bookshop.domain.entities.Author;

import java.util.List;

public class AuthorServiceImpl implements AuthorService{
    @Override
    public boolean isDataSeeded() {
        return false;
    }

    @Override
    public void seedCategories(List<Author> authors) {

    }
}
