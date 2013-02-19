package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Secretaria;
import com.cabrera.clinica.domain.repositories.RepositorioDeSecretarias;

@Repository
public class RepositorioDeSecretariasJPA extends BaseRepositoryJPA<Secretaria, Long> implements RepositorioDeSecretarias {
	
	private static final String sqlDeleteSecretarias = "DELETE FROM secretarias";
	private static final String sqlSelectSecretarias = "SELECT s FROM secretarias s";
	
	public void removeAll() {
		entityManager.createQuery(sqlDeleteSecretarias).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Collection<Secretaria> findAll() {
		return entityManager.createQuery(sqlSelectSecretarias).getResultList();
	}
}