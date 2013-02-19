package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Liquidacion;
import com.cabrera.clinica.domain.repositories.RepositorioDeLiquidaciones;

@Repository
public class RepositorioDeLiquidacionesJPA extends BaseRepositoryJPA<Liquidacion, Long> implements
		RepositorioDeLiquidaciones {

	private static final String sqlDeleteLiquidaciones = "DELETE FROM liquidacion";
	private static final String sqlSelectLiquidaciones = "SELECT l FROM liquidacion l";
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Liquidacion> findAll() {
		return entityManager.createQuery(sqlSelectLiquidaciones).getResultList();
	}

	public void removeAll() {
		entityManager.createQuery(sqlDeleteLiquidaciones).executeUpdate();
	}

}
