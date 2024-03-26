package org.example.bookshop.service;

import org.springframework.stereotype.Service;

@Service
public class SeedServiceImpl implements SeedService {

    private final CategoryService categoryService;

    public SeedServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void seedAuthors() {

    }

    @Override
    public void seedBooks() {

    }

    @Override
    public void seedCategories() {
        if (this.categoryService.isDataSeeded()) return;

    }
}
