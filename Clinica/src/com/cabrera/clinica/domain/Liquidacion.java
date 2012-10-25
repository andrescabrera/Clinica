package com.cabrera.clinica.domain;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Liquidacion {

	public Liquidacion() {}
	
	public Liquidacion(Map<Empleado, Sueldo> sueldos) {
		this.sueldos = sueldos;
	}
	
	private Long id;
	private Date fecha;

	private Map<Empleado, Sueldo> sueldos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	//TODO - Alguna lógica de negocio que se me ocurre ahora
	
	public void realizarLiquidacion(Empleado empleado)
	{
		//Acá podría ir alguna validacion, si estamos en el día de la liquidacion o si esta cerrada.
		if(fecha == null)
			this.fecha = new Date();
		if(sueldos == null)
			System.out.println("Sueldos es null");
		else
			sueldos.put(empleado, empleado.getSueldo());
	}
	
	public Sueldo verSueldo (Empleado empleado) {
		return sueldos.get(empleado);		
	}
	
	public Collection<Empleado> listarEmpleados () {
		return sueldos.keySet();
	}
	
	public Collection<Sueldo> listarSueldos () {
		return sueldos.values();
	}
	
	public Double listarMontoTotalNetoLiquidacion () {
		Double montoTotal = 0d;
		for(Sueldo unSueldo : sueldos.values())
			montoTotal += unSueldo.getNeto();
		return montoTotal;
	}

	
	public void mostrarLiquidacion() {
		Iterator<Map.Entry<Empleado, Sueldo>> it = sueldos.entrySet().iterator();
		System.out.println("Liquidacion del: " + fecha.toString());
		while (it.hasNext()) {
			Map.Entry<Empleado, Sueldo> e = (Map.Entry<Empleado, Sueldo>)it.next();
			System.out.println("Empleado: " + e.getKey() + " Sueldo: " + e.getValue());
		}
	}
}