package com.cabrera.clinica.domain;

import java.util.Collection;

public class Paciente extends Rol {
	
	public Paciente () {}
	
	private Collection<Cobrable> contraPrestaciones;
	
	public Collection<Cobrable> getContraPrestaciones() {
		return contraPrestaciones;
	}

	public void setContraPrestaciones(Collection<Cobrable> contraPrestaciones) {
		this.contraPrestaciones = contraPrestaciones;
	}
	
	public void agregarContraPrestacion(Cobrable c) { 
		contraPrestaciones.add(c);		
	}
	
	public void listarContraPrestaciones() {
		for(Cobrable c : contraPrestaciones) {
			if(c instanceof Turno) {
				System.out.println("Fecha del turno: " + ((Turno)c).getFecha() + " Precio: " + ((Turno)c).getMontoAPagar());
			} else { 
				System.out.println("Fecha del analisis: " + ((Analisis)c).getFecha() + " Precio: " + ((Analisis)c).getMontoAPagar());
			}
			
		}
	}	
}
