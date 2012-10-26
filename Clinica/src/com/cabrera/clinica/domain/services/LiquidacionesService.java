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
	
	public Liquidacion guardar(Liquidacion l){
		return repositorio.saveOrUpdate(l); 
	}
	
	public Collection<Liquidacion> listar() {
		return repositorio.findAll();
	}
	
	public Liquidacion obtenerPorId(Long id) {
		return repositorio.findById(id);
	}
	
	public void borrar(Liquidacion l) {
		repositorio.remove(l);
	}
	
	public Liquidacion liquidarCierreDeMes (Liquidacion liquidacion) {
		
		for(Empleado e : servicioEmpleado.listar()) {
			liquidacion.liquidarEmpleado(e);
		}
		
		return liquidacion;		
	}	
}
