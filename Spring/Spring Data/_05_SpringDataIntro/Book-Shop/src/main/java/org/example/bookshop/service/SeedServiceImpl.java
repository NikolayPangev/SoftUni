package org.example.bookshop.service;

import org.example.bookshop.domain.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.example.bookshop.constants.FilePath.CATEGORY_FILE_NAME;
import static org.example.bookshop.constants.FilePath.RESOURCE_URL;

@Service
public class SeedServiceImpl implements SeedService {

    private final CategoryService categoryService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public SeedServiceImpl(CategoryService categoryService, BookService bookService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void seedAuthors() throws IOException {

    }

    @Override
    public void seedBooks() throws IOException {

    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryService.isDataSeeded()) return;

        this.categoryService.seedCategories(
                Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME))
                        .stream()
                        .filter(s -> !s.isBlank())
                        .map(Category::new)
                        .toList());
    }
}
