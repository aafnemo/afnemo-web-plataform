CREATE TABLE SCH_Afnemo.TBL_TipoUsuario
(
    PK_TU_Id   INTEGER     NOT NULL,
    TU_Detalle VARCHAR(20) NOT NULL,
    PRIMARY KEY (PK_TU_Id)
)
CREATE TABLE SCH_Afnemo.TBL_Usuario
(
    PK_USR_Id    VARCHAR(15)          NOT NULL,
    USR_Estado   TINYINT(1) default 0 NOT NULL,
    USR_Password LONGTEXT             NOT NULL,
    FK_TU_Id     INTEGER              NOT NULL,
    PRIMARY KEY (PK_USR_Id)
)
CREATE TABLE SCH_Afnemo.TBL_Persona
(
    PRS_id              VARCHAR(10) NOT NULL,
    PRS_Apellido1       VARCHAR(30) NOT NULL,
    PRS_Apellido2       VARCHAR(30) NOT NULL,
    PRS_Correo          VARCHAR(45),
    PRS_Estado          TINYINT(1)
        default 0                   NOT NULL,
    PRS_FechaNacimiento DATE        NOT NULL,
    PRS_FechaRegistro   DATE        NOT NULL,
    PRS_Nombres         VARCHAR(45) NOT NULL,
    PRS_Sexo            VARCHAR(45) NOT NULL,
    PRS_Telefono        VARCHAR(12),
    PK_USR_Id           VARCHAR(15) NOT NULL,
    PRIMARY KEY (PRS_id)
)
CREATE TABLE SCH_Afnemo.TBL_Actividad
(
    ACT_id           INTEGER              NOT NULL,
    ACT_Detalle      VARCHAR(200),
    ACT_Estado       TINYINT(1) default 0 NOT NULL,
    ACT_FechaFinal   DATE,
    ACT_FechaInicio  DATE                 NOT NULL,
    ACT_Localizacion VARCHAR(45)          NOT NULL,
    ACT_Nombre       VARCHAR(45)          NOT NULL,
    PRIMARY KEY (ACT_id)
)
CREATE TABLE TBL_Persona_TBL_Actividad
(
    Persona_PRS_id     VARCHAR(10) NOT NULL,
    actividades_ACT_id INTEGER     NOT NULL,
    PRIMARY KEY (Persona_PRS_id, actividades_ACT_id)
)
ALTER TABLE SCH_Afnemo.TBL_Usuario
    ADD CONSTRAINT FK_TBL_Usuario_FK_TU_Id FOREIGN KEY (FK_TU_Id) REFERENCES SCH_Afnemo.TBL_TipoUsuario (PK_TU_Id)
ALTER TABLE SCH_Afnemo.TBL_Persona
    ADD CONSTRAINT FK_TBL_Persona_PK_USR_Id FOREIGN KEY (PK_USR_Id) REFERENCES SCH_Afnemo.TBL_Usuario (PK_USR_Id)
ALTER TABLE TBL_Persona_TBL_Actividad
    ADD CONSTRAINT FK_TBL_Persona_TBL_Actividad_Persona_PRS_id FOREIGN KEY (Persona_PRS_id) REFERENCES SCH_Afnemo.TBL_Persona (PRS_id)
ALTER TABLE TBL_Persona_TBL_Actividad
    ADD CONSTRAINT FK_TBL_Persona_TBL_Actividad_actividades_ACT_id FOREIGN KEY (actividades_ACT_id) REFERENCES SCH_Afnemo.TBL_Actividad (ACT_id)
CREATE TABLE SEQUENCE
(
    SEQ_NAME  VARCHAR(50) NOT NULL,
    SEQ_COUNT DECIMAL(38),
    PRIMARY KEY (SEQ_NAME)
)
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT)
values ('SEQ_GEN', 0)
