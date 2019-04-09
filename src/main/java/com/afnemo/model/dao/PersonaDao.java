package com.afnemo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import com.afnemo.commons.Logs;
import com.afnemo.model.dto.Persona;
import com.afnemo.model.interfaces.PersonaDaoInterface;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: PersonaDao.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class PersonaDao extends Logs implements PersonaDaoInterface {
	private static final String PERSISTENCEUNITNAME = "afnemo";
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory(PERSISTENCEUNITNAME);
	private static EntityManager em = emf.createEntityManager();
	private final Logger log = Logger.getLogger(getClass());
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public PersonaDao() {
		// default implementation not used
	}
	@Override
	public void crearPersona(Persona persona) {
		try {
			em.getTransaction().begin();
			em.persist(persona);
			em.getTransaction().commit();
			em.close();
			log.info("Se crea Persona con Id: " + persona.getId());
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
			Throwable th = pe.getCause();
			log.error("Error al crear la persona con id:" + persona.getId()
					+ " " + EXCEPTION_STRING + pe.getMessage());
			log.trace("Error al crear la persona con id: " + persona.getId()
					+ " " + EXCEPTION_STRING + th.getMessage());
		}

	}

	@Override
	public void actualizarPersona(Persona persona) {
		try {
			em.getTransaction().begin();
			em.merge(persona);
			em.getTransaction().commit();
			em.close();
			log.info("Se actualiza información del tipo de usuario: "
					+ persona.getId());
		} catch (PersistenceException pe) {
			em.getTransaction().rollback();
			Throwable th = pe.getCause();
			log.error("Error al actualizar la persona con id" + persona.getId()
					+ " " + EXCEPTION_STRING + pe.getMessage());
			log.trace("Error al actualizar la persona con id" + persona.getId()
					+ " " + EXCEPTION_STRING + th.getMessage());
		}

	}
	@Override
	public List<Persona> consultarTodasPersonas() {
		return em.createNamedQuery("Persona.findAll").getResultList();
	}
	@Override
	public Persona consultarPorId(String id) {
		// 
		return null;
	}

}
