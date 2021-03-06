package com.cabrera.clinica.domain;

import java.util.Collection;
import java.util.Date;

public abstract class Empresa {

	private Long id;
	private String cuit;
	private String razonSocial;
	private String tipoEmpresa;
	private Collection<Telefono> telefonos;
	private Double saldo;
	
	private Date alta;
	private Date baja;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void agregarTelefono(Telefono telefono) {
		this.telefonos.add(telefono);
	}
	
	public void removerTelefono(Telefono telefono) {
		this.telefonos.remove(telefono);
	}
	
	public Collection<Telefono> getTelefonos() {
		return telefonos;
	}
	
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Date getBaja() {
		return baja;
	}

	public void setBaja(Date baja) {
		this.baja = baja;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}
}
