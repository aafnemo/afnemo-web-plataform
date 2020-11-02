-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sch_afnemo2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sch_afnemo2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sch_afnemo2` DEFAULT CHARACTER SET latin1 ;
USE `sch_afnemo2` ;

-- -----------------------------------------------------
-- Table `sch_afnemo2`.`sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sch_afnemo2`.`sequence` (
  `SEQ_NAME` VARCHAR(50) NOT NULL,
  `SEQ_COUNT` DECIMAL(38,0) NULL DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sch_afnemo2`.`tbl_tipousuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sch_afnemo2`.`tbl_tipousuario` (
  `PK_TU_Id` INT(11) NOT NULL,
  `TU_Codigo` VARCHAR(20) NOT NULL,
  `TU_Detalle` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`PK_TU_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sch_afnemo2`.`tbl_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sch_afnemo2`.`tbl_usuario` (
  `PK_USR_Id` VARCHAR(15) NOT NULL,
  `USR_Estado` TINYINT(1) NOT NULL DEFAULT '0',
  `USR_Password` LONGTEXT NOT NULL,
  `FK_TU_Id` INT(11) NOT NULL,
  PRIMARY KEY (`PK_USR_Id`),
  INDEX `FK_TBL_Usuario_FK_TU_Id` (`FK_TU_Id` ASC) VISIBLE,
  CONSTRAINT `FK_TBL_Usuario_FK_TU_Id`
    FOREIGN KEY (`FK_TU_Id`)
    REFERENCES `sch_afnemo2`.`tbl_tipousuario` (`PK_TU_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sch_afnemo2`.`tbl_actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sch_afnemo2`.`tbl_actividad` (
  `ACT_id` INT(11) NOT NULL,
  `ACT_Detalle` VARCHAR(200) NULL DEFAULT NULL,
  `ACT_Estado` TINYINT(1) NOT NULL DEFAULT '0',
  `ACT_FechaFinal` DATE NULL DEFAULT NULL,
  `ACT_FechaInicio` DATE NOT NULL,
  `ACT_Localizacion` VARCHAR(45) NOT NULL,
  `ACT_Nombre` VARCHAR(45) NOT NULL,
  `PK_USR_Id` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`ACT_id`),
  INDEX `FK_TBL_Actividad_PK_USR_Id` (`PK_USR_Id` ASC) VISIBLE,
  CONSTRAINT `FK_TBL_Actividad_PK_USR_Id`
    FOREIGN KEY (`PK_USR_Id`)
    REFERENCES `sch_afnemo2`.`tbl_usuario` (`PK_USR_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sch_afnemo2`.`tbl_persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sch_afnemo2`.`tbl_persona` (
  `PRS_id` VARCHAR(10) NOT NULL,
  `PRS_Apellido1` VARCHAR(30) NOT NULL,
  `PRS_Apellido2` VARCHAR(30) NOT NULL,
  `PRS_Correo` VARCHAR(45) NULL DEFAULT NULL,
  `PRS_Entidad` VARCHAR(255) NOT NULL,
  `PRS_Estado` TINYINT(1) NOT NULL DEFAULT '0',
  `PRS_FechaNacimiento` DATE NOT NULL,
  `PRS_FechaRegistro` DATE NOT NULL,
  `PRS_Nombres` VARCHAR(45) NOT NULL,
  `PRS_Sexo` VARCHAR(45) NOT NULL,
  `PRS_Telefono` VARCHAR(12) NULL DEFAULT NULL,
  `PK_USR_Id` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`PRS_id`),
  INDEX `FK_TBL_Persona_PK_USR_Id` (`PK_USR_Id` ASC) VISIBLE,
  CONSTRAINT `FK_TBL_Persona_PK_USR_Id`
    FOREIGN KEY (`PK_USR_Id`)
    REFERENCES `sch_afnemo2`.`tbl_usuario` (`PK_USR_Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
