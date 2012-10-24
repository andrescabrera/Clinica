package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Administrativo;
import com.cabrera.clinica.domain.repositories.RepositorioDeAdministrativos;

@Repository
public class RepositorioDeAdministrativosJPA extends BaseRepositoryJPA<Administrativo, Long> implements RepositorioDeAdministrativos {
	
	private static final String sqlDeleteAdministrativos = "DELETE FROM administrativo";
	private static final String sqlSelectAdministrativos = "SELECT e FROM administrativo e";
	
	public void removeAll() {
		entityManager.createQuery(sqlDeleteAdministrativos).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Collection<Administrativo> findAll() {
		return entityManager.createQuery(sqlSelectAdministrativos).getResultList();
	}
}