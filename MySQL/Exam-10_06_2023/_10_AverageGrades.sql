DELIMITER $

CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
RETURNS DECIMAL(19, 2)
DETERMINISTIC
BEGIN
	DECLARE average_grade DECIMAL(19, 2);
    SET average_grade := (
		SELECT AVG(sc.grade)
        FROM students AS s
        JOIN students_courses AS sc
        ON s.id = sc.student_id
        JOIN courses AS c
        ON sc.course_id = c.id
	WHERE s.is_graduated = 1 AND c.name = course_name);
    RETURN average_grade;
END $

DELIMITER ;

SELECT udf_average_alumni_grade_by_course_name('Quantum Physics');