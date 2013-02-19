package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Medico;
import com.cabrera.clinica.domain.repositories.RepositorioDeMedicos;

@Service("medicoService")
@Transactional
public class MedicoService {

	@Autowired
	@Qualifier("repositorioDeMedicos")
	private RepositorioDeMedicos repositorio;
	
	public Medico saveOrUpdate(Medico entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Medico> findAll() {
		return repositorio.findAll();
	}
	
	public Medico findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Medico entity) {
		repositorio.remove(entity);
	}
	
}
