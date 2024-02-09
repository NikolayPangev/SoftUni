INSERT INTO courses(name, duration_hours, start_date, teacher_name, description, university_id) 
SELECT  CONCAT(teacher_name,' course'), 
		CHAR_LENGTH(name) / 10, 
        DATE(start_date + 5), 
        REVERSE(teacher_name),
        CONCAT('Course ', teacher_name, REVERSE(description)),
        DAY(start_date)
FROM courses
WHERE id <= 5;