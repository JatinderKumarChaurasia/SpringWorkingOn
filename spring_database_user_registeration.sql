SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `spring_security_custom_user_registration` DEFAULT CHARACTER SET utf8 ;
USE `spring_security_custom_user_registration` ;

-- -----------------------------------------------------
-- Table `spring_security_custom_user_registration`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring_security_custom_user_registration`.`role` ;

CREATE  TABLE IF NOT EXISTS `spring_security_custom_user_registration`.`role` (
  `id` INT(20) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `spring_security_custom_user_registration`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring_security_custom_user_registration`.`user` ;

CREATE  TABLE IF NOT EXISTS `spring_security_custom_user_registration`.`user` (
  `id` INT(20) NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(50) NOT NULL ,
  `password` CHAR(100) NOT NULL ,
  `firstname` VARCHAR(100) NOT NULL ,
  `lastname` VARCHAR(100) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `spring_security_custom_user_registration`.`users_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring_security_custom_user_registration`.`users_roles` ;

CREATE  TABLE IF NOT EXISTS `spring_security_custom_user_registration`.`users_roles` (
  `user_id` INT(20) NOT NULL ,
  `role_id` INT(20) NOT NULL ,
  PRIMARY KEY (`user_id`, `role_id`) ,
  INDEX `fk_role_id` (`role_id` ASC) ,
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `spring_security_custom_user_registration`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_id`
    FOREIGN KEY (`role_id` )
    REFERENCES `spring_security_custom_user_registration`.`role` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `spring_security_custom_user_registration` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
