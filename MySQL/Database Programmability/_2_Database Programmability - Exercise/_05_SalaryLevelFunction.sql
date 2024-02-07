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

DELIMITER ;

SELECT ufn_get_salary_level(13500.00);
SELECT ufn_get_salary_level(43300.00);
SELECT ufn_get_salary_level(125500.00);