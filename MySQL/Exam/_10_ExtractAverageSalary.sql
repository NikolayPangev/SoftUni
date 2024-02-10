DELIMITER $
CREATE FUNCTION udf_average_salary_by_position_name (name VARCHAR(40))
RETURNS DECIMAL (19, 2)
DETERMINISTIC
BEGIN
	DECLARE avg_salary DECIMAL(19, 2);
    SET avg_salary := (
        SELECT AVG(w.salary)
        FROM workers w
        JOIN positions p ON w.position_id = p.id
        WHERE p.name = name
    );
    RETURN avg_salary;
END;

SELECT udf_average_salary_by_position_name('Forester');