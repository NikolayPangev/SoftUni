DELIMITER $

CREATE FUNCTION ufn_calculate_future_value(sumParam DECIMAL(19, 4), interest_rate DOUBLE, number_of_years INT)
RETURNS DECIMAL(19, 4)
READS SQL DATA
BEGIN
	RETURN sumParam * POW(1 + interest_rate, number_of_years);
END $

DELIMITER ;

SELECT ufn_calculate_future_value(1000, 0.5, 5);