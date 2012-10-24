package com.cabrera.clinica.domain;

import java.util.Collection;

public interface Cobrable {
	Collection<Pago> getPagos();
	void addPago(Pago pago);
	Double getMontoAPagar();
	void setMontoAPagar(Double montoAPagar);	
}
