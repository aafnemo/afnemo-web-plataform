package com.afnemo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.afnemo.commons.Logs;
import com.afnemo.model.dto.Actividad;
import com.afnemo.model.interfaces.ActividadDaoInterface;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: Actividad.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class ActividadDao extends Logs implements ActividadDaoInterface {
	private static final String PERSISTENCEUNITNAME = "afnemo";
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory(PERSISTENCEUNITNAME);
	private EntityManager em = emf.createEntityManager();
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public ActividadDao() {
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
	public void crearActividad(com.afnemo.model.dto.Actividad actividad) {
		try {
			em.getTransaction().begin();
			em.persist(actividad);
			em.getTransaction().commit();
			em.close();
			log.info("Se crea actividad con Id: " + actividad.getId());
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
			Throwable th = pe.getCause();
			log.error("Error al crear la actividad con id:" + actividad.getId()
					+ " " + actividad.getDetalle() + " " + EXCEPTION_STRING
					+ pe.getMessage());
			log.trace("Error al crear la actividad con id: " + actividad.getId()
					+ " " + actividad.getDetalle() + " " + EXCEPTION_STRING
					+ th.getMessage());
		}

	}

	@Override
	public void actualizarActividad(com.afnemo.model.dto.Actividad actividad) {
		try {
			em.getTransaction().begin();
			em.merge(actividad);
			em.getTransaction().commit();
			em.close();
			log.info("Se crea actividad con Id: " + actividad.getId());
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
			Throwable th = pe.getCause();
			log.error("Error al crear la actividad con id:" + actividad.getId()
					+ " " + actividad.getDetalle() + " " + EXCEPTION_STRING
					+ pe.getMessage());
			log.trace("Error al crear la actividad con id: " + actividad.getId()
					+ " " + actividad.getDetalle() + " " + EXCEPTION_STRING
					+ th.getMessage());
		}

	}
	@Override
	public List<Actividad> consultarActividad(int id) {
		return em.createNamedQuery("Actividad.findAll", Actividad.class)
				.getResultList();
	}

}
