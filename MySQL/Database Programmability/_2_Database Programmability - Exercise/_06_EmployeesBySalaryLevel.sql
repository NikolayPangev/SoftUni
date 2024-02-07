DELIMITER $

CREATE FUNCTION ufn_get_salary_level(salaryOfEmployee DECIMAL(10, 4))
RETURNS VARCHAR(20)
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(20);
    
    IF salaryOfEmployee < 30000 THEN
        SET result := 'Low';
    ELSEIF salaryOfEmployee >= 30000 AND salaryOfEmployee <= 50000 THEN
        SET result := 'Average';
    ELSE
        SET result := 'High';
    END IF;
    
    RETURN result;
END $

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(50))
BEGIN
	SELECT first_name, last_name
    FROM employees
    WHERE salary_level = ufn_get_salary_level(salary)
    ORDER BY first_name DESC, last_name DESC;
END $

DELIMITER $

CALL usp_get_employees_by_salary_level('High');