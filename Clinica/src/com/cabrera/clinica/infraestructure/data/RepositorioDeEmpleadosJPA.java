package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Empleado;
import com.cabrera.clinica.domain.repositories.RepositorioDeEmpleados;

public class RepositorioDeEmpleadosJPA extends BaseRepositoryJPA<Empleado, Long> implements
		RepositorioDeEmpleados {

	private static final String sqlDeleteEmpleados = "DELETE FROM empleado";
	private static final String sqlSelectEmpleados = "SELECT e FROM empleado e";
	
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
