package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Secretaria;
import com.cabrera.clinica.domain.repositories.RepositorioDeSecretarias;

@Service("secretariaService")
@Transactional
public class SecretariaService {
	
	@Autowired
	@Qualifier("repositorioDeSecretarias")
	private RepositorioDeSecretarias repositorio;
	
	public Secretaria guardar(Secretaria entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Secretaria> listar() {
		return repositorio.findAll();
	}
	
	public Secretaria obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public void borrar(Secretaria entity) {
		repositorio.remove(entity);
	}
	
}
