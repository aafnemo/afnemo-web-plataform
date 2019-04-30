package com.afnemo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.eclipse.persistence.exceptions.QueryException;

import com.afnemo.commons.Logs;
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

public class TipoUsuarioDao extends Logs implements TipoUsuarioDaoInterface {
	private static final String PERSISTENCEUNITNAME = "afnemo";
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory(PERSISTENCEUNITNAME);
	private static EntityManager em = emf.createEntityManager();
	
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public TipoUsuarioDao() {

		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENCEUNITNAME);
			em = emf.createEntityManager();
			log.info(
					"Unidad de persistencia en TipoUsuarioDao Creada satisfactoriamente");

		} catch (PersistenceException pe) {
			Throwable th = pe.getCause();
			log.fatal(
					"Error al crear entidades de persistencia en TipoUsuarioDao"
							+ EXCEPTION_STRING + pe.getMessage());
			log.trace("" + EXCEPTION_STRING + th.getMessage());
		}

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

			log.trace("Error al actualizar el tipo de usuario "
					+ tipoUsuario.getDetalle() + EXCEPTION_STRING
					+ th.getMessage());

			log.trace("Error al crear el Tipo de Usuario" + EXCEPTION_STRING
					+ th.getMessage());

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
	public List<TipoUsuario> findAll() {
		List<TipoUsuario> tiposUsuario;
		try {
			tiposUsuario = em
					.createNamedQuery("TipoUsuario.findAll", TipoUsuario.class)
					.getResultList();
		} catch (QueryException e) {
			log.error("Error al extrar información de la base de datos: "
					+ e.getMessage());
			tiposUsuario = null;
		}
		return tiposUsuario;
	}
}