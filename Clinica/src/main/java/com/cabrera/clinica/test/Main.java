package com.cabrera.clinica.test;

import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabrera.clinica.domain.Analisis;
import com.cabrera.clinica.domain.Liquidacion;
import com.cabrera.clinica.domain.Paciente;
import com.cabrera.clinica.domain.Persona;
import com.cabrera.clinica.domain.Secretaria;
import com.cabrera.clinica.domain.Telefono;
import com.cabrera.clinica.domain.Turno;
import com.cabrera.clinica.domain.repositories.RepositorioDeLiquidaciones;
import com.cabrera.clinica.domain.repositories.RepositorioDeSecretarias;
import com.cabrera.clinica.domain.repositories.RepositorioDeTurnos;
import com.cabrera.clinica.domain.services.PacienteService;
import com.cabrera.clinica.domain.services.PersonaService;
import com.cabrera.clinica.domain.services.TelefonoService;

/**
 * Sistema de Administraci�n de Clinica Medica 
 * Demostraci�n de la persistencia y del funcionamiento del modelo.
 * 
 * @author acabrera
 * 
 */
public class Main {

	/**
	 * @param args
	 *            ninguno
	 */
	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		Persona pepino = (Persona) appContext.getBean("persona");
		pepino.setApellido("Cabrera");
		pepino.setDireccion("Alsina 178");
		pepino.setNombre("Andres");
		pepino.setDocumento("31998243");
		Paciente pacientePepe = (Paciente) appContext.getBean("paciente");

		pepino.agregarRol(pacientePepe);
		pacientePepe.setPersona(pepino);

		Turno turno = (Turno) appContext.getBean("turno");
		Analisis analisis = (Analisis) appContext.getBean("analisis");
		turno.setFecha(new Date());
		turno.setPaciente(pacientePepe);
		turno.setMontoAPagar(5500d);
		analisis.setFecha(new Date());
		analisis.setMontoAPagar(3440d);

		pacientePepe.agregarContraPrestacion(analisis);
		pacientePepe.agregarContraPrestacion(turno);
		System.out.println("Persona: " + pepino);
		pacientePepe.listarContraPrestaciones();

		PacienteService pacienteService = (PacienteService) appContext.getBean("pacienteService");
		pacientePepe = pacienteService.saveOrUpdate(pacientePepe);
		
		PersonaService personaService = (PersonaService) appContext.getBean("personaService");
		pepino = personaService.saveOrUpdate(pepino);
		
		System.out.println("Id de Paciente: " + pacientePepe.getId());
		System.out.println("Levantando paciente...");
		
		Paciente siSeGuardoEsta = pacienteService.findById(pacientePepe.getId());
		System.out.println("Id del paciente guardado: "
				+ siSeGuardoEsta.getId());

		Telefono tel = (Telefono) appContext.getBean("telefono");
		tel.setNumero("123123123");
		TelefonoService telService = (TelefonoService)appContext.getBean("telefonoService");
		telService.saveOrUpdate(tel);
		
		for (Telefono t : telService.findAll()) {
			System.out.println("Tel bd: " + t.getNumero());
		}
		System.out.println("Numero de Tel: " + tel.getNumero());

		Secretaria unaSecretaria = (Secretaria) appContext
				.getBean("secretaria");
		unaSecretaria.setSueldoNetoActual(1500d);
		unaSecretaria.setSueldoBrutoActual(1400d);

		Persona doniaRamona = (Persona) appContext.getBean("persona");
		doniaRamona.setApellido("Gonzalez");
		doniaRamona.setNombre("Ramona");
		doniaRamona.setDocumento("3198212");
		doniaRamona.agregarRol(unaSecretaria);
		unaSecretaria.setPersona(doniaRamona);
		unaSecretaria.setLegajo(53231l);
		RepositorioDeSecretarias repoSecre = (RepositorioDeSecretarias) appContext
				.getBean("repositorioDeSecretarias");
		unaSecretaria = repoSecre.saveOrUpdate(unaSecretaria);

		Liquidacion liquiFinDeMes = (Liquidacion) appContext
				.getBean("liquidacion");
		liquiFinDeMes.liquidarEmpleado(unaSecretaria);

		RepositorioDeLiquidaciones repoLiquidaciones = (RepositorioDeLiquidaciones) appContext
				.getBean("repositorioDeLiquidaciones");
		liquiFinDeMes = repoLiquidaciones.saveOrUpdate(liquiFinDeMes);

		liquiFinDeMes.mostrarLiquidacion();

		unaSecretaria.setSueldoBrutoActual(10000d);
		unaSecretaria.setSueldoNetoActual(8000d);
		unaSecretaria = repoSecre.saveOrUpdate(unaSecretaria);
		liquiFinDeMes.mostrarLiquidacion();

		RepositorioDeTurnos repoTurnos = (RepositorioDeTurnos) appContext
				.getBean("repositorioDeTurnos");
		for (Turno t : repoTurnos.findAll()) {
			System.out.println("Fecha del Turno: " + t.getFecha());
			System.out.println("Nombre del paciente:  "
					+ t.getPaciente().getPersona().getNombre());
		}

	}

}
