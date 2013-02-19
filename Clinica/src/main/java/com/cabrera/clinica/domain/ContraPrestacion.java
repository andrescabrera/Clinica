package com.cabrera.clinica.domain;

import java.util.Collection;

public abstract class ContraPrestacion implements Cobrable {

	private Collection<Pago> pagos;
	private Double montoAPagar;
	private Long id;
	
	@Override
	public Collection<Pago> getPagos() {
		return pagos;
	}
	
	@Override
	public void addPago(Pago pago) {
		pagos.add(pago);		
	}
	
	@Override
	public Double getMontoAPagar() {
		return montoAPagar;
	}

	@Override
	public void setMontoAPagar(Double montoAPagar) {
		this.montoAPagar = montoAPagar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
}
