package com.afnemo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import com.afnemo.commons.Logs;
import com.afnemo.model.dto.Usuario;
import com.afnemo.model.interfaces.UsuarioDaoInterface;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: UsuarioDao.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class UsuarioDao extends Logs implements UsuarioDaoInterface {
	private static final String PERSISTENCEUNITNAME = "afnemo";
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory(PERSISTENCEUNITNAME);
	private static EntityManager em = emf.createEntityManager();
	private final Logger log = Logger.getLogger(getClass());
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public UsuarioDao() {
		// default implementation not used
	}
	@Override
	public void crearUsuario(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
			log.info("Se creo el tipo de usuario: " + usuario.getId());
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
			Throwable th = pe.getCause();
			log.error("Error al crear un tipo de usuario" + EXCEPTION_STRING
					+ pe.getMessage());
			log.trace("Error al crear el  Usuario" + usuario.getId() + " "
					+ EXCEPTION_STRING + th.getMessage());
		}
	}
	@Override
	public void actualizarUsuario(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
			log.info("Se creo el tipo de usuario: " + usuario.getId());
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
			Throwable th = pe.getCause();
			log.error("Error al crear un tipo de usuario" + usuario.getId()
					+ " " + EXCEPTION_STRING + pe.getMessage());
			log.trace("Error al actualizar el Usuario" + usuario.getId() + " "
					+ EXCEPTION_STRING + th.getMessage());
		}
	}
	@Override
	public List<Usuario> consultarUsuario(String id) {
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

}
