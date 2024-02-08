DELIMITER $

CREATE PROCEDURE usp_transfer_money(account_id INT, target_id INT, money_amount DECIMAL(19, 4))
BEGIN 
	START TRANSACTION;
    IF((SELECT COUNT(*) FROM accounts WHERE id = account_id) <> 1 OR 
	   (SELECT COUNT(*) FROM accounts WHERE id = target_id) <> 1 OR
      ((SELECT balance FROM accounts WHERE id = account_id) < money_amount) OR
      target_id = account_id OR
      money_amount < 0) THEN
		ROLLBACK;
	ELSE 
		UPDATE accounts 
		SET balance = balance - money_amount
		WHERE id = account_id;
        UPDATE accounts 
		SET balance = balance + money_amount
		WHERE id = target_id;
		COMMIT;
    END IF;
END $

DELIMITER ;

CALL usp_transfer_money(2, 1, 10);