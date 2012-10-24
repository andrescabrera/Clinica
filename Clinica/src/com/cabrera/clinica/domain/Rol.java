package com.cabrera.clinica.domain;

//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name = "ROL_TYPE")
public abstract class Rol {

//	@GeneratedValue(generator = "IdGenerator", strategy = GenerationType.TABLE)
//	@Id
//	@TableGenerator(name = "IdGenerator",
//	pkColumnValue = "ROL_ID",
//	table="Sequence_Table",
//	allocationSize=1 )
	private Long id;
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JoinColumn(name="PERSONA_ID")
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
