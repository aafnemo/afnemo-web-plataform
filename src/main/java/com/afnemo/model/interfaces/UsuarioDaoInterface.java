package com.afnemo.model.interfaces;

import java.util.List;

import com.afnemo.model.dto.Usuario;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: UsuarioDaoInterface.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public interface UsuarioDaoInterface {
	public void crearUsuario(Usuario usuario);

	public void actualizarUsuario(Usuario usuario);

	public List<Usuario> consultarUsuarios();
	
	public Usuario consultarUsuario(String id);
}
