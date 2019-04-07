package com.afnemo.model.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: TipoUsuario.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

@Entity
@Table(name = "TBL_TipoUsuario", schema = "SCH_Afnemo")
@NamedQuery(name = "tipousuario.findall", query = "select t from TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "PK_TU_Id")
	private int id;
	@Column(name = "TU_Detalle", length = 20, nullable = false)
	private String detalle;
	@OneToMany(mappedBy = "tipoUsuario")
	private Set<Usuario> usuarios;

	public TipoUsuario() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String detalle() {
		return this.detalle;
	}

	public void setdetalle(String detalle) {
		this.detalle = detalle;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipoUsuario(this);
		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipoUsuario(null);
		return usuario;
	}
}