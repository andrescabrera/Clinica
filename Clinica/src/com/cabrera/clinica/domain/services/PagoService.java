package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Pago;
import com.cabrera.clinica.domain.repositories.RepositorioDePagos;

@Service
@Transactional
public class PagoService {
	
	@Autowired
	@Qualifier("repositorioDePagos")
	private RepositorioDePagos repositorio;
	
	public Pago guardar(Pago entity){
		return repositorio.saveOrUpdate(entity); 
	}
	
	public Collection<Pago> listar() {
		return repositorio.findAll();
	}
	
	public Pago obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public void borrar(Pago entity) {
		repositorio.remove(entity);
	}

}
