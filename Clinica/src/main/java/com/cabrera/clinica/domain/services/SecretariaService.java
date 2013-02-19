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
	
	public Secretaria saveOrUpdate(Secretaria entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Secretaria> findAll() {
		return repositorio.findAll();
	}
	
	public Secretaria findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Secretaria entity) {
		repositorio.remove(entity);
	}
	
}
