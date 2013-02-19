package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Paciente;
import com.cabrera.clinica.domain.repositories.RepositorioDePacientes;

@Service("pacienteService")
@Transactional
public class PacienteService {
	
	@Autowired
	@Qualifier("repositorioDePacientes")
	private RepositorioDePacientes repositorio;
	
	public Paciente saveOrUpdate(Paciente entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Paciente> findAll() {
		return repositorio.findAll();
	}
	
	public Paciente findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Paciente entity) {
		repositorio.remove(entity);
	}
}
