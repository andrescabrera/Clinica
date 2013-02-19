package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Telefono;
import com.cabrera.clinica.domain.repositories.RepositorioDeTelefonos;

@Repository
public class RepositorioDeTelefonosJPA extends
		BaseRepositoryJPA<Telefono, Long> implements RepositorioDeTelefonos {

	private static final String sqlDeleteTelefonos = "DELETE FROM Telefono";
	private static final String sqlSelectTelefonos = "SELECT t FROM Telefono t";

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Telefono> findAll() {
		return entityManager.createQuery(sqlSelectTelefonos).getResultList();
	}

	public void removeAll() {
		entityManager.createQuery(sqlDeleteTelefonos).executeUpdate();
	}
}