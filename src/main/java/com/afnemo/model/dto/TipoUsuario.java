package com.afnemo.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

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
@NamedQuery(name = "tipousuario.findall", query = "select t from TipoUsuario t order by t.detalle")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PK_TU_Id")
	private int id;
	@Column(name = "TU_Codigo", length = 20, nullable = false)
	private String codigo;
	@Column(name = "TU_Detalle", length = 20, nullable = false)
	private String detalle;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	
}