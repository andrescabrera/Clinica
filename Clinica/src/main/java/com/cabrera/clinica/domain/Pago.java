package com.cabrera.clinica.domain;

import java.util.Date;

public class Pago {
	private Date fecha;
	private Double monto;
	private ObraSocial obraSocial;
	private Cobrable contraPrestacion;
	private Long id;
	
	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Cobrable getContraPrestacion() {
		return contraPrestacion;
	}

	public void setContraPrestacion(Cobrable contraPrestacion) {
		this.contraPrestacion = contraPrestacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
