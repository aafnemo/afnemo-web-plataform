package com.afnemo.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: Actividad.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */
@Entity
@Table(name = "TBL_Actividad", schema = "SCH_Afnemo")
@NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ACT_id")
	private int id;
	@Column(name = "ACT_Nombre", length = 45, nullable = false)
	private String nombre;
	@Column(name = "ACT_Detalle", length = 200, nullable = true)
	private String detalle;
	@Column(name = "ACT_FechaInicio", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@Column(name = "ACT_FechaFinal", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date fechaFinal;
	@Column(name = "ACT_Localizacion", length = 45, nullable = false)
	private String localizacion;
	@Column(name="ACT_Estado",nullable=false)
	private boolean estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
