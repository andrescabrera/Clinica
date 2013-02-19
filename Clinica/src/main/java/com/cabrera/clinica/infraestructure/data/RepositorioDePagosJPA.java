package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Pago;
import com.cabrera.clinica.domain.repositories.RepositorioDePagos;

@Repository
public class RepositorioDePagosJPA extends BaseRepositoryJPA<Pago, Long> implements RepositorioDePagos {
	
	private static final String sqlDeletePagos = "DELETE FROM paciente";
	private static final String sqlSelectPagos = "SELECT p FROM paciente p";
	
	public void removeAll() {
		entityManager.createQuery(sqlDeletePagos).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Pago> findAll() {
		return entityManager.createQuery(sqlSelectPagos).getResultList();
	}
}