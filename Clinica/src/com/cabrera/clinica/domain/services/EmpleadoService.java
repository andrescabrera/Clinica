package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Empleado;
import com.cabrera.clinica.domain.repositories.RepositorioDeEmpleados;

@Service("empleadoService")
@Transactional
public class EmpleadoService {
	
	@Autowired
	@Qualifier("repositorioDeEmpleados")
	private RepositorioDeEmpleados repositorio;
	
	public Empleado guardar(Empleado entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Empleado> listar() {
		return repositorio.findAll();
	}
	
	public Empleado obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public void borrar(Empleado entity) {
		repositorio.remove(entity);
	}
	
}
