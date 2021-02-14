-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`devices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`devices` (
  `deviceId` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`deviceId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`testers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`testers` (
  `testerId` INT NOT NULL,
  `firstName` VARCHAR(255) NULL,
  `lastName` VARCHAR(255) NULL,
  `country` VARCHAR(255) NULL,
  `lastLogin` DATETIME NULL,
  PRIMARY KEY (`testerId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`bugs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`bugs` (
  `bugId` INT NOT NULL,
  `deviceId` INT NOT NULL,
  `testerId` INT NOT NULL,
  PRIMARY KEY (`bugId`),
  INDEX `fk_bugs_devices1_idx` (`deviceId` ASC) VISIBLE,
  INDEX `fk_bugs_testers1_idx` (`testerId` ASC) VISIBLE,
  CONSTRAINT `fk_bugs_devices1`
    FOREIGN KEY (`deviceId`)
    REFERENCES `mydb`.`devices` (`deviceId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bugs_testers1`
    FOREIGN KEY (`testerId`)
    REFERENCES `mydb`.`testers` (`testerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tester_device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tester_device` (
  `testerId` INT NOT NULL,
  `deviceId` INT NOT NULL,
  INDEX `fk_tester_device_testers_idx` (`testerId` ASC) VISIBLE,
  INDEX `fk_tester_device_devices1_idx` (`deviceId` ASC) VISIBLE,
  CONSTRAINT `fk_tester_device_testers`
    FOREIGN KEY (`testerId`)
    REFERENCES `mydb`.`testers` (`testerId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tester_device_devices1`
    FOREIGN KEY (`deviceId`)
    REFERENCES `mydb`.`devices` (`deviceId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
