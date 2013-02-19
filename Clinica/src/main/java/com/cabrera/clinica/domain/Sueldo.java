package com.cabrera.clinica.domain;

public class Sueldo {
	private Double neto;
	private Double bruto;

	public Double getNeto() {
		return neto;
	}

	public void setNeto(Double neto) {
		this.neto = neto;
	}

	public Double getBruto() {
		return bruto;
	}

	public void setBruto(Double bruto) {
		this.bruto = bruto;
	}

	@Override
	public String toString() {
		return "Sueldo [neto=" + neto + ", bruto=" + bruto + "]";
	}

	public Sueldo() {
	}	
	
	public Sueldo(Double neto, Double bruto) {
		super();
		this.neto = neto;
		this.bruto = bruto;
	}	
	
	
}
