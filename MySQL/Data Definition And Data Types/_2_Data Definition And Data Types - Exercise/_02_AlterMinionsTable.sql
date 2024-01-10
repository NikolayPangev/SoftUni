ALTER TABLE `minions` 
ADD COLUMN `town_id` INT NULL AFTER `age`;

ALTER TABLE `minions` 
ADD CONSTRAINT `town_id`
  FOREIGN KEY (`town_id`)
  REFERENCES `towns` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;