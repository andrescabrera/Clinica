package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Medico;
import com.cabrera.clinica.domain.repositories.RepositorioDeMedicos;

public class RepositorioDeMedicosJPA extends BaseRepositoryJPA<Medico, Long> implements
		RepositorioDeMedicos {

	private static final String sqlDeleteMedico = "DELETE FROM medico";
	private static final String sqlSelectMedico = "SELECT l FROM medico l";
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Medico> findAll() {
		return entityManager.createQuery(sqlSelectMedico).getResultList();
	}

	public void removeAll() {
		entityManager.createQuery(sqlDeleteMedico).executeUpdate();
	}

}
