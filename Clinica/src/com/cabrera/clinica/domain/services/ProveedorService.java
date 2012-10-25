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
	
	public Proveedor guardar(Proveedor entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Proveedor> listar() {
		return repositorio.findAll();
	}
	
	public Proveedor obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public void borrar(Proveedor entity) {
		repositorio.remove(entity);
	}
}
