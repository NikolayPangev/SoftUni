package org.example.bookshop.service;

import org.example.bookshop.domain.entities.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    @Override
    public boolean isDataSeeded() {
        return false;
    }

    @Override
    public void seedCategories(List<Category> categories) {

    }
}
