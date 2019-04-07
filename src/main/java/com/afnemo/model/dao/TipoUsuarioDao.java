package com.afnemo.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.afnemo.model.dto.TipoUsuario;
import com.afnemo.model.interfaces.TipoUsuarioDaoInterface;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: TipoUsuarioDao.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class TipoUsuarioDao implements TipoUsuarioDaoInterface {
	private static final String persistenceUnitName = "afnemo";
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private final Logger log = Logger.getLogger(getClass());
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public TipoUsuarioDao() {
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			log.debug(
					"Unidad de persistencia en TipoUsuarioDao Creada satisfactoriamente");
			
		} catch (PersistenceException pe) {
			Throwable th =  pe.getCause();
			log.error("Error al crear entidades de persistencia en TipoUsuarioDao"+ EXCEPTION_STRING + pe.getMessage());
			log.trace(""+EXCEPTION_STRING + pe.getMessage());
		}

	}
	@Override
	public void crearTipoUsuario(TipoUsuario tipoUsuario) {
		try {

		} catch (Exception e) {

		}
	}

	@Override
	public void actualizarTipoUsuario(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub

	}
}