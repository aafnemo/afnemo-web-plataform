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

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.afnemo.commons.Logs;
import com.afnemo.model.dao.PersonaDao;
import com.afnemo.model.dto.Persona;
import com.afnemo.model.dto.Usuario;
@ManagedBean(name = "Persona")
@ApplicationScoped
public class ControladorPersona extends Logs {
	private static final boolean ESTADO = false;
	private static PersonaDao pdao = new PersonaDao();

	public String crearPersona(String id, String name, String lastname1,
			String lastname2, String email, String sex, Date birthday,
			String phone, Usuario user) {
		try {
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
		} catch (Exception e) {
			return "Error al crear la persona";
		}
	}

	public Persona consultarPersona(String id) {
		return pdao.consultarPorId(id);
	}
	public List<Persona> consultarPersonas() {
		return pdao.consultarTodasPersonas();
	}
	public List<Persona> consultarActivos() {
		return pdao.consultarPersonasActivas();
	}
	public String action() {
		String value = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("hidden1");
		log.debug(value + "Pruebas back");
		return "hola";
	}
}
