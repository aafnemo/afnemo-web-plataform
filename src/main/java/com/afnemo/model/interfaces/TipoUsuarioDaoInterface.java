package com.afnemo.model.interfaces;

import java.util.List;

import com.afnemo.model.dto.TipoUsuario;

/**
  * 
  * @autor:       Arnold Herrera
  * @date:        7/04/2019
  * @filename:    TipoUsuarioDaoInterface.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

public interface TipoUsuarioDaoInterface {
	
	public void crearTipoUsuario(TipoUsuario tipoUsuario);
	
	public void actualizarTipoUsuario(TipoUsuario tipoUsuario);
	
	public List<TipoUsuario> findAll(int id);
}
