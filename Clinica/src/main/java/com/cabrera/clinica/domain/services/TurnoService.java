package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Turno;
import com.cabrera.clinica.domain.repositories.RepositorioDeTurnos;

@Service("turnoService")
@Transactional
public class TurnoService {
	
	@Autowired
	@Qualifier("repositorioDeTurnos")
	private RepositorioDeTurnos repositorio;
	
	public Turno saveOrUpdate(Turno entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Turno> findAll() {
		return repositorio.findAll();
	}
	
	public Turno findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Turno entity) {
		repositorio.remove(entity);
	}
}
