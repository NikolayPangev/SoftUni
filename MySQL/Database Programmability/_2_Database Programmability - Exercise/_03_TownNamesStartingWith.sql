DELIMITER $

CREATE PROCEDURE usp_get_towns_starting_with(symbol VARCHAR(50))
BEGIN
    SELECT name
    FROM towns
    WHERE name LIKE CONCAT(symbol, '%')
    ORDER BY name ;
END $

DELIMITER ;

CALL usp_get_towns_starting_with('b');