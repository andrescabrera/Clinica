package com.cabrera.clinica.mvc.form;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.cabrera.clinica.domain.Administrativo;
import com.cabrera.clinica.domain.Empleado;
import com.cabrera.clinica.domain.Medico;
import com.cabrera.clinica.domain.Persona;
import com.cabrera.clinica.domain.Secretaria;
import com.cabrera.clinica.domain.Sueldo;

public class EmpleadoForm {
	
	private Long id;
	
	private PersonaForm personaForm;
	private Double sueldoNetoActual;
	private Double sueldoBrutoActual;
	
	@Size(min = 3, max = 50)
	private String horarios;
	
	private Long matricula;
	
	private Long legajo;
	
	private int tipoEmpleado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSueldoNetoActual() {
		return sueldoNetoActual;
	}

	public void setSueldoNetoActual(Double sueldoNetoActual) {
		this.sueldoNetoActual = sueldoNetoActual;
	}

	public Double getSueldoBrutoActual() {
		return sueldoBrutoActual;
	}

	public void setSueldoBrutoActual(Double sueldoBrutoActual) {
		this.sueldoBrutoActual = sueldoBrutoActual;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Long getLegajo() {
		return legajo;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public int getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public PersonaForm getPersonaForm() {
		return personaForm;
	}

	public void setPersonaForm(PersonaForm personaForm) {
		this.personaForm = personaForm;
	}

	public Empleado comoEmpleado() throws Exception {
		Empleado e = null;
		
//		TODO: Evitar este hardcodeo y el downcasting horrible!!...
		if(tipoEmpleado == 1) {
			e = new Administrativo();
			e.setTipo(1);
		} else if (tipoEmpleado == 2) {
			e = new Secretaria();
			e.setTipo(2);
		} else if (tipoEmpleado == 3) {
			e = new Medico();
			e.setTipo(3);
			Medico m = (Medico)e;
			m.setMatricula(matricula);
		} else {
			throw new Exception("Error: tipo de empleado incorrecto!");
		}
		
//		No puedo copiar las propiedades tal como hago con la persona por los campos:
//		personaForm, tipoEmpleado, etc...
		e.setId(this.id);
		e.setLegajo(legajo);
		e.setSueldo(new Sueldo(sueldoNetoActual, sueldoBrutoActual));
		
		Persona p = new Persona();
//		p.agregarRol(e);

		BeanUtils.copyProperties(personaForm, p);
		
		e.setPersona(p);
		
		return e;
	}	
	
}
