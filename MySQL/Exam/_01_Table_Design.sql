DROP DATABASE IF EXISTS preserves;
CREATE DATABASE preserves;
USE preserves;

CREATE TABLE continents(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    country_code VARCHAR(10) NOT NULL UNIQUE,
    continent_id INT NOT NULL,
    
    FOREIGN KEY (continent_id)REFERENCES continents(id)
);

CREATE TABLE preserves(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    latitude DECIMAL(9, 6),
    longitude DECIMAL(9, 6),
    area INT,
    type VARCHAR(20),
    established_on DATE
);

CREATE TABLE countries_preserves(
	country_id INT,
	preserve_id INT,
    
    FOREIGN KEY(country_id) REFERENCES countries(id),
    FOREIGN KEY(preserve_id) REFERENCES preserves(id)
);

CREATE TABLE positions(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    description TEXT,
    is_dangerous BOOLEAN NOT NULL
);

CREATE TABLE workers(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    age INT,
    personal_number VARCHAR(20) NOT NULL UNIQUE,
    salary DECIMAL(19, 2),
	is_armed BOOLEAN NOT NULL,
    start_date DATE,
    preserve_id INT,
    position_id INT,
    
    FOREIGN KEY(preserve_id) REFERENCES preserves(id),
    FOREIGN KEY(position_id) REFERENCES positions(id)
);