package com.afnemo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

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
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory(PERSISTENCEUNITNAME);
	private EntityManager em = emf.createEntityManager();
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public UsuarioDao() {

		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENCEUNITNAME);
			em = emf.createEntityManager();
			log.info(
					"Unidad de persistencia en UsuarioDao Creada satisfactoriamente");

		} catch (PersistenceException pe) {
			Throwable th = pe.getCause();
			log.fatal("Error al crear entidades de persistencia en UsuarioDao"
					+ EXCEPTION_STRING + pe.getMessage());
			log.trace("" + EXCEPTION_STRING + th.getMessage());
		}

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
	public List<Usuario> consultarUsuarios() {
		return em.createNamedQuery("Usuario.findAll", Usuario.class)
				.getResultList();
	}
	@Override
	public Usuario consultarUsuario(String id) {
		return em.find(Usuario.class,id);
	}
}
