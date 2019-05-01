package com.afnemo.controller;
/**
  * 
  * @autor:       Arnold Herrera
  * @date:        1/05/2019
  * @filename:    ControladorActividad.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

import java.util.Date;

import com.afnemo.model.dao.ActividadDao;
import com.afnemo.model.dto.Actividad;

public class ControladorActividad {
	private static final boolean ESTADO = false;
	private static ActividadDao adao = new ActividadDao();
	public String crearActividad(int id, String nombre, String detalle,
			Date fechaInicio, Date fechaFinal, String localizacion) {
		try {
			Actividad activity = new Actividad();
			activity.setId(id);
			activity.setNombre(nombre);
			activity.setDetalle(detalle);
			activity.setFechaInicio(fechaInicio);
			activity.setFechaFinal(fechaFinal);
			activity.setLocalizacion(localizacion);
			activity.setEstado(ESTADO);
			return "Actividad Registrada exitosamente";
		} catch (Exception e) {
			return "Actividad No creada";
		}
	}
}
