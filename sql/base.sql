-- MySQL Script generated by MySQL Workbench
-- sáb 11 may 2019 16:21:11 -05
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema montesdeoca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema montesdeoca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `montesdeoca` DEFAULT CHARACTER SET latin1 ;
USE `montesdeoca` ;

-- -----------------------------------------------------
-- Table `montesdeoca`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `montesdeoca`.`Producto` (
  `codigoTra` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaProdu` VARCHAR(255) NULL DEFAULT NULL,
  `nombreProduc` VARCHAR(255) NULL DEFAULT NULL,
  `precioUnita` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`codigoTra`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `montesdeoca`.`InformesProducto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `montesdeoca`.`InformesProducto` (
  `codigoInfo` INT(11) NOT NULL AUTO_INCREMENT,
  `cantidadPro` INT(11) NULL DEFAULT NULL,
  `fechaInfo` DATE NULL DEFAULT NULL,
  `nombreProduc` VARCHAR(255) NULL DEFAULT NULL,
  `precioUnita` DOUBLE NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `codigoTra` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`codigoInfo`),
  INDEX `FK5kiw163srhj972ewxe54jjliv` (`codigoTra` ASC),
  CONSTRAINT `FK5kiw163srhj972ewxe54jjliv`
    FOREIGN KEY (`codigoTra`)
    REFERENCES `montesdeoca`.`Producto` (`codigoTra`))
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `montesdeoca`.`Trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `montesdeoca`.`Trabajador` (
  `codigoTra` INT(11) NOT NULL AUTO_INCREMENT,
  `apellidoTra` VARCHAR(255) NULL DEFAULT NULL,
  `celularTrabajo` VARCHAR(255) NULL DEFAULT NULL,
  `codgioTrabajador` VARCHAR(255) NULL DEFAULT NULL,
  `direccionTra` VARCHAR(255) NULL DEFAULT NULL,
  `estadoTrabajador` BIT(1) NULL DEFAULT NULL,
  `fechaEntradaTra` DATE NULL DEFAULT NULL,
  `montoHora` DOUBLE NULL DEFAULT NULL,
  `nacionalidadTra` VARCHAR(255) NULL DEFAULT NULL,
  `nombreTra` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`codigoTra`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `montesdeoca`.`Transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `montesdeoca`.`Transaccion` (
  `codigoTransaccion` INT(11) NOT NULL AUTO_INCREMENT,
  `estadoPago` BIT(1) NULL DEFAULT NULL,
  `fehca` DATE NULL DEFAULT NULL,
  `horaEntrada` TIME NULL DEFAULT NULL,
  `horaSalida` TIME NULL DEFAULT NULL,
  `totalHoras` INT(11) NULL DEFAULT NULL,
  `totalMinutos` INT(11) NULL DEFAULT NULL,
  `codigoTra` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`codigoTransaccion`),
  INDEX `FKn6cf52fnmu3726rxgcgrktx4j` (`codigoTra` ASC),
  CONSTRAINT `FKn6cf52fnmu3726rxgcgrktx4j`
    FOREIGN KEY (`codigoTra`)
    REFERENCES `montesdeoca`.`Trabajador` (`codigoTra`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `montesdeoca`.`tableTem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `montesdeoca`.`tableTem` (
  `codigo` INT(11) NOT NULL,
  `nombres` CHAR(100) NULL DEFAULT NULL,
  `apellidos` CHAR(100) NULL DEFAULT NULL,
  `horasTotal` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
