package com.afnemo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory(PERSISTENCEUNITNAME);
	private EntityManager em = emf.createEntityManager();
	private static final String EXCEPTION_STRING = "EXCEPTION STRING: ";
	public PersonaDao() {

		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENCEUNITNAME);
			em = emf.createEntityManager();
			log.info(
					"Unidad de persistencia en PersonaDao Creada satisfactoriamente");

		} catch (PersistenceException pe) {
			Throwable th = pe.getCause();
			log.fatal("Error al crear entidades de persistencia en PersonaDao"
					+ EXCEPTION_STRING + pe.getMessage());
			log.trace("" + EXCEPTION_STRING + th.getMessage());
		}

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
		return em.createNamedQuery("Persona.findAll", Persona.class)
				.getResultList();
	}
	@Override
	public Persona consultarPorId(String id) {
		Persona persona;
		try {
			log.debug("consultar por id: " + id);
			persona = em.find(Persona.class, id);
			log.info(persona.getApellido1());
		} catch (Exception e) {
			log.error(e);
			log.error(e.getMessage());
			persona = null;
		}
		return persona;
	}
	public List<Persona> consultarPersonasActivas() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Persona> q = cb.createQuery(Persona.class);
		Root<Persona> persona = q.from(Persona.class);
		q.select(persona).where(cb.equal(persona.get("estado"), true));
		return em.createQuery(q).getResultList();
	}

}
