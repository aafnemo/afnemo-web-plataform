ALTER TABLE SCH_Afnemo.TBL_Usuario DROP FOREIGN KEY FK_TBL_Usuario_FK_TU_Id
ALTER TABLE SCH_Afnemo.TBL_Persona DROP FOREIGN KEY FK_TBL_Persona_PK_USR_Id
ALTER TABLE TBL_Persona_TBL_Actividad DROP FOREIGN KEY FK_TBL_Persona_TBL_Actividad_Persona_PRS_id
ALTER TABLE TBL_Persona_TBL_Actividad DROP FOREIGN KEY FK_TBL_Persona_TBL_Actividad_actividades_ACT_id
DROP TABLE SCH_Afnemo.TBL_TipoUsuario
DROP TABLE SCH_Afnemo.TBL_Usuario
DROP TABLE SCH_Afnemo.TBL_Persona
DROP TABLE SCH_Afnemo.TBL_Actividad
DROP TABLE TBL_Persona_TBL_Actividad
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
