-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema asegurados
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema asegurados
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `asegurados` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `asegurados` ;

-- -----------------------------------------------------
-- Table `asegurados`.`asegurados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asegurados`.`asegurados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `edad` VARCHAR(255) NOT NULL,
  `sexo` ENUM('M', 'F') NOT NULL,
  `numero_seguro_social` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asegurados`.`medicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asegurados`.`medicos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `cedula` VARCHAR(45) NOT NULL,
  `espcialidad` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asegurados`.`consultas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asegurados`.`consultas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `observaciones` VARCHAR(400) NOT NULL,
  `asegurados_id` INT NOT NULL,
  `medicos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_consultas_asegurados_idx` (`asegurados_id` ASC),
  INDEX `fk_consultas_medicos1_idx` (`medicos_id` ASC),
  CONSTRAINT `fk_consultas_asegurados`
    FOREIGN KEY (`asegurados_id`)
    REFERENCES `asegurados`.`asegurados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consultas_medicos1`
    FOREIGN KEY (`medicos_id`)
    REFERENCES `asegurados`.`medicos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asegurados`.`medicamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asegurados`.`medicamentos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `presentacion` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `asegurados`.`recetas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asegurados`.`recetas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dosis` VARCHAR(255) NOT NULL,
  `medicamentos_id` INT NOT NULL,
  `consultas_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_recetas_medicamentos1_idx` (`medicamentos_id` ASC),
  INDEX `fk_recetas_consultas1_idx` (`consultas_id` ASC),
  CONSTRAINT `fk_recetas_medicamentos1`
    FOREIGN KEY (`medicamentos_id`)
    REFERENCES `asegurados`.`medicamentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recetas_consultas1`
    FOREIGN KEY (`consultas_id`)
    REFERENCES `asegurados`.`consultas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
