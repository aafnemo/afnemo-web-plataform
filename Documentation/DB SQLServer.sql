-- MySQL Workbench Forward Engineering

-- SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
-- SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
-- SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema afnemo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema afnemo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS afnemo DEFAULT CHARACTER SET utf8 ;
USE [afnemo] ;

-- -----------------------------------------------------
-- Table `afnemo`.`actividad`
-- -----------------------------------------------------
CREATE TABLE afnemo.actividad (
  [idactividad] INT NOT NULL,
  [nombre] VARCHAR(45) NOT NULL,
  [detalle] VARCHAR(200) NULL,
  [fechainicio] DATETIME2(0) NOT NULL,
  [fechafin] DATETIME2(0) NULL,
  [ubicacion] VARCHAR(45) NOT NULL,
  PRIMARY KEY ([idactividad]))
;


-- -----------------------------------------------------
-- Table `afnemo`.`tipousuario`
-- -----------------------------------------------------
CREATE TABLE afnemo.tipousuario (
  [idtipousuario] INT NOT NULL,
  [tiposuariodetalle] VARCHAR(20) NOT NULL,
  PRIMARY KEY ([idtipousuario]))
;


-- -----------------------------------------------------
-- Table `afnemo`.`usuario`
-- -----------------------------------------------------
CREATE TABLE afnemo.usuario (
  [userid] VARCHAR(15) NOT NULL,
  [password] CHAR(128) NOT NULL,
  [tipousuario_idtipousuario] INT NOT NULL,
  PRIMARY KEY ([userid], [tipousuario_idtipousuario])
 ,
  CONSTRAINT [fk_usuario_tipousuario1]
    FOREIGN KEY ([tipousuario_idtipousuario])
    REFERENCES afnemo.tipousuario ([idtipousuario])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX [fk_usuario_tipousuario1_idx] ON afnemo.usuario ([tipousuario_idtipousuario] ASC);


-- -----------------------------------------------------
-- Table `afnemo`.`persona`
-- -----------------------------------------------------
CREATE TABLE afnemo.persona (
  [idpersona] VARCHAR(10) NOT NULL,
  [nombres] VARCHAR(45) NOT NULL,
  [apellido1] VARCHAR(80) NOT NULL,
  [apellido2] VARCHAR(80) NOT NULL,
  [correo] VARCHAR(45) NOT NULL,
  [sexo] VARCHAR(19) NOT NULL,
  [fechanacimiento] DATE NOT NULL,
  [usuario_userid] VARCHAR(15) NOT NULL,
  PRIMARY KEY ([idpersona], [usuario_userid])
 ,
  CONSTRAINT [fk_persona_usuario1]
    FOREIGN KEY ([usuario_userid])
    REFERENCES afnemo.usuario ([userid])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX [fk_persona_usuario1_idx] ON afnemo.persona ([usuario_userid] ASC);


-- -----------------------------------------------------
-- Table `afnemo`.`actividad_has_persona`
-- -----------------------------------------------------
CREATE TABLE afnemo.actividad_has_persona (
  [actividad_idactividad] INT NOT NULL,
  [persona_idpersona] VARCHAR(10) NOT NULL,
  PRIMARY KEY ([actividad_idactividad], [persona_idpersona])
 ,
  CONSTRAINT [fk_actividad_has_persona_actividad]
    FOREIGN KEY ([actividad_idactividad])
    REFERENCES afnemo.actividad ([idactividad])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT [fk_actividad_has_persona_persona1]
    FOREIGN KEY ([persona_idpersona])
    REFERENCES afnemo.persona ([idpersona])
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX [fk_actividad_has_persona_persona1_idx] ON afnemo.actividad_has_persona ([persona_idpersona] ASC);
CREATE INDEX [fk_actividad_has_persona_actividad_idx] ON afnemo.actividad_has_persona ([actividad_idactividad] ASC);


-- SET SQL_MODE=@OLD_SQL_MODE;
-- SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
-- SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
