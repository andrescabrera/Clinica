package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Proveedor;
import com.cabrera.clinica.domain.repositories.RepositorioDeProveedores;

@Service("proveedorService")
@Transactional
public class ProveedorService {
	
	@Autowired
	@Qualifier("repositorioDeProveedores")
	private RepositorioDeProveedores repositorio;
	
	public Proveedor saveOrUpdate(Proveedor entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Proveedor> findAll() {
		return repositorio.findAll();
	}
	
	public Proveedor findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Proveedor entity) {
		repositorio.remove(entity);
	}
}
