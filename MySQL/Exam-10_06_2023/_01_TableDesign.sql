CREATE DATABASE universities_db;
USE universities_db;

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    population INT,
    country_id INT NOT NULL,
    
    FOREIGN KEY (country_id) REFERENCES countries(id)
);

CREATE TABLE universities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL UNIQUE,
    address VARCHAR(80) NOT NULL UNIQUE,
    tuition_fee DECIMAL(19, 2) NOT NULL,
    number_of_staff INT,
	city_id INT,
    
    FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE courses(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    duration_hours DECIMAL(19, 2),
    start_date DATE,
    teacher_name VARCHAR(60) NOT NULL UNIQUE,
    description TEXT,
    university_id INT,
    
    FOREIGN KEY (university_id) REFERENCES universities(id)
);

CREATE TABLE students(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    age INT,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    is_graduated BOOLEAN NOT NULL,
    city_id INT,
    
    FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE students_courses(
	grade DECIMAL(19, 2) NOT NULL,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);