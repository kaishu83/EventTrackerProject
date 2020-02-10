-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fishdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `fishdb` ;

-- -----------------------------------------------------
-- Schema fishdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fishdb` DEFAULT CHARACTER SET utf8 ;
USE `fishdb` ;

-- -----------------------------------------------------
-- Table `fishing_trip`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fishing_trip` ;

CREATE TABLE IF NOT EXISTS `fishing_trip` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NULL,
  `lake` VARCHAR(45) NOT NULL,
  `fish_caught` INT NOT NULL,
  `weather` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS eventuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'eventuser'@'localhost' IDENTIFIED BY 'SkilledShu$';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'eventuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
