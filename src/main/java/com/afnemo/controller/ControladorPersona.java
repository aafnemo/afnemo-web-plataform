package com.afnemo.controller;
/**
  * 
  * @autor:       Arnold Herrera
  * @date:        21/04/2019
  * @filename:    ControllerPersona.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

import java.util.Date;
import java.util.List;

import com.afnemo.model.dao.PersonaDao;
import com.afnemo.model.dto.Persona;
import com.afnemo.model.dto.Usuario;

public class ControladorPersona {
	private static final boolean ESTADO = false;
	private static PersonaDao pdao = new PersonaDao();

	public String crearPersona(String id, String name, String lastname1,
			String lastname2, String email, String sex, Date birthday,
			String phone, Usuario user) {
		Persona person = new Persona();
		person.setId(id);
		person.setNombres(name);
		person.setApellido1(lastname1);
		person.setApellido2(lastname2);
		person.setCorreo(email);
		person.setFechaNacimiento(birthday);
		person.setSexo(sex);
		person.setEstado(ESTADO);
		person.setTelefono(phone);
		person.setUsuario(user);
		pdao.crearPersona(person);
		return "Registro exitoso";
	}

	public Persona consultarPersona(String id) {
		return pdao.consultarPorId(id);
	}
	public List<Persona> consultarPersonas() {
		
		return null;
	}
}
