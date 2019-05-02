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

@ManagedBean
@ApplicationScoped
public class ControladorPersona extends Logs {
	private static final boolean ESTADO = false;
	private static PersonaDao pdao = new PersonaDao();
	private String id;
	private String nombres;
	private String apellido1;
	private String apellido2;
	private String correo;
	private String date;
	private String sex;
	private String telefono;
	private String user;
	private String password;

	public String crearPersona() {
		try {

			Persona person = new Persona();
			person.setId(this.id);
			person.setNombres(this.nombres);
			person.setApellido1(this.apellido1);
			person.setApellido2(this.apellido2);
			person.setCorreo(this.correo);
			Date birthday = new SimpleDateFormat("dd-MM-yyyy").parse(this.date);
			person.setFechaNacimiento(birthday);
			person.setSexo(this.sex);
			person.setEstado(ESTADO);
			person.setTelefono(this.telefono);
			ControladorUsuario cu = new ControladorUsuario();
			cu.crearUsario(this.user, this.password);
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
		return null;
	}
}
