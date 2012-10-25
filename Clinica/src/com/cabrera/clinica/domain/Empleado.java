package com.cabrera.clinica.domain;

public abstract class Empleado extends Rol {

	private Long legajo;

	private Sueldo sueldo;

	private Area area;

	public Empleado() {
	}

	public Empleado(Sueldo sueldoActual, Area area) {
		this.sueldo = sueldoActual;
		this.area = area;
	}

	public Sueldo getSueldo() {
		return sueldo;
	}

	public void setSueldo(Sueldo sueldoActual) {
		this.sueldo = sueldoActual;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Long getLegajo() {
		return legajo;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public Double getSueldoBrutoActual() {
		return sueldo.getBruto();
	}

	public Double getSueldoNetoActual() {
		return sueldo.getNeto();
	}
	
	public void setSueldoBrutoActual (Double sueldoBruto) {
		sueldo.setBruto(sueldoBruto);		
	}
	
	public void setSueldoNetoActual (Double sueldoNeto) {
		sueldo.setNeto(sueldoNeto);
	}

	@Override
	public String toString() {
		return legajo.toString();
	}
	
}
