package com.cabrera.clinica.domain;

public class Telefono {

	private Long id;
	private TipoTelefono tipo;
	private String numero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTelefono getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefono tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
