package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Analisis;
import com.cabrera.clinica.domain.repositories.RepositorioDeAnalisis;

@Service("analisisService")
@Transactional
public class AnalisisService {

	@Autowired
	@Qualifier("repositorioDeAnalisis")
	private RepositorioDeAnalisis repositorio;
	
	public Analisis guardar(Analisis entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Analisis> listar() {
		return repositorio.findAll();
	}
	
	public Analisis obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public void borrar(Analisis entity) {
		repositorio.remove(entity);
	}
}
