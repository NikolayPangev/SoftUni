package org.example.bookshop.service;

import org.example.bookshop.domain.entities.Category;

import java.util.List;

public interface CategoryService {

    boolean isDataSeeded();

    void seedCategories(List<Category> categories);

}

