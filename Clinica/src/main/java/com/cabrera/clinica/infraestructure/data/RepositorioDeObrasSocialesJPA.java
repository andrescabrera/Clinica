package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.ObraSocial;

@Repository
public class RepositorioDeObrasSocialesJPA extends BaseRepositoryJPA<ObraSocial, Long> implements
		com.cabrera.clinica.domain.repositories.RepositorioDeObrasSociales {
	
	private static final String sqlDeleteObrasSociales = "DELETE FROM obraSocial";
	private static final String sqlSelectObrasSociales = "SELECT o FROM obraSocial o";
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<ObraSocial> findAll() {
		return entityManager.createQuery(sqlSelectObrasSociales).getResultList();
	}

	public void removeAll() {
		entityManager.createQuery(sqlDeleteObrasSociales).executeUpdate();
	}
	
}
