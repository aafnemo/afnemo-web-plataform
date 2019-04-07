package com.afnemo.model.interfaces;

import com.afnemo.model.dto.Actividad;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: ActividadDaoInterface.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public interface ActividadDaoInterface {
	public void crearActividad(Actividad actividad);

	public void actualizarActividad(Actividad actividad);
}
