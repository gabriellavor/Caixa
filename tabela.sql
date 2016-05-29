SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema banco
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banco` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `banco` ;

-- -----------------------------------------------------
-- Table `banco`.`transacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `banco`.`transacao` ;

CREATE TABLE IF NOT EXISTS `banco`.`transacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(15) NULL,
  `valor` DECIMAL(10,2) NULL,
  `data` TIMESTAMP NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
