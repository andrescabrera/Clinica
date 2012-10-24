package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Persona;
import com.cabrera.clinica.domain.repositories.RepositorioDePersonas;

public class RepositorioDePersonasJPA extends BaseRepositoryJPA<Persona, Long> implements RepositorioDePersonas {
	
	private static final String sqlDeletePersonas = "DELETE FROM persona";
	private static final String sqlSelectPersonas = "SELECT p FROM persona p";
	
	public void removeAll() {
		entityManager.createQuery(sqlDeletePersonas).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Persona> findAll() {
		return entityManager.createQuery(sqlSelectPersonas).getResultList();
	}
}