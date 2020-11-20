-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ScrumSkak
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ScrumSkak` ;

-- -----------------------------------------------------
-- Schema ScrumSkak
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ScrumSkak` DEFAULT CHARACTER SET utf8 ;
USE `ScrumSkak` ;

-- -----------------------------------------------------
-- Table `ScrumSkak`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Employee` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Employee` (
  `idEmployee` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM('chairman', 'teamleader', 'cashier') NOT NULL,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `uName` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmployee`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `fName_UNIQUE` ON `ScrumSkak`.`Employee` (`fName` ASC);

CREATE UNIQUE INDEX `lName_UNIQUE` ON `ScrumSkak`.`Employee` (`lName` ASC);

CREATE UNIQUE INDEX `uName_UNIQUE` ON `ScrumSkak`.`Employee` (`uName` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Member` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Member` (
  `idMember` INT NOT NULL AUTO_INCREMENT,
  `member_no` VARCHAR(45) NOT NULL,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `membership_type` ENUM('junior', 'adult', 'senior') NOT NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT '1',
  `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expire_date` DATETIME NOT NULL,
  PRIMARY KEY (`idMember`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `lName_UNIQUE` ON `ScrumSkak`.`Member` (`lName` ASC);

CREATE UNIQUE INDEX `member_no_UNIQUE` ON `ScrumSkak`.`Member` (`member_no` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Team` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Team` (
  `idTeam` INT NOT NULL AUTO_INCREMENT,
  `Employee_idEmployee` INT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTeam`),
  CONSTRAINT `fk_Team_Employee`
    FOREIGN KEY (`Employee_idEmployee`)
    REFERENCES `ScrumSkak`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `ScrumSkak`.`Team` (`name` ASC);

CREATE UNIQUE INDEX `code_UNIQUE` ON `ScrumSkak`.`Team` (`code` ASC);

