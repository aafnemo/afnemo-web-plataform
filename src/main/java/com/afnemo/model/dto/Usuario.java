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
	@Column(name = "USR_Estado", nullable = false)
	private boolean estado;
	@Column(name = "USR_Password", length = 254, nullable = false)
	private String password;
	@ManyToOne(optional = false)
	private TipoUsuario tipoUsuario;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
