package com.cabrera.clinica.domain.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Empleado;
import com.cabrera.clinica.domain.Liquidacion;
import com.cabrera.clinica.domain.repositories.RepositorioDeLiquidaciones;


@Service("liquidacionesService")
@Transactional
public class LiquidacionesService {
	
	@Autowired
	@Qualifier("repositorioDeLiquidaciones")
	private RepositorioDeLiquidaciones repositorio;
	
	@Autowired
	@Qualifier("empleadoService")
	private EmpleadoService servicioEmpleado;
	
	public Liquidacion saveOrUpdate(Liquidacion l){
		return repositorio.saveOrUpdate(l); 
	}
	
	public Collection<Liquidacion> findAll() {
		return repositorio.findAll();
	}
	
	public Liquidacion findById(Long id) {
		return repositorio.findById(id);
	}
	
	public void remove(Liquidacion l) {
		repositorio.remove(l);
	}
	
	public Liquidacion liquidarCierreDeMes (Liquidacion liquidacion) {
		
		for(Empleado e : servicioEmpleado.findAll()) {
			liquidacion.liquidarEmpleado(e);
		}
		
		return liquidacion;		
	}	
}
