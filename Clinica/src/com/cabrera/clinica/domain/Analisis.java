package com.cabrera.clinica.domain;

import java.util.Date;

public class Analisis extends ContraPrestacion {
	private Medico medico;
	private Paciente paciente;
	private Date fecha;
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Analisis [fecha=");
		builder.append(fecha);
		builder.append("]");
		return builder.toString();
	}
	
}