CREATE INDEX `fk_Team_Employee_idx` ON `ScrumSkak`.`Team` (`Employee_idEmployee` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Tournament`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Tournament` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Tournament` (
  `idTournament` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `type` ENUM('local', 'other', 'weekend') NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`idTournament`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `code_UNIQUE` ON `ScrumSkak`.`Tournament` (`code` ASC);

CREATE UNIQUE INDEX `name_UNIQUE` ON `ScrumSkak`.`Tournament` (`name` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Tournament_Results`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Tournament_Results` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Tournament_Results` (
  `idTournament_Results` INT NOT NULL AUTO_INCREMENT,
  `Team_idTeam` INT NOT NULL,
  `Member_idMember` INT NOT NULL,
  `Tournament_idTournament` INT NOT NULL,
  `result` INT NOT NULL,
  PRIMARY KEY (`idTournament_Results`),
  CONSTRAINT `fk_Tournament_Results_Team1`
    FOREIGN KEY (`Team_idTeam`)
    REFERENCES `ScrumSkak`.`Team` (`idTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournament_Results_Member1`
    FOREIGN KEY (`Member_idMember`)
    REFERENCES `ScrumSkak`.`Member` (`idMember`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournament_Results_Tournament1`
    FOREIGN KEY (`Tournament_idTournament`)
    REFERENCES `ScrumSkak`.`Tournament` (`idTournament`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Tournament_Results_Team1_idx` ON `ScrumSkak`.`Tournament_Results` (`Team_idTeam` ASC);

CREATE INDEX `fk_Tournament_Results_Member1_idx` ON `ScrumSkak`.`Tournament_Results` (`Member_idMember` ASC);

CREATE INDEX `fk_Tournament_Results_Tournament1_idx` ON `ScrumSkak`.`Tournament_Results` (`Tournament_idTournament` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Advertisement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Advertisement` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Advertisement` (
  `idAdvertisement` INT NOT NULL,
  `Tournament_idTournament` INT NOT NULL,
  `text` VARCHAR(45) NOT NULL,
  `sponser_name` VARCHAR(45) NOT NULL,
  `sponser_contact` VARCHAR(45) NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`idAdvertisement`),
  CONSTRAINT `fk_Advertisement_Tournament1`
    FOREIGN KEY (`Tournament_idTournament`)
    REFERENCES `ScrumSkak`.`Tournament` (`idTournament`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idAdvertisement_UNIQUE` ON `ScrumSkak`.`Advertisement` (`idAdvertisement` ASC);

CREATE UNIQUE INDEX `sponser_contact_UNIQUE` ON `ScrumSkak`.`Advertisement` (`sponser_contact` ASC);

CREATE INDEX `fk_Advertisement_Tournament1_idx` ON `ScrumSkak`.`Advertisement` (`Tournament_idTournament` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Membership_Payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Membership_Payment` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Membership_Payment` (
  `idMembership_Payment` INT NOT NULL AUTO_INCREMENT,
  `Member_idMember` INT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`idMembership_Payment`),
  CONSTRAINT `fk_Membership_Payment_Member1`
    FOREIGN KEY (`Member_idMember`)
    REFERENCES `ScrumSkak`.`Member` (`idMember`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Membership_Payment_Member1_idx` ON `ScrumSkak`.`Membership_Payment` (`Member_idMember` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Team_Members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Team_Members` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Team_Members` (
  `idTeam_Members` INT NOT NULL AUTO_INCREMENT,
  `Team_idTeam` INT NOT NULL,
  `Member_idMember` INT NOT NULL,
  PRIMARY KEY (`idTeam_Members`),
  CONSTRAINT `fk_Team_Members_Team1`
    FOREIGN KEY (`Team_idTeam`)
    REFERENCES `ScrumSkak`.`Team` (`idTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Team_Members_Member1`
    FOREIGN KEY (`Member_idMember`)
    REFERENCES `ScrumSkak`.`Member` (`idMember`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Team_Members_Team1_idx` ON `ScrumSkak`.`Team_Members` (`Team_idTeam` ASC);

CREATE INDEX `fk_Team_Members_Member1_idx` ON `ScrumSkak`.`Team_Members` (`Member_idMember` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Reminder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Reminder` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Reminder` (
  `idReminder` INT NOT NULL AUTO_INCREMENT,
  `Member_idMember` INT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`idReminder`),
  CONSTRAINT `fk_Reminder_Member1`
    FOREIGN KEY (`Member_idMember`)
    REFERENCES `ScrumSkak`.`Member` (`idMember`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Reminder_Member1_idx` ON `ScrumSkak`.`Reminder` (`Member_idMember` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Reminder_Payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Reminder_Payment` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Reminder_Payment` (
  `idReminder_Payment` INT NOT NULL AUTO_INCREMENT,
  `Reminder_idReminder` INT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`idReminder_Payment`),
  CONSTRAINT `fk_Reminder_Payment_Reminder1`
    FOREIGN KEY (`Reminder_idReminder`)
    REFERENCES `ScrumSkak`.`Reminder` (`idReminder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Reminder_Payment_Reminder1_idx` ON `ScrumSkak`.`Reminder_Payment` (`Reminder_idReminder` ASC);


-- -----------------------------------------------------
-- Table `ScrumSkak`.`Tournament_Members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ScrumSkak`.`Tournament_Members` ;

CREATE TABLE IF NOT EXISTS `ScrumSkak`.`Tournament_Members` (
  `idTournament_Members` INT NOT NULL AUTO_INCREMENT,
  `Tournament_idTournament` INT NOT NULL,
  `Team_idTeam` INT NOT NULL,
  PRIMARY KEY (`idTournament_Members`),
  CONSTRAINT `fk_Tournament_Members_Tournament1`
    FOREIGN KEY (`Tournament_idTournament`)
    REFERENCES `ScrumSkak`.`Tournament` (`idTournament`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tournament_Members_Team1`
    FOREIGN KEY (`Team_idTeam`)
    REFERENCES `ScrumSkak`.`Team` (`idTeam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Tournament_Members_Tournament1_idx` ON `ScrumSkak`.`Tournament_Members` (`Tournament_idTournament` ASC);

CREATE INDEX `fk_Tournament_Members_Team1_idx` ON `ScrumSkak`.`Tournament_Members` (`Team_idTeam` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
