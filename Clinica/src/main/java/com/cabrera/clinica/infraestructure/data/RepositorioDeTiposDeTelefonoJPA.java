package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.TipoTelefono;

@Repository
public class RepositorioDeTiposDeTelefonoJPA extends
		BaseRepositoryJPA<TipoTelefono, Long> implements
		com.cabrera.clinica.domain.repositories.RepositorioDeTiposDeTelefono {

	private static final String sqlSelectTipos = "SELECT t FROM tipoTelefono t";
	private static final String sqlDeleteTipos = "DELETE FROM tipoTelefono";

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Collection<TipoTelefono> findAll() {
		return entityManager.createQuery(sqlSelectTipos).getResultList();
	}

	public void removeAll() {
		entityManager.createQuery(sqlDeleteTipos).executeUpdate();
	}

}