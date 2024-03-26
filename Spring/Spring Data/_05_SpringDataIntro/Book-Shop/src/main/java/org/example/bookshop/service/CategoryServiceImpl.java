package org.example.bookshop.service;

import org.example.bookshop.domain.entities.Category;
import org.example.bookshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.categoryRepository.count() > 0;
    }

    @Override
    public void seedCategories(List<Category> categories) {
        this.categoryRepository.saveAllAndFlush(categories);
    }

    @Override
    public Category getRandomCategory() {
        return null;
    }

    @Override
    public Set<Category> getRandomCategories() {
        return null;
    }
}
