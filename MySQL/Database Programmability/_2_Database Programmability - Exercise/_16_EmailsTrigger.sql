CREATE TABLE notification_emails(
	id INT PRIMARY KEY AUTO_INCREMENT,
    recipient INT NOT NULL,
    subject VARCHAR(2000),
    body TEXT
);

DELIMITER $

CREATE TRIGGER tr_insert
AFTER INSERT 
ON logs
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails (recipient, subject, body)
    VALUES (NEW.account_id,
    CONCAT('Balance change for account: ', NEW.account_id), 
    CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y'), ' your balance was changed from ', NEW.old_sum, ' to ', NEW.new_sum, '.'));
END; $

DELIMITER ;

CALL usp_deposit_money(1, 10);
SELECT * FROM notification_emails;
DROP TRIGGER tr_insert;