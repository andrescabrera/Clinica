package com.cabrera.clinica.domain;

import java.util.Collection;
//import javax.persistence.*;

//@Entity
public class Persona {
	
//	@Id
//	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellido;
	private String direccion;
	private String documento;
	
//	@OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
	private Collection<Rol> roles;
	
//	@OneToMany
	private Collection<Telefono> telefonos;
	
	public Persona () {}
	
	public Persona (Collection<Telefono> telefonos, Collection<Rol> roles) {
		this.telefonos = telefonos;
		this.roles = roles;
	}	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Telefono> getTelefonos() {
		return telefonos;
	}
	
	public void setTelefonos(Collection<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	public void agregarTelefono(Telefono telefono) {
		this.telefonos.add(telefono);
	}
	
	public void removerTelefono(Telefono telefono) {
		this.telefonos.remove(telefono);
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public void agregarRol(Rol rol) {
		roles.add(rol);		
	}
	
	public void removerRol(Rol rol) {
		roles.remove(rol);		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Persona [id=");
		sb.append(id);
		sb.append(" nombre=");
		sb.append(nombre);
		sb.append(", apellido=");
		sb.append(apellido);
		sb.append(", direccion=");
		sb.append(direccion);
		sb.append(", documento=");
		sb.append(documento);
		sb.append(", roles=");
		sb.append(roles);
		sb.append(", telefonos=");
		sb.append(telefonos);
		sb.append("]");
		
		for(Rol rol : roles) {
			sb.append(rol);			
		}
		return sb.toString();
	}	
}