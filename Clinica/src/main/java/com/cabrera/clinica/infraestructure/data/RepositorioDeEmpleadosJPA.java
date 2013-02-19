package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Empleado;
import com.cabrera.clinica.domain.repositories.RepositorioDeEmpleados;

@Repository
public class RepositorioDeEmpleadosJPA extends BaseRepositoryJPA<Empleado, Long> implements
		RepositorioDeEmpleados {

	private static final String sqlDeleteEmpleados = "DELETE FROM Empleado";
	private static final String sqlSelectEmpleados = "SELECT e FROM Empleado e";
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Empleado> findAll() {
		return entityManager.createQuery(sqlSelectEmpleados).getResultList();
	}

	public void removeAll() {
		entityManager.createQuery(sqlDeleteEmpleados).executeUpdate();
	}

}
