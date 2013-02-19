package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Telefono;
import com.cabrera.clinica.domain.repositories.RepositorioDeTelefonos;

@Service("telefonoService")
@Transactional
public class TelefonoService {
	
	@Autowired
	@Qualifier("repositorioDeTelefonos")
	private RepositorioDeTelefonos repositorio;
	
	public Telefono saveOrUpdate(Telefono entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Telefono> findAll() {
		return repositorio.findAll();
	}
	
	public Telefono findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Telefono entity) {
		repositorio.remove(entity);
	}
}
