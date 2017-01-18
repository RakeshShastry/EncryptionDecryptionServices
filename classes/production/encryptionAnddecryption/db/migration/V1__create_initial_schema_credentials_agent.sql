CREATE TABLE `credential_storage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `agent_name` VARCHAR(45) NULL,
  `carrier` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(255) NULL,
  `flag` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
