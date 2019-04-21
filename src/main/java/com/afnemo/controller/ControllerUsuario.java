package com.afnemo.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.afnemo.commons.Logs;
import com.afnemo.commons.HashPassword;
import com.afnemo.model.dao.UsuarioDao;
import com.afnemo.model.dto.Usuario;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 20/04/2019
 * @filename: ControllerUsuario.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class ControllerUsuario extends Logs {
	private static final  boolean ESTADO = true;
	private UsuarioDao udao = new UsuarioDao();
	private Pattern pattern;
	private static final String PASS_PATTERN = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";
	public ControllerUsuario() {
		pattern = Pattern.compile(PASS_PATTERN);
	}
	public void crearUsario(String id, String contrasena) {
		Usuario usuario = new Usuario();
		try {
			usuario.setId(id);
			char[] password = validarPassword(contrasena);
			usuario.setPassword(password);
			usuario.setEstado(ESTADO);
			udao.crearUsuario(usuario);
			log.info("Se ha creado exitosamente el usuario: {0} " ,id);
		} catch (Exception e) {
			log.error("No se ha podido crear exitosamente el usuario " + id
					+ " debido a el siguiente error" + e.getMessage());
		}
	}

	public String consultarUsuario(String id) {
		return udao.consultarUsuario(id).getId();
	}

	public String actualizarUsuario(String id, String contrasena) {
		
		Usuario usuario = udao.consultarUsuario(id);
		char[] password = validarPassword(contrasena);
		usuario.setPassword(password);
		udao.actualizarUsuario(usuario);
		log.info("La contraseña del usuario: {0} fue actualizada correctamente",id);
		return "Contraseña actualizada conrrectamente";
	}
	/**
	 * Contraseña debe tener al menos un dígito, una minuscula, una mayuscula y
	 * al menos un caracter no alfanúmerico:
	 * ^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{8,16}$
	 */
	private boolean validate(final String password) {
		Matcher matcher;
		matcher = pattern.matcher(password);
		return matcher.matches();
	}
	private final char[] validarPassword(String password) {
		try {
			return validate(password)
					? HashPassword.createHash(password).toCharArray()
					: null;
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			log.error("Error al validar la contraseña"
					+ e.getCause().getMessage());
			return new char[0];
		}
	}
	
}
