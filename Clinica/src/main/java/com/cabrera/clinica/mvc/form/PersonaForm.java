package com.cabrera.clinica.mvc.form;

import java.util.Date;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

public class PersonaForm {
	
	private Long id;

	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombre;

	@NotEmpty
	@Size(min = 3, max = 50)
	private String apellido;
	
	@Size(min = 3, max = 50)
	private String direccion;
	
	@NotEmpty
	@Size(min = 3, max = 50)
	private String documento;
	
	@DateTimeFormat(style = "SS")
	private Date fechaBaja = new Date();
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
