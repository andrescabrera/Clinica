package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.TipoTelefono;
import com.cabrera.clinica.domain.repositories.RepositorioDeTiposDeTelefono;

@Service("tipoDeTelefonoService")
@Transactional
public class TiposDeTelefonosService {
	
	@Autowired
	@Qualifier("repositorioDeTiposDeTelefono")
	private RepositorioDeTiposDeTelefono repositorio;
	
	public TipoTelefono saveOrUpdate(TipoTelefono entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<TipoTelefono> findAll() {
		return repositorio.findAll();
	}
	
	public TipoTelefono findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(TipoTelefono entity) {
		repositorio.remove(entity);
	}
}
