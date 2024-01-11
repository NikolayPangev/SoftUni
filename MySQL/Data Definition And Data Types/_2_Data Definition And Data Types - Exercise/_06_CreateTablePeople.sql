CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(200) NOT NULL,
    picture BLOB,
    height DECIMAL(5, 2),
    weight DECIMAL(5, 2),
    gender CHAR(1) NOT NULL CHECK (gender IN ('m', 'f')),
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography)
VALUES
    ('John Doe', NULL, 1.75, 70.5, 'm', '1990-05-15', 'John Doe is a fictional character.'),
    ('Jane Smith', NULL, 1.62, 55.8, 'f', '1985-09-22', 'Jane Smith is another fictional character.'),
    ('Bob Johnson', NULL, 1.80, 85.2, 'm', '1982-12-10', 'Bob Johnson has a fascinating story.'),
    ('Alice Brown', NULL, 1.68, 60.0, 'f', '1995-03-07', 'Alice Brown achieved great success in her career.'),
    ('Charlie Wilson', NULL, 1.90, 78.3, 'm', '1988-07-18', 'Charlie Wilson is known for his contributions to science.');
