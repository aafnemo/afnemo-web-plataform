package com.afnemo.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: Persona.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */
@Entity
@Table(name = "TBL_Persona", schema = "SCH_Afnemo")
@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "PRS_id", length = 10)
	private String id;
	@Column(name = "PRS_Nombres", length = 45, nullable = false)
	private String nombres;
	@Column(name = "PRS_Apellido1", length = 30, nullable = false)
	private String apellido1;
	@Column(name = "PRS_Apellido2", length = 30, nullable = false)
	private String apellido2;
	@Column(name = "PRS_Correo", length = 45, nullable = false)
	private String correo;
	@Column(name = "PRS_Sexo", length = 45, nullable = false)
	private String sexo;
	@Column(name = "PRS_FechaNacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@OneToOne
	@JoinColumn(name="PK_USR_Id",nullable = false)
	private Usuario usuario;
	@ManyToMany
	private Set<Actividad> actividades;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
