package org.example.bookshop.service;

import org.example.bookshop.domain.entities.Author;

import java.util.List;

public interface AuthorService {

    boolean isDataSeeded();

    void seedCategories(List<Author> authors);

}

