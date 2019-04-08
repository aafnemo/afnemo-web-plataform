package com.afnemo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

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
	private static final String PERSISTENCEUNITNAME = "afnemo";
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory(PERSISTENCEUNITNAME);
	private static EntityManager em = emf.createEntityManager();
	private final Logger log = Logger.getLogger(getClass());
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public TipoUsuarioDao() {
		// default implementation not used
	}
	@Override
	public void crearTipoUsuario(TipoUsuario tipoUsuario) {
		try {
			em.getTransaction().begin();
			em.persist(tipoUsuario);
			em.getTransaction().commit();
			em.close();
			log.info("Se creo el tipo de usuario: " + tipoUsuario.getDetalle());
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
			Throwable th = pe.getCause();
			log.error("Error al crear un tipo de usuario" + EXCEPTION_STRING
					+ pe.getMessage());
			log.trace("Error al actualizar el tipo de usuario "+ tipoUsuario.getDetalle()
					+ EXCEPTION_STRING + th.getMessage());
		}
	}

	@Override
	public void actualizarTipoUsuario(TipoUsuario tipoUsuario) {
		try {
			em.getTransaction().begin();
			em.merge(tipoUsuario);
			em.getTransaction().commit();
			em.close();
			log.info("Se actualiza información del tipo de usuario: "
					+ tipoUsuario.getDetalle());
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
			Throwable th = pe.getCause();
			log.error("Error al actualizar el Tipo de Usuario"
					+ EXCEPTION_STRING + pe.getMessage());
			log.trace("Error al actualizar el Tipo de Usuario"
					+ EXCEPTION_STRING + th.getMessage());
		}
	}
	@Override
	public List<TipoUsuario> consultarTipoUsuario(int id) {
		return em.createNamedQuery("tipousuario.findAll").getResultList();
	}
}