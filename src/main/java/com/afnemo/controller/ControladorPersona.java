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
import com.afnemo.model.dto.Usuario;

@ManagedBean
@ApplicationScoped
public class ControladorPersona extends Logs {
	private static final boolean ESTADO = false;
	private static PersonaDao pdao = new PersonaDao();
	private Persona person = new Persona();
	private Usuario user = new Usuario();
	private String password;
	public String crearPersona() {
		try {

			/**
			 * person.setId(this); person.setNombres(this.nombres);
			 * person.setApellido1(this.apellido1);
			 * person.setApellido2(this.apellido2);
			 * person.setCorreo(this.correo); Date birthday = new
			 * SimpleDateFormat("dd-MM-yyyy").parse(this.date);
			 * person.setFechaNacimiento(birthday); person.setSexo(this.sex);
			 * person.setEstado(ESTADO); person.setTelefono(this.telefono);
			 */
			ControladorUsuario cu = new ControladorUsuario();
			person.setUsuario(cu.consultarUsuario(user.getId()));
			cu.crearUsario(user.getId(), password);
			pdao.crearPersona(person);
			return "registro.xhtml";
		} catch (Exception e) {
			log.error("Error al Registrar usuario" + e.getMessage());
			e.printStackTrace();
			return "registro.xhtml";
		}
	}

	public Persona getPerson() {
		return person;
	}

	public void setPerson(Persona person) {
		this.person = person;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "index.xhtml";
	}
}
