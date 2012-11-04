package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Persona;
import com.cabrera.clinica.domain.repositories.RepositorioDePersonas;

@Service("personaService")
@Transactional
public class PersonaService {

	@Autowired
	@Qualifier("repositorioDePersonas")
	private RepositorioDePersonas repositorio;
	
	public Persona saveOrUpdate(Persona entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Persona> findAll() {
		return repositorio.findAll();
	}
	
	public Persona findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Persona entity) {
		repositorio.remove(entity);
	}
}
