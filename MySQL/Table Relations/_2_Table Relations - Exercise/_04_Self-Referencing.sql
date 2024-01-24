CREATE TABLE teachers(
	teacher_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    manager_id INT,
    FOREIGN KEY (manager_id) 
    REFERENCES teachers(teacher_id)
);

INSERT INTO teachers (teacher_id, name)
VALUES
    (101, 'John'),
    (102, 'Maya'),
    (103, 'Silvia'),
    (104, 'Ted'),
    (105, 'Mark'),
    (106, 'Greta');
    
    
UPDATE teachers
SET manager_id = 
    CASE teacher_id
        WHEN 101 THEN NULL
        WHEN 102 THEN 106
        WHEN 103 THEN 106
        WHEN 104 THEN 105
        WHEN 105 THEN 101
        WHEN 106 THEN 101
    END;