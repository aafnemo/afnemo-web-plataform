package com.afnemo.model.interfaces;

import java.util.List;

import com.afnemo.model.dto.Persona;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: PersonaDaoInterface.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public interface PersonaDaoInterface {
	public void crearPersona(Persona persona);

	public void actualizarPersona(Persona persona);

	public List<Persona> consultarTodasPersonas();
	
	public Persona consultarPorId(String id);
}
