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
CREATE USER afnemo IDENTIFIED BY afnemo /* DEFAULT CHARACTER SET utf8 */ ;
ALTER SESSION SET CURRENT_SCHEMA = afnemo ;

-- -----------------------------------------------------
-- Table `afnemo`.`actividad`
-- -----------------------------------------------------
CREATE TABLE afnemo.actividad (
  idactividad NUMBER(10) NOT NULL,
  nombre VARCHAR2(45) NOT NULL,
  detalle VARCHAR2(200) NULL,
  fechainicio TIMESTAMP(0) NOT NULL,
  fechafin TIMESTAMP(0) NULL,
  ubicacion VARCHAR2(45) NOT NULL,
  PRIMARY KEY (idactividad))
;


-- -----------------------------------------------------
-- Table `afnemo`.`tipousuario`
-- -----------------------------------------------------
CREATE TABLE afnemo.tipousuario (
  idtipousuario NUMBER(10) NOT NULL,
  tiposuariodetalle VARCHAR2(20) NOT NULL,
  PRIMARY KEY (idtipousuario))
;


-- -----------------------------------------------------
-- Table `afnemo`.`usuario`
-- -----------------------------------------------------
CREATE TABLE afnemo.usuario (
  userid VARCHAR2(15) NOT NULL,
  password VARCHAR2(128) NOT NULL,
  tipousuario_idtipousuario NUMBER(10) NOT NULL,
  PRIMARY KEY (userid, tipousuario_idtipousuario)
 ,
  CONSTRAINT fk_usuario_tipousuario1
    FOREIGN KEY (tipousuario_idtipousuario)
    REFERENCES afnemo.tipousuario (idtipousuario)
   )
;

CREATE INDEX fk_usuario_tipousuario1_idx ON afnemo.usuario (tipousuario_idtipousuario ASC);


-- -----------------------------------------------------
-- Table `afnemo`.`persona`
-- -----------------------------------------------------
CREATE TABLE afnemo.persona (
  idpersona VARCHAR2(10) NOT NULL,
  nombres VARCHAR2(45) NOT NULL,
  apellido1 VARCHAR2(80) NOT NULL,
  apellido2 VARCHAR2(80) NOT NULL,
  correo VARCHAR2(45) NOT NULL,
  sexo VARCHAR2(19) NOT NULL,
  fechanacimiento DATE NOT NULL,
  usuario_userid VARCHAR2(15) NOT NULL,
  PRIMARY KEY (idpersona, usuario_userid)
 ,
  CONSTRAINT fk_persona_usuario1
    FOREIGN KEY (usuario_userid)
    REFERENCES afnemo.usuario (userid)
   )
;

CREATE INDEX fk_persona_usuario1_idx ON afnemo.persona (usuario_userid ASC);


-- -----------------------------------------------------
-- Table `afnemo`.`actividad_has_persona`
-- -----------------------------------------------------
CREATE TABLE afnemo.actividad_has_persona (
  actividad_idactividad NUMBER(10) NOT NULL,
  persona_idpersona VARCHAR2(10) NOT NULL,
  PRIMARY KEY (actividad_idactividad, persona_idpersona)
 ,
  CONSTRAINT fk_actividad_has_persona_actividad
    FOREIGN KEY (actividad_idactividad)
    REFERENCES afnemo.actividad (idactividad)
   ,
  CONSTRAINT fk_actividad_has_persona_persona1
    FOREIGN KEY (persona_idpersona)
    REFERENCES afnemo.persona (idpersona)
   )
;

CREATE INDEX fk_actividad_has_persona_persona1_idx ON afnemo.actividad_has_persona (persona_idpersona ASC);
CREATE INDEX fk_actividad_has_persona_actividad_idx ON afnemo.actividad_has_persona (actividad_idactividad ASC);


-- SET SQL_MODE=@OLD_SQL_MODE;
-- SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
-- SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS; 
