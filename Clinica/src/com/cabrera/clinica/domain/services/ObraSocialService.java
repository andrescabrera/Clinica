package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.ObraSocial;
import com.cabrera.clinica.domain.repositories.RepositorioDeObrasSociales;

@Service("obraSocialService")
@Transactional
public class ObraSocialService {
	
	@Autowired
	@Qualifier("repositorioDeObrasSociales")
	private RepositorioDeObrasSociales repositorio;
	
	public ObraSocial guardar(ObraSocial entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<ObraSocial> listar() {
		return repositorio.findAll();
	}
	
	public ObraSocial obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public void borrar(ObraSocial entity) {
		repositorio.remove(entity);
	}
}
