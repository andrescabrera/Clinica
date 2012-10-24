package com.cabrera.clinica.domain;

import java.util.Collection;

public class Medico extends Empleado {

	private Long matricula;
	
	private Collection<Analisis> analisis;
	
	private Collection<Turno> turnos;

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Collection<Analisis> getAnalisis() {
		return analisis;
	}

	public void setAnalisis(Collection<Analisis> analisis) {
		this.analisis = analisis;
	}

	public Collection<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Collection<Turno> turnos) {
		this.turnos = turnos;
	}	

}
