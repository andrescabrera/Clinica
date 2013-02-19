package com.cabrera.clinica.domain;

import java.util.Collection;

public class Area {
	private Long id;
	private String nombre;
	private Collection<Empleado> empleados;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Empleado> getEmpleados() {
		return empleados;
	}

	public void agregarEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}
	
	public void removerEmpleado(Empleado empleado) {
		this.empleados.remove(empleado);
	}
}
