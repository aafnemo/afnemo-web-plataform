package com.afnemo.controller;
/**
  * 
  * @autor:       Arnold Herrera
  * @date:        21/04/2019
  * @filename:    ControllerPersona.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.afnemo.commons.Logs;
import com.afnemo.model.dao.PersonaDao;
import com.afnemo.model.dto.Persona;

@ManagedBean(name = "Persona")
@ApplicationScoped
public class ControladorPersona extends Logs {
	private static final boolean ESTADO = false;
	private static PersonaDao pdao = new PersonaDao();

	public String crearPersona() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();

			Persona person = new Persona();
			person.setId(facesContext.getExternalContext()
					.getRequestParameterMap().get("id"));
			person.setNombres(facesContext.getExternalContext()
					.getRequestParameterMap().get("nombres"));
			person.setApellido1(facesContext.getExternalContext()
					.getRequestParameterMap().get("apellido1"));
			person.setApellido2(facesContext.getExternalContext()
					.getRequestParameterMap().get("apellido2"));
			person.setCorreo(facesContext.getExternalContext()
					.getRequestParameterMap().get("correo"));
			Date birthday = new SimpleDateFormat("dd-MM-yyyy")
					.parse(facesContext.getExternalContext()
							.getRequestParameterMap().get("date"));
			person.setFechaNacimiento(birthday);
			person.setSexo(facesContext.getExternalContext()
					.getRequestParameterMap().get("sexo"));
			person.setEstado(ESTADO);
			person.setTelefono(facesContext.getExternalContext()
					.getRequestParameterMap().get("telefono"));
			String user = facesContext.getExternalContext()
					.getRequestParameterMap().get("usuario");
			String pass = facesContext.getExternalContext()
					.getRequestParameterMap().get("pass");
			ControladorUsuario cu = new ControladorUsuario();
			cu.crearUsario(user, pass);
			person.setUsuario(cu.consultarUsuario(user));
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
