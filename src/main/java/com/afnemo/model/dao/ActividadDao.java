package com.afnemo.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import com.afnemo.model.interfaces.ActividadDaoInterface;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: Actividad.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class ActividadDao implements ActividadDaoInterface {
	private static final String persistenceUnitName = "afnemo";
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private final Logger log = Logger.getLogger(getClass());
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public ActividadDao() {
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
			log.debug(
					"Unidad de persistencia en TipoUsuarioDao Creada satisfactoriamente");

		} catch (PersistenceException pe) {
			Throwable th = pe.getCause();
			log.error(
					"Error al crear entidades de persistencia en TipoUsuarioDao"
							+ EXCEPTION_STRING + pe.getMessage());
			log.trace("" + EXCEPTION_STRING + th.getMessage());
		}

	}
	@Override
	public void crearActividad(com.afnemo.model.dto.Actividad actividad) {
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

}
