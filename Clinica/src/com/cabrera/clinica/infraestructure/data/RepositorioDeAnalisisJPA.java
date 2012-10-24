package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Analisis;
import com.cabrera.clinica.domain.repositories.RepositorioDeAnalisis;

@Repository
public class RepositorioDeAnalisisJPA extends BaseRepositoryJPA<Analisis, Long> implements RepositorioDeAnalisis {
	
	private static final String sqlDeleteAnalisis = "DELETE FROM analisis";
	private static final String sqlSelectAnalisis = "SELECT e FROM analisis e";
	
	public void removeAll() {
		entityManager.createQuery(sqlDeleteAnalisis).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Collection<Analisis> findAll() {
		return entityManager.createQuery(sqlSelectAnalisis).getResultList();
	}
}