package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Proveedor;
import com.cabrera.clinica.domain.repositories.RepositorioDeProveedores;

@Repository
public class RepositorioDeProveedoresJPA extends BaseRepositoryJPA<Proveedor, Long> implements RepositorioDeProveedores {
	
	private static final String sqlDeleteProveedores = "DELETE FROM proveedor";
	private static final String sqlSelectProveedores = "SELECT p FROM proveedor";
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Proveedor> findAll() {
		return entityManager.createQuery(sqlSelectProveedores).getResultList();
	}

	public void removeAll() {
		entityManager.createQuery(sqlDeleteProveedores).executeUpdate();
	}
	
}