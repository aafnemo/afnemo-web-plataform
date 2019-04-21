package com.afnemo.controller;
/**
  * 
  * @autor:       Arnold Herrera
  * @date:        12/04/2019
  * @filename:    ControllerTipoUsuario.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

import java.util.List;

import com.afnemo.commons.Logs;
import com.afnemo.model.dao.TipoUsuarioDao;
import com.afnemo.model.dto.TipoUsuario;

public class ControllerTipoUsuario extends Logs {
	public static final boolean DEFAULT_STATUS = true;
	static TipoUsuarioDao tdao = new TipoUsuarioDao();
	public void crearTipoUsuario(String tipo) {
		TipoUsuario tu = new TipoUsuario();
		try {
			tu.setDetalle(tipo);
			tdao.crearTipoUsuario(tu);
			log.info("El tipo de usuario {0} ha sido creado exitosamente",tipo);
		} catch (Exception e) {
			log.error("Error al crear el tipo de usuario " + tipo + " debido a "
					+ e.getMessage());
		}
	}
	public TipoUsuario seleccionarTipoUsuario(int id) {
		return tdao.seleccionarTipoUsuario(id);
	}
	public List<TipoUsuario> seleccionarTiposdeUsuarios() {
		return tdao.findAll();
	}
}