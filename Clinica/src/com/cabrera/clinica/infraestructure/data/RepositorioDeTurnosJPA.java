package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Turno;
import com.cabrera.clinica.domain.repositories.RepositorioDeTurnos;

public class RepositorioDeTurnosJPA extends BaseRepositoryJPA<Turno, Long> implements
		RepositorioDeTurnos {

	private static final String sqlDeleteTurnos = "DELETE FROM Turno";
	private static final String sqlSelectTurnos = "SELECT t FROM Turno t";
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Turno> findAll() {
		return entityManager.createQuery(sqlSelectTurnos).getResultList();
	}

	public void removeAll() {
		entityManager.createQuery(sqlDeleteTurnos).executeUpdate();
	}

}
