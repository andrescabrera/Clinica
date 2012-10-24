package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Paciente;
import com.cabrera.clinica.domain.repositories.RepositorioDePacientes;

public class RepositorioDePacientesJPA extends BaseRepositoryJPA<Paciente, Long> implements RepositorioDePacientes {
	
	private static final String sqlDeletePaciente = "DELETE FROM paciente";
	private static final String sqlSelectPacientes = "SELECT p FROM paciente p";
	
	public void removeAll() {
		entityManager.createQuery(sqlDeletePaciente).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Paciente> findAll() {
		return entityManager.createQuery(sqlSelectPacientes).getResultList();
	}
}