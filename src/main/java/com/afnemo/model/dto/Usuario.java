package com.afnemo.model.dto;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: Usuario.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */
@Entity
@Table(name = "TBL_Usuario", schema = "SCH_Afnemo")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PK_USR_Id", length = 15)
	private String id;
	@Column(name = "USR_Password", length = 512, nullable = false)
	private char[] password;
	@Column(name="USR_Estado",nullable=false)
	private boolean estado;
	@ManyToOne
	@JoinColumn(name = "FK_TU_Id", nullable = false)
	private TipoUsuario tipoUsuario;
	@OneToOne(mappedBy = "usuario")
	private Persona persona;
	public Usuario() {
		// default implementation ignored
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersonas(Persona persona) {
		this.persona = persona;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
