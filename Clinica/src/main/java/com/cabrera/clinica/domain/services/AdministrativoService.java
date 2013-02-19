package com.cabrera.clinica.domain.services;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Administrativo;
import com.cabrera.clinica.domain.repositories.RepositorioDeAdministrativos;

@Service("administrativoService")
@Transactional
public class AdministrativoService {
	
	@Autowired
	@Qualifier("repositorioDeAdministrativos")
	private RepositorioDeAdministrativos repositorio;
	
	public Administrativo saveOrUpdate(Administrativo entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Administrativo> findAll() {
		return repositorio.findAll();
	}
	
	public Administrativo findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Administrativo entity) {
		repositorio.remove(entity);
	}
}
