CREATE DATABASE Movies;

CREATE TABLE directors (
    id INT PRIMARY KEY,
    director_name VARCHAR(255) NOT NULL,
    notes TEXT
);

CREATE TABLE genres (
    id INT PRIMARY KEY,
    genre_name VARCHAR(255) NOT NULL,
    notes TEXT
);

CREATE TABLE categories (
    id INT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL,
    notes TEXT
);

CREATE TABLE movies (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director_id INT,
    copyright_year INT,
    length INT,
    genre_id INT,
    category_id INT,
    rating DECIMAL(3, 1),
    notes TEXT,
    FOREIGN KEY (director_id) REFERENCES directors(id),
    FOREIGN KEY (genre_id) REFERENCES genres(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO directors (id, director_name, notes) VALUES
(1, 'Steven Spielberg', 'Acclaimed director'),
(2, 'Christopher Nolan', 'Renowned for mind-bending films'),
(3, 'Quentin Tarantino', 'Master of dialogue and violence'),
(4, 'Greta Gerwig', 'Notable female director'),
(5, 'Martin Scorsese', 'Iconic filmmaker');

INSERT INTO genres (id, genre_name, notes) VALUES
(1, 'Drama', 'Emotional and character-driven'),
(2, 'Action', 'High-energy and intense'),
(3, 'Comedy', 'Humorous and entertaining'),
(4, 'Science Fiction', 'Futuristic and imaginative'),
(5, 'Romance', 'Love and relationships');

INSERT INTO categories (id, category_name, notes) VALUES
(1, 'Classic', 'Timeless and enduring'),
(2, 'Thriller', 'Suspenseful and gripping'),
(3, 'Adventure', 'Exciting and daring'),
(4, 'Independent', 'Artistic and non-mainstream'),
(5, 'Family', 'Suitable for all ages');

INSERT INTO movies (id, title, director_id, copyright_year, length, genre_id, category_id, rating, notes) VALUES
(1, 'Schindler''s List', 1, 1993, 195, 1, 1, 8.9, 'Powerful Holocaust drama'),
(2, 'Inception', 2, 2010, 148, 4, 2, 8.8, 'Mind-bending heist thriller'),
(3, 'Pulp Fiction', 3, 1994, 154, 1, 2, 8.9, 'Quirky and nonlinear storytelling'),
(4, 'Little Women', 4, 2019, 135, 5, 4, 7.8, 'Adaptation of the classic novel'),
(5, 'Goodfellas', 5, 1990, 146, 1, 3, 8.7, 'Gritty Mafia crime film');